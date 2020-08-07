package de.akrebs.stackio.provider.impl;

import de.akrebs.stackio.provider.api.Location;
import de.akrebs.stackio.provider.api.LocationService;

public class LocationServiceImpl implements LocationService {

    String nodeId;

    public LocationServiceImpl(String nodeId) {
	super();
	this.nodeId = nodeId;
    }

    @Override
    public Location find(String desxcription) {
	return new Location(324523523452345234L, 2345536452645652456L);
    }

}
