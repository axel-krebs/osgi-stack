package de.akrebs.testing.stackio.logbus.api;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The Log service I/F.
 * 
 * @author akrebs
 *
 */
@ProviderType
public interface EventLogger {
	
	public void log(String message);

}
