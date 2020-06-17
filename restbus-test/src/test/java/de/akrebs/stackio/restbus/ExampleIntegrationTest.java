package de.akrebs.stackio.restbus;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExampleIntegrationTest {

    //private final BundleContext context = FrameworkUtil.getBundle(ExampleIntegrationTest.class).getBundleContext();

    @Before
    public void before() {
	System.out.println("before");
    }

    @After
    public void after() {
	System.out.println("after");
    }

    @Test
    public void testExample() {
	System.out.println("test example");
    }

}