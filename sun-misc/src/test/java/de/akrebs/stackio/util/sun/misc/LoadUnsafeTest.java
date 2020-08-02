package de.akrebs.stackio.util.sun.misc;

import org.junit.Test;

import junit.framework.TestCase;

public class LoadUnsafeTest extends TestCase {

    @Test
    public void test() throws ClassNotFoundException {
	Class<?> unsafe = Class.forName("com.sun.misc.Unsafe");
	assertNotNull(unsafe);
    }

}
