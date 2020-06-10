package de.akrebs.testing.stackio.restbus.impl;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.HttpService;
import org.osgi.service.log.LogService;

public class Activator extends DependencyActivatorBase {

	@Override
	public void init(BundleContext context, DependencyManager manager) throws Exception {

		manager.add(createComponent().setImplementation(ResourceRegistration.class)
				.add(createServiceDependency().setService(HttpService.class).setRequired(true))
				.add(createServiceDependency().setService(LogService.class).setRequired(false)));

	}

}
