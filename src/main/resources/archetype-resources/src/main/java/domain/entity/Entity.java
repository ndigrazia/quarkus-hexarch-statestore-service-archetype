#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.entity;

import ${package}.domain.vo.Id;
import ${package}.domain.vo.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;        

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder    
public class Entity {

    @NonNull 
    private Id id;    

    private String name;
 
    private Type type;

}
