package de.akrebs.testing.stackio.logbus.gogo.osgi;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import de.akrebs.testing.stackio.logbus.gogo.impl.EventLogServiceProxy;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {

		Dictionary<String, String> properties = new Hashtable<String, String>();

		properties.put("osgi.command.scope", EventLogServiceProxy.SCOPE);

		context.registerService(EventLogServiceProxy.class, new EventLogServiceProxy(context), properties);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		
	}

}
