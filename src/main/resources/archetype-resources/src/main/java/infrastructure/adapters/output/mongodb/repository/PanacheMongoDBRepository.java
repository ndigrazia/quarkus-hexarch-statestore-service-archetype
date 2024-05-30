#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.adapters.output.mongodb.repository;

import ${package}.domain.vo.Id;
import ${package}.infrastructure.adapters.output.mongodb.data.Document;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheMongoDBRepository implements PanacheMongoRepository<Document> {
    
    public Document findByUuid(Id id){
        return find("uuid", uuid(id)).firstResult();
    }

    public void deleteByUuid(Id id){
       delete(find("uuid", uuid(id)).firstResult());
    }

    public boolean existsByUuid(Id id){
        return findByUuid(id) != null;
    }

    private String uuid(Id id){
        if(id == null)
            throw new IllegalArgumentException("Id cannot be null") ;
        return id.getUuid().toString();
    }

}
