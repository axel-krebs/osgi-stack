package de.akrebs.stackio.provider.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import de.akrebs.stackio.provider.impl.ServiceRegistratorComponent;

public class Activator implements BundleActivator {

    ServiceReference<ServiceRegistratorComponent> ref;

    @Override
    public void start(BundleContext context) throws Exception {
	System.out.println("Activator: starting ServiceRegistratorComponent");
	ref = context.getServiceReference(ServiceRegistratorComponent.class);
	ServiceRegistratorComponent service = context.getService(ref);
	service.startServing();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
	System.out.println("Activator: stopping ServiceRegistratorComponent");
	ServiceRegistratorComponent service = context.getService(ref);
	if (service != null) {
	    service.stop();
	}
    }

}
