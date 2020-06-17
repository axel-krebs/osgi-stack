package de.akrebs.testing.stackio.restbus.osgi;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBus;

public class Activator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {

	VertxOptions vo = new VertxOptions();

	// TODO set Mebus as cluster manager
	Vertx vertx = Vertx.vertx(vo);
	EventBus eb = vertx.eventBus();
	System.out.println("Activator.init(): EventBus.getClass: " + eb.getClass().getCanonicalName());

//	manager.add(createComponent().setImplementation(ResourceRegistration.class)
//		.add(createServiceDependency().setService(HttpService.class).setRequired(true))
//		.add(createServiceDependency().setService(LogService.class).setRequired(false)));

    }

}
