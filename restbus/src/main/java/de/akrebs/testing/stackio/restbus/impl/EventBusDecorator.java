package de.akrebs.testing.stackio.restbus.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import de.akrebs.stackio.membus.SharedCache;
import de.akrebs.testing.stackio.restbus.RestBus;

@Component(service = RestBus.class, immediate = true)
public class EventBusDecorator implements RestBus {

    private SharedCache sharedCache;
    
    @Reference
    public void setEventBus(SharedCache eventBus) {
	System.out.println("EventBusDecorator: set event bus to " + eventBus.getClass().getCanonicalName());
	this.sharedCache = eventBus;
    }
    
    @Activate
    public void activate() {
	System.out.println("EventBusDecorator: getting activated.");
    }
    
    @Deactivate
    public void de_activate() {
	System.out.println("EventBusDecorator: getting de-activated.");
    }

}
