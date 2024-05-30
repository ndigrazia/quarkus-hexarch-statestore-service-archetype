#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.adapters.output.dapr;

import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import ${package}.application.ports.output.OutputPort;
import ${package}.domain.entity.Entity;
import ${package}.domain.vo.Id;
import ${package}.infrastructure.util.DaprUtil;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.dapr.client.domain.State;
import io.dapr.exceptions.DaprException;

import io.opentelemetry.instrumentation.annotations.WithSpan;

import io.quarkiverse.dapr.core.SyncDaprClient;
import io.quarkus.arc.lookup.LookupIfProperty;

@ApplicationScoped
@LookupIfProperty(name = "service.implementation-name", stringValue = "dapr")
public class DaprOutputAdapter implements OutputPort {

    @Inject
    SyncDaprClient dapr;

    @ConfigProperty(name = "quarkus.dapr.store.name", 
    defaultValue = DaprUtil.STATE_STORE_DEFAULT)
    String stateStoreName;

    @Override
    @WithSpan("persistOnStateStore")
    public Entity persist(Entity e) {
        if (e == null) return null;
        dapr.saveState(stateStoreName, 
            e.getId().getUuid().toString(), e);
        return e;
    }

    @Override
    public void retire(Id id) {
        dapr.deleteState(stateStoreName, id.getUuid().toString());
    }

    @Override
    public Entity retrieve(Id id) {
        try {
            State<Entity> e = dapr.getState(stateStoreName,
                    id.getUuid().toString(), Entity.class);
            return e.getValue();
        } catch (DaprException e) {
           if(e.getMessage().contains("No content")) return null;
           throw   e;
        }
    }

    @Override
    public  boolean exists(Id id) {
       return retrieve(id) != null;
    }

    @Override
    public List<Entity> list() {
        throw new UnsupportedOperationException(
            "Unimplemented method 'list()'");
    }
    
}