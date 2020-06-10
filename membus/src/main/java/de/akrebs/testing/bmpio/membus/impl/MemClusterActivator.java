package de.akrebs.testing.bmpio.membus.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * Create Hazelcast instance and register as service.
 * 
 * @author akrebs
 *
 */
public class MemClusterActivator implements BundleActivator {

	HazelcastInstance hcInstance;

	@Override
	public void start(BundleContext context) throws Exception {

		System.out.println("MemClusterActivator: start..");

		// create Hazelcast instance
		hcInstance = Hazelcast.newHazelcastInstance();

//    	ManagementCenterConfig manCenterCfg = new ManagementCenterConfig();
//    	manCenterCfg.setEnabled(true).setUrl("http://localhost:8088/mancenter");
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		System.out.println("MemClusterActivator: stop..");

		if (hcInstance != null) {

			// shutdown cluster
			hcInstance.shutdown();
			hcInstance = null;
		}
	}
}
