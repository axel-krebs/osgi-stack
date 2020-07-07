package de.akrebs.stackio.gateway.api.unsafe;

import org.junit.Test;
import junit.framework.TestCase;

public class LoadUnsafeTest extends TestCase {

    @Test
    public void test() throws ClassNotFoundException {
	Class<?> unsafe = Class.forName("com.sun.misc.Unsafe");
	assertNotNull(unsafe);
    }

}
