package de.akrebs.testing.stackio.restbus.impl;

import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

public class ResourceRegistration {
	
	private volatile HttpService httpService;

	public void start() {
		
		try {
			
			httpService.registerResources("/", "/html/index.html", null);
		}
		catch(NamespaceException nse) {
			
			nse.printStackTrace();
		}
	}
}
