package de.akrebs.testing.stackio.logbus.gogo.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
	    
	    System.out.println("GOGO command - starting..");

	    // Done by @Component annotation!
	    
//		Dictionary<String, String> properties = new Hashtable<String, String>();
//		properties.put("osgi.command.scope", EventLogServiceProxy.SCOPE);
//		context.registerService(EventLogServiceProxy.class, new EventLogServiceProxy(context), properties);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
	    System.out.println("GOGO command - stoping..");

	}

}
