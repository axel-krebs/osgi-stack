package de.akrebs.stackio.gateway.api.osgi;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import de.akrebs.stackio.gateway.api.impl.Configuration;

/**
 * Will be executed each time the bundle starts; to be replaced by annotations!
 * 
 * @author akrebs
 * @deprecated
 */
public class Activator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
    	
    	// WHAT
    }

}
