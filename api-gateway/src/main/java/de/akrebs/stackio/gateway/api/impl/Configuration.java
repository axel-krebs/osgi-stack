package de.akrebs.stackio.gateway.api.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component(immediate = true, service = Configuration.class)
public class Configuration {

    volatile boolean standalone = true;

    @Activate
    public void start() {

	System.out.println("Starting configuration..");
    }

    @Deactivate
    public void stop() {

	System.out.println("Stopping configuration..");
    }

}
