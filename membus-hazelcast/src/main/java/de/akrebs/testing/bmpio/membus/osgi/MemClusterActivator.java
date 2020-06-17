package de.akrebs.testing.bmpio.membus.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import de.akrebs.stackio.membus.SharedCache;
import de.akrebs.testing.bmpio.membus.impl.SharedCacheHazelcast;

/**
 * Create Hazelcast instance and register as service for consumption.
 * 
 * @author akrebs
 *
 */
public class MemClusterActivator implements BundleActivator {

    HazelcastInstance hcInstance;

    private ServiceRegistration<SharedCache> reg;

    @Override
    public void start(BundleContext context) throws Exception {

	Config config = new Config();

	// create Hazelcast instance
	// TODO Configuration manager
	hcInstance = Hazelcast.newHazelcastInstance(config);

	// Register Hazelcast as cluster manager.
	this.reg = context.registerService(SharedCache.class, new SharedCacheHazelcast(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {

	System.out.println("MemClusterActivator: stop..");
	
	if (this.reg != null) {

	    // Un-register shared cache
	    context.ungetService(reg.getReference());
	    this.reg = null;
	}

	if (hcInstance != null) {

	    // shutdown cluster
	    hcInstance.shutdown();
	    hcInstance = null;
	}
    }
}
