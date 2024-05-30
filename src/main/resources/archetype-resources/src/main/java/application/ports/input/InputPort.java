#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.ports.input;

import java.util.List;

import ${package}.application.ports.output.OutputPort;
import ${package}.application.usescases.UseCase;
import ${package}.domain.entity.Entity;
import ${package}.domain.exception.BaseException;
import ${package}.domain.service.Service;
import ${package}.domain.vo.Id;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@ApplicationScoped
public class InputPort implements UseCase {

    @Inject
    Instance<OutputPort> outputPort;

    @Override
    public Entity add(Entity e) {
        return Service.add(e);
    } 

    @Override
    public Entity persist(Entity e) {
        if (!exists(e.getId()))
            return outputPort.get().persist(e);  
            
        throw BaseException.create("Entity already exists");
    }

    @Override
    public void retire(Id id) {
        outputPort.get().retire(id);
    }

    @Override
    public Entity retrieve(Id id) {
        return outputPort.get().retrieve(id);
    }
    
    @Override
    public boolean exists(Id id) {  
        return outputPort.get().exists(id);
    }

    @Override
    public List<Entity> list() {
        var list = outputPort.get().list();
        return Service.list(list);
    }
    
}
