#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.entity.factory;

import ${package}.domain.entity.Entity;
import ${package}.domain.vo.Id;
import ${package}.domain.vo.Type;

public class EntityFactory {

    public static Entity create(String name, Type type) {
        return Entity.builder().id(Id.generate()).name(name).type(type).build();
    }

}
