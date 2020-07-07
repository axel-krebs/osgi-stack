package de.akrebs.stackio.registry.api;

import org.osgi.annotation.versioning.ConsumerType;

/**
 * <p>
 * 
 * </p>
 * 
 * @see ConsumerType
 * @since 1.0
 */
@ConsumerType
public interface DomainServiceRegistry {

    ServiceRegistration registerService(Provider p);

    void unregisterService(ServiceRegistration lease);

}
