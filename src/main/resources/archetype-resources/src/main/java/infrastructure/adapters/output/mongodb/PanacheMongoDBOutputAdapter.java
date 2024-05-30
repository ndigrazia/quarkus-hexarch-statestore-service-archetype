#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.adapters.output.mongodb;

import java.util.List;

import ${package}.application.ports.output.OutputPort;
import ${package}.domain.entity.Entity;
import ${package}.domain.vo.Id;
import ${package}.infrastructure.adapters.output.mongodb.mappers.PanacheMongoDBMapper;
import ${package}.infrastructure.adapters.output.mongodb.repository.PanacheMongoDBRepository;

import io.quarkus.arc.lookup.LookupIfProperty;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
@LookupIfProperty(name = "service.implementation-name", stringValue = "panache-mongodb")
public class PanacheMongoDBOutputAdapter implements OutputPort {
 
    @Inject
    PanacheMongoDBRepository repository;

    @Override
    public Entity persist(Entity entity) {
        var doc = PanacheMongoDBMapper.toDocument(entity);
        if(doc != null) repository.persist(doc);
        return entity;
    }
    
    @Override
    public void retire(Id id) {
        repository.deleteByUuid(id);
    }

    @Override
    public Entity retrieve(Id id) {
        var doc = repository.findByUuid(id);
        return PanacheMongoDBMapper.toDomain(doc);
    }

    @Override
    public  boolean exists(Id id) {
        return repository.existsByUuid(id);
    }

    @Override
    public List<Entity> list() {
        throw new UnsupportedOperationException(
            "Unimplemented method 'list()'");
    }
}
