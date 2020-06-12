package de.akrebs.testing.stackio.logbus.logstash.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import de.akrebs.testing.stackio.logbus.api.EventLogger;
import de.akrebs.testing.stackio.logbus.logstash.impl.EventLoggerImpl;

/**
 * Typical OSGi tasks: Register Logstash, Configure logging
 * 
 * @author akrebs
 *
 */
public class Activator implements BundleActivator {

	private ServiceRegistration<EventLogger> reg;

	@Override
	public void start(BundleContext context) throws Exception {

		// Register Logstash as consumer of log events.
		this.reg = context.registerService(EventLogger.class, new EventLoggerImpl(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		if (this.reg != null) {
			
			// Un-register logstash
			context.ungetService(reg.getReference());
			this.reg = null;
		}
	}

}
