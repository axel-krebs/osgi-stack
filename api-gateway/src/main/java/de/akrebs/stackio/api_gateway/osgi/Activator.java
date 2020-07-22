package de.akrebs.stackio.api_gateway.osgi;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

/**
 * Will be executed each time the bundle starts; to be replaced by annotations!
 * 
 * @author akrebs
 */
public class Activator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {

	System.out.println("API-GATEWAY: Activator.init()s");
    }

}
