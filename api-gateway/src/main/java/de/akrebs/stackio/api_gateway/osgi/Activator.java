package de.akrebs.stackio.api_gateway.osgi;

import java.util.Dictionary;
import java.util.Hashtable;

import javax.servlet.ServletException;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

import de.akrebs.stackio.api_gateway.impl.ResourceServlet;

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
	HttpContext httpContext = createHttpContextFromConfig(httpService);

	if (null != httpService) {
	    addStaticResources(httpService, httpContext);

	    // Instantiate Jersey servlet with given config
	    addDynamicMapping(httpService, httpContext);
	} else {

	    // TODO log
	}
    }

    private void addStaticResources(HttpService httpService, HttpContext httpContext) throws NamespaceException {
	httpService.registerResources("/", "static/index.html", httpContext);
    }

    private void addDynamicMapping(HttpService httpService, HttpContext httpContext)
	    throws ServletException, NamespaceException {

	Dictionary<String, String> initParams = new Hashtable<String, String>();
	httpService.registerServlet("/eins", new ResourceServlet("eins"), initParams, httpContext);
	httpService.registerServlet("/zwei", new ResourceServlet("zwei"), initParams, httpContext);
    }

    /*
     * TODO: This context has no security yet!
     */
    private HttpContext createHttpContextFromConfig(HttpService httpService) {
	HttpContext context = httpService.createDefaultHttpContext();
	return context;
    }

}
