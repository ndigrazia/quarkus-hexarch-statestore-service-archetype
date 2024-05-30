#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.adapters.output.mongodb.data;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="${collection-name}")
public class Document {
  
    public ObjectId id;

    public String uuid;

    public String name;
 
    public String type;

}
