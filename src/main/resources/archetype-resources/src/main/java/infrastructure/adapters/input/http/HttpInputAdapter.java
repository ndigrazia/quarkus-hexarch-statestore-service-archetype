#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.adapters.input.http;

import org.jboss.logging.Logger;

import ${package}.application.usescases.UseCase;
import ${package}.domain.entity.Entity;
import ${package}.domain.exception.BaseException;
import ${package}.util.Util;

import org.eclipse.microprofile.metrics.annotation.Counted;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("${url-path}")
public class HttpInputAdapter {
    
    private static final Logger LOG = Logger.getLogger(HttpInputAdapter.class);

    @Inject
    UseCase useCase;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Counted(description = "How many entities return", name = "numberCounted")
    public Response add(Entity entity) {
        try {
            LOG.info("Add a new entity: " + Util.toJson(entity));
            var added = useCase.add(entity);
            useCase.persist(added);
            LOG.info("Entity added: " + Util.toJson(added));
            
            return  Response.status(Response.Status.CREATED).entity(entity).build();
        } catch (BaseException e) {
            LOG.error("Entity not added: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(e.toJson()).build();
        } catch (Exception e) {
            LOG.error("Entity not added: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(e).build();
        }
    }
    
}
