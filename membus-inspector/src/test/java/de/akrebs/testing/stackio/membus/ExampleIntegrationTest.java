package de.akrebs.testing.stackio.membus;

import java.util.concurrent.CountDownLatch;

import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import de.akrebs.testing.bmpio.membus.SharedCache;
import junit.framework.TestCase;

public class ExampleIntegrationTest extends TestCase {

	private final BundleContext context = FrameworkUtil.getBundle(ExampleIntegrationTest.class).getBundleContext();
	CountDownLatch latch;

	@Override
	public void setUp() {
		System.out.println("Before");
		latch = new CountDownLatch(1);
		DependencyManager dm = new DependencyManager(context);
		dm.add(dm.createComponent().setImplementation(this).add(dm.createServiceDependency().setService(SharedCache.class)));
	}

	@Override
	public void tearDown() {
		System.out.println("After");
	}

	public void start() {
		latch.countDown();
	}

}