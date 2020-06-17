package de.akrebs.testing.stackio.logbus.client.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import de.akrebs.testing.stackio.logbus.api.EventLogger;
import de.akrebs.testing.stackio.logbus.client.impl.EventLoggerImpl;

/**
 * Client on behalf of bundle using it.
 * 
 * @author akrebs
 *
 */
public class Activator implements BundleActivator {

    private ServiceRegistration<EventLogger> reg;

    @Override
    public void start(BundleContext context) throws Exception {
	
	System.out.println("logbus-client: starting..");
	
	// Register Logstash as consumer of log events.
	this.reg = context.registerService(EventLogger.class, new EventLoggerImpl(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
	
	System.out.println("logbus-client: stoping..");

	if (this.reg != null) {

	    // Un-register log client
	    context.ungetService(reg.getReference());
	    this.reg = null;
	}
    }

}
