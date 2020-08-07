package de.akrebs.stackio.provider.osgi;

import java.util.Hashtable;

import org.apache.karaf.cellar.core.ClusterManager;
import org.apache.karaf.util.tracker.BaseActivator;
import org.apache.karaf.util.tracker.annotation.ProvideService;
import org.apache.karaf.util.tracker.annotation.RequireService;
import org.apache.karaf.util.tracker.annotation.Services;

import de.akrebs.stackio.provider.api.LocationService;
import de.akrebs.stackio.provider.impl.LocationServiceImpl;

@Services(provides = { @ProvideService(LocationService.class) }, requires = { @RequireService(ClusterManager.class) })
public class Activator extends BaseActivator {

    @Override
    protected void doStart() throws Exception {
	ClusterManager clusterManager = getTrackedService(ClusterManager.class);
	if (clusterManager == null)
	    return;

	String nodeId = clusterManager.getNode().getId();
	LocationServiceImpl ls = new LocationServiceImpl(nodeId);
	Hashtable props = new Hashtable();
	props.put("service.exported.interfaces", "*");
	register(LocationService.class, ls, props);
    }

}
