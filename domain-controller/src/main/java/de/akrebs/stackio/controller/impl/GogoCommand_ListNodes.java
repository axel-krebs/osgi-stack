package de.akrebs.stackio.controller.impl;

import org.apache.felix.service.command.Descriptor;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import de.akrebs.stackio.registry.api.DomainServiceRegistry;

/**
 * This stack represents a "master" node within the µ-services domain, and is to
 * be managed by a command line.
 * 
 * @author akrebs
 *
 */
@Component(
	property = { "osgi.command.scope=ctl", "osgi.command.function=list_nodes" },
	service = GogoCommand_ListNodes.class,
	immediate = true)
public class GogoCommand_ListNodes {

    private volatile boolean active = false;

    @Reference
    DomainServiceRegistry memBus;

    /**
     * Activate cluster as soon as service becomes available.
     * 
     * @param context
     */
    @Activate
    void activate(ComponentContext context) {
	System.out.println("GOGO commmander activated.");
	active = true;
    }

    @Deactivate
    void deactivate(ComponentContext context) {
	System.out.println("GOGO commander de-activated.");
	active = false;
    }

    @Descriptor("List all registered nodes.")
    public String list_nodes() {

	if (active) {

	    //
	    return "Listing..";
	}

	else {

	    return "Was not active!";
	}
    }
}
