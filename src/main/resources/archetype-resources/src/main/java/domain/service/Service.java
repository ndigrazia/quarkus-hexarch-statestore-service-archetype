#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.service;

import java.util.List;

import ${package}.domain.entity.Entity;
import ${package}.domain.entity.factory.EntityFactory;
import ${package}.domain.vo.Id;
import ${package}.domain.vo.Type;

public class Service {

     public static Entity add(
        String name,
        Type type
    ) {
        return EntityFactory.create(name, type);
    }

    public static Entity add(Entity e) {
        e.setId(Id.generate());
        return e;
    }

    public static List<Entity> list(List<Entity> entities) {
        return entities.stream().filter(e -> e.getType().equals(Type.B)).toList();
    }
    
}
