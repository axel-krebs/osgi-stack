package de.akrebs.testing.stackio.log_diag.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import de.akrebs.stackio.registry.api.DomainServiceRegistry;
import de.akrebs.testing.stackio.log_diag.api.EventLogger;

/**
 * This component registers with the shared grid log queue and save log data to
 * a log store.
 * 
 * @author akrebs
 *
 */
@Component
public class EventLoggerImpl implements EventLogger {

    @Reference
    DomainServiceRegistry registry;

    @Override
    public void log(String string) {

    }

    @Activate
    public void start() {

	System.out.println("EventLogggerImpl: starting..");
    }

    @Deactivate
    public void stop() {

	System.out.println("EventLogggerImpl: stopping..");
    }
}
