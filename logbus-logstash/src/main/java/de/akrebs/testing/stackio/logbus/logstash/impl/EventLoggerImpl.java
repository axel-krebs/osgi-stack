package de.akrebs.testing.stackio.logbus.logstash.impl;

import de.akrebs.testing.stackio.logbus.api.EventLogger;

public class EventLoggerImpl implements EventLogger {

	@Override
	public void log(String message) {

		System.out.println("EventLoggerImpl:log(" + message + ")");
	}

}
