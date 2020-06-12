package de.akrebs.testing.stackio.logbus.logstash.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import de.akrebs.testing.stackio.logbus.api.EventLogger;
import de.akrebs.testing.stackio.logbus.logstash.impl.EventLoggerImpl;

public class Activator implements BundleActivator {

	private ServiceRegistration<EventLogger> reg;

	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Registering Logger!");

		this.reg = context.registerService(EventLogger.class, new EventLoggerImpl(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		if(this.reg != null) {
			
			context.ungetService(reg.getReference());
			this.reg = null;
		}
	}

}
