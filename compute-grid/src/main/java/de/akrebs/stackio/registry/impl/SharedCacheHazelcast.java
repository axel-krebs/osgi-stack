package de.akrebs.stackio.registry.impl;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import de.akrebs.stackio.registry.api.DomainServiceRegistry;
import de.akrebs.stackio.registry.api.Provider;
import de.akrebs.stackio.registry.api.ServiceRegistration;

@Component(service = DomainServiceRegistry.class, immediate = true, name = "SharedCache")
public class SharedCacheHazelcast implements DomainServiceRegistry {

    HazelcastInstance hcInstance;

    @Activate
    public void start() {
	System.out.println("SharedCacheHazelcast: starting..");
	
	Config config = new Config();

	// create Hazelcast instance
	// TODO Configuration manager
	hcInstance = Hazelcast.newHazelcastInstance(config);
    }
    
    @Deactivate
    public void stop(BundleContext context) throws Exception {

	System.out.println("SharedCacheHazelcast: stop..");
	
	if (hcInstance != null) {

	    hcInstance = null;
	}
    }
    
    @Override
    public ServiceRegistration registerService(Provider p) {
	System.out.println("SharedCacheHazelcast: register service: "+p);
	
	// TODO publish distributed object
	
	return null;
    }

    @Override
    public void unregisterService(ServiceRegistration lease) {
	System.out.println("SharedCacheHazelcast: un-register service: " + lease);
    }
}
