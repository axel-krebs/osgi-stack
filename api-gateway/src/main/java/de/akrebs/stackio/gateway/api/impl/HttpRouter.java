package de.akrebs.stackio.gateway.api.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import de.akrebs.stackio.gateway.api.Router;

@Component(immediate = true, service = Router.class, name = "http_router")
public class HttpRouter implements Router {

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
	System.out.println("Starting.. ");

	// Only provide routing if refenced services are up..
    }

    @Deactivate
    public void stop() {
	System.out.println("Stopping..");
    }

}
