#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.ports.output;

import java.util.List;

import ${package}.domain.entity.Entity;
import ${package}.domain.vo.Id;

public interface OutputPort {

    public Entity persist(Entity e);
      
    public void retire(Id id);

    public Entity retrieve(Id id);

    public boolean exists(Id id);

    public List<Entity> list();
    
}
