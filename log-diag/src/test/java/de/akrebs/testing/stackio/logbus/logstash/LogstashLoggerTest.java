package de.akrebs.testing.stackio.logbus.logstash;

import org.apache.felix.dm.DependencyManager;
import org.junit.Test;
import org.osgi.framework.BundleContext;

import de.akrebs.testing.stackio.log_diag.api.EventLogger;
import junit.framework.TestCase;
import static org.osgi.framework.FrameworkUtil.getBundle;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * This test cannot be run by Maven, its rationale is BND testing!
 * 
 * @author akrebs
 *
 */
public class LogstashLoggerTest extends TestCase {

    private final BundleContext context = getBundle(this.getClass()).getBundleContext();
    private CountDownLatch latch;
    private EventLogger logger;

    public void start() {
	System.out.println("Starting..");
	latch.countDown();
    }

    @Override
    protected void setUp() throws Exception {
	super.setUp();
	latch = new CountDownLatch(1);
	DependencyManager dm = new DependencyManager(context);
	dm.add(dm.createComponent().setImplementation(this)
		.add(dm.createServiceDependency().setService(EventLogger.class)));
	try {
	    latch.await(10, TimeUnit.SECONDS);
	} catch (Exception e) {
	    fail("Service dependencies were not injected,");
	}
    }

    @Override
    protected void tearDown() throws Exception {
	super.tearDown();
    }

    @Test
    public void test() {
	logger.log("Test message");
    }

}
