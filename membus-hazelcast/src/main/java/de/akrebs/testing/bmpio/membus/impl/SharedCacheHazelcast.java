package de.akrebs.testing.bmpio.membus.impl;

import org.osgi.service.component.annotations.Component;

import de.akrebs.stackio.membus.SharedCache;

@Component(service = SharedCache.class, immediate = true, name = "SharedCache")
public class SharedCacheHazelcast implements SharedCache {

}
