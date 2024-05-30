#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.healthchecks.providers;

import org.eclipse.microprofile.health.HealthCheckResponse;

public interface ReadinessProvider {
 
     public HealthCheckResponse call();
}
