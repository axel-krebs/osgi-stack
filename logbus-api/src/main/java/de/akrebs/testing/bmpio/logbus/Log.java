package de.akrebs.testing.bmpio.logbus;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The Log service I/F.
 * 
 * @author akrebs
 *
 */
@ProviderType
public interface Log {
	
	public void log(String message);

}
