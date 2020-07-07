package de.akrebs.stackio.provider.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import de.akrebs.stackio.registry.api.DomainServiceRegistry;
import de.akrebs.stackio.registry.api.Provider;
import de.akrebs.stackio.registry.api.ServiceRegistration;

/**
 * This class acts like a bundle activator, registering its services with the
 * global membus.
 * 
 * @author akrebs
 *
 */
@Component
public class ServiceRegistratorComponent {

    @Reference
    DomainServiceRegistry memBus;

    Provider p = new Provider() {
    };

    ServiceRegistration sr;

    // Scan for provided services and register with the domain controller
    @Activate
    public void startServing() {
	System.out.println("ServiceRegistrator: starting..");
	sr = memBus.registerService(p);
	System.out.println("Registered service P!");
    }

    public void stop() {
	System.out.println("ServiceRegistrator: stopping..");
	if (sr != null) {
	    memBus.unregisterService(sr);
	}
    }
}
