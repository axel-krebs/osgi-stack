package de.akrebs.testing.stackio.logbus.gogo.impl;

import org.apache.felix.service.command.Descriptor;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import de.akrebs.testing.stackio.logbus.api.EventLogger;

@Component(
	property = 
    		{ "osgi.command.scope=logbus",
    		  "osgi.command.function=log_message" 
    		}, 
    	service = EventLogServiceProxy.class,
    	immediate = true)
public class EventLogServiceProxy {

    @Reference
    public EventLogger loggingService;

    private volatile boolean active = false;

    /**
     * Activate logging as soon as service becomes available.
     * 
     * @param context
     */
    @Activate
    void activate(ComponentContext context) {
	System.out.println("GOGO log activated.");
	active = true;
    }

    @Deactivate
    void deactivate(ComponentContext context) {
	System.out.println("GOGO log de-activated.");
	active = false;
    }

    @Descriptor("Log a message.")
    public void log_message(@Descriptor("The message that should be logged") String message) {

	if (active) {

	    loggingService.log(message);
	}
	
	else {
	    
	    System.out.println("Was not active!");
	}
    }

}
