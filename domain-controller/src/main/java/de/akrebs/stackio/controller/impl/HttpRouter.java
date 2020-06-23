package de.akrebs.stackio.controller.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import de.akrebs.stackio.controller.Router;
import de.akrebs.stackio.registry.Registry;
import de.akrebs.testing.stackio.logbus.api.EventLogger;

@Component(immediate = true, service = Router.class, name = "http_router")
public class HttpRouter implements Router {

    @Reference
    Registry registry;
    
    @Reference
    EventLogger logger;

    /**
     * A reference to the registry is needed.
     * 
     * @param registry
     */
    public HttpRouter() {
	super();
    }

    @Activate
    public void start() {
	System.out.println("Starting.. registry:" + registry.getClass());
    }

    @Deactivate
    public void stop() {
	System.out.println("Stopping..");
    }

}
