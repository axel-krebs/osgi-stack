package de.akrebs.stackio.api_gateway.osgi;

import java.util.Dictionary;
import java.util.Hashtable;

import javax.servlet.Servlet;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;

/**
 * Will be executed each time the bundle starts; to be replaced by annotations!
 * 
 * @author akrebs
 */
public class Activator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {

	ServiceReference<HttpService> ref = context.getServiceReference(HttpService.class);
	HttpService httpService = context.getService(ref);
	
	// Instantiate Jersey servlet with given config
	ResourceConfig config = new ResourceConfig();
	Servlet jerseyServlet = new ServletContainer(config);
	Dictionary<String, String> initParams = new Hashtable<String, String>();
	initParams.put("", "");
	HttpContext httpContext = createHttpContextFromConfig(httpService);
//	httpService.registerServlet("/rest", jerseyServlet, initParams, httpContext);
	httpService.registerResources("/", "index.html", null);
    }

    private HttpContext createHttpContextFromConfig(HttpService httpService) {
	HttpContext context = httpService.createDefaultHttpContext();
	return context;
    }

}
