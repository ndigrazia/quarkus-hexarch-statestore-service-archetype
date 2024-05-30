#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.adapters.output.mongodb.mappers;

import ${package}.domain.entity.Entity;
import ${package}.domain.vo.Id;
import ${package}.domain.vo.Type;
import ${package}.infrastructure.adapters.output.mongodb.data.Document;

public class PanacheMongoDBMapper {
    
    public static Document toDocument(Entity domain) {
        if(domain == null) return null;
        
        var data = new Document();

        data.uuid = domain.getId().getUuid().toString();
        data.name = domain.getName();
        data.type = domain.getType().toString();

        return data;
    }

    public static Entity toDomain(Document doc) {
        if(doc == null) return null;

        var domain = Entity.builder()
            .id(Id.generateWith(doc.uuid))
            .name(doc.name)
            .type(Type.valueOf(doc.type))
           .build();

        return domain;
    }

}
