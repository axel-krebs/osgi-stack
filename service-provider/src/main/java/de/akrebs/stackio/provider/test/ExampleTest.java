package de.akrebs.stackio.provider.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import aQute.launchpad.Launchpad;
import aQute.launchpad.LaunchpadBuilder;
import aQute.launchpad.Service;
import de.akrebs.stackio.registry.api.DomainServiceRegistry;

//@RunWith(LaunchpadRunner.class)
public class ExampleTest {

    static LaunchpadBuilder builder = new LaunchpadBuilder().runfw("org.apache.felix.framework;version='[5.6.12,5.6.12]'");

    @Service
    BundleContext context;
    
    @Test
    public void testList() {
	try (Launchpad launchpad = builder
		.bundles("biz.aQute.bndlib;version='[5.1.1,5.1.2)'")
		.bundles("slf4j.api;version='[1.7.30,1.7.31)'")
		.bundles("slf4j.simple;version='[1.7.30,1.7.31)'")
		.bundles("org.apache.felix.log")
		.bundles("org.apache.felix.scr")
		.bundles("org.apache.felix.dependencymanager")
		.bundles("org.osgi.service.cm;version='[1.6.0,1.6.1)'")
		.bundles("org.osgi.service.metatype;version='[1.4.0,1.4.1)'")
		.bundles("registry;version=1.0.1")
		.bundles("javax-cache;version=1.1.1")
		.bundles("javax-el;version=snapshot")
		.bundles("javax.enterprise.cdi-api;version='[2.0.0,2.0.1)'")
		.bundles("javax.inject;version='[1.0.0,1.0.1)'")
		.bundles("javax.interceptor-api;version='[1.2.2,1.2.3)'")
//		.bundles("slf4j.api;version='[1.7.30,1.7.31)',")
//		.bundles("slf4j.simple;version='[1.7.30,1.7.31)'")
		.bundles("org.apache.logging.log4j.api;version='[2.13.3,2.13.4)'")
		.bundles("org.apache.log4j;version='[1.2.15,1.2.16)'")
		//.bundles("com.hazelcast;version=4.0.1")
		.create().debug().inject(this)) {
	    assertNotNull(context);
	    
	    ServiceReference<DomainServiceRegistry> ref = context.getServiceReference(DomainServiceRegistry.class);
	    DomainServiceRegistry reg = context.getService(ref);
//	    ServiceRegistration<ServiceRegistrator> register = launchpad.register(ServiceRegistrator.class,
//		    new ServiceRegistratorComponent());
//	    Optional<ServiceRegistrator> s = launchpad.waitForService(ServiceRegistrator.class, 100);
//	    assert(s.isPresent());
//	    ServiceRegistrator reg = s.get();
//	    reg.registerService(new Provider() {});
	    listContextBundles();
	    context.getBundle("");
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    private void listContextBundles() {

	for (Bundle b : context.getBundles()) {

	    System.out.println("Bundle: " + b.getSymbolicName());
	    System.out.println("State: " + b.getState());

	    ServiceReference<?>[] sr = b.getRegisteredServices();
	    if (sr != null) {
		System.out.println("\tServices: ");
		for (int i = 0; i < sr.length; i++) {
		    System.out.println("\t\t" + sr[i].toString());
		}
	    }
	}
    }

}
