package de.akrebs.testing.stackio.logbus.gogo.impl;

import org.apache.felix.service.command.Descriptor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import de.akrebs.testing.stackio.logbus.api.EventLogger;

public class EventLogServiceProxy {
	
	private BundleContext context;

	public static final String SCOPE = "gogo";
	
	public final static String[] FUNCTIONS = {
		"log_message"
	};

	public EventLogServiceProxy(BundleContext context) {
		super();
		this.context = context;
	}
	
	@Descriptor("Log a message.")
	public void log_message(@Descriptor("The message that should be logged") String message) {
		
		EventLogger logger = lookupService();
		
		logger.log(message);
	}
	
	protected EventLogger lookupService() {
		
		ServiceReference<EventLogger> ref = context.getServiceReference(EventLogger.class);
		
		if(ref == null) {
			
			throw new RuntimeException("Cannot get service reference to EventLogger.");
		}
		
		EventLogger logger = context.getService(ref);
		
		if(logger == null) {
			
			throw new RuntimeException("No implementations found for EventLogger!");
		}
		
		return logger;
		
	}

}
