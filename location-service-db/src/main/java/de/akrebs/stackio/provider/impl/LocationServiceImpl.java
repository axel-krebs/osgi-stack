package de.akrebs.stackio.provider.impl;

import org.osgi.service.component.annotations.Component;

import de.akrebs.stackio.provider.api.Location;
import de.akrebs.stackio.provider.api.LocationService;

@Component(service = LocationService.class, name = "LocationService", property = "service.exported.interfaces=*")
public class LocationServiceImpl implements LocationService {

    @Override
    public Location find(String desxcription) {
	return new Location(324523523452345234L, 2345536452645652456L);
    }

}
