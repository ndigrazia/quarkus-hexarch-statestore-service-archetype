#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.healthchecks;

import jakarta.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import org.eclipse.microprofile.health.Readiness;

import ${package}.infrastructure.healthchecks.providers.ReadinessProvider;

import jakarta.enterprise.inject.Instance;

@Readiness
public class ReadinessCheck implements HealthCheck {
    
    @Inject
    Instance<ReadinessProvider> readinessProvider;

    public HealthCheckResponse call() {
        return readinessProvider.get().call();
    }

}