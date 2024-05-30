#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.usescases;

import java.util.List;

import ${package}.domain.entity.Entity;
import ${package}.domain.vo.Id;

public interface UseCase {  
      
    public Entity add(Entity e);

    public void retire(Id id);

    public Entity retrieve(Id id);

    public Entity persist(Entity e);

    public boolean exists(Id id);

    public List<Entity> list();
    
}