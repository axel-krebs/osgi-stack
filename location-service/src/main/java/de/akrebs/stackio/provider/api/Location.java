package de.akrebs.stackio.provider.api;

public class Location {

    long longitude;
    long latitude;

    public Location(long longitude, long latitude) {
	super();
	this.longitude = longitude;
	this.latitude = latitude;
    }

    @Override
    public String toString() {
	return "Longitude: " + longitude + ", Latitude: " + latitude;
    }

}
