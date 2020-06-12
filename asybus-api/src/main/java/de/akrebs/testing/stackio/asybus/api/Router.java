package de.akrebs.testing.stackio.asybus.api;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface Router {
	
	public void route(String message);

}
