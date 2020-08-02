package de.akrebs.stackio.api_gateway.impl;

import java.util.Dictionary;
import java.util.Hashtable;

import javax.servlet.ServletException;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.osgi.service.log.LogService;

import de.akrebs.stackio.provider.api.LocationService;

@Component(immediate = true, service = Configuration.class)
public class Configuration {

    volatile boolean standalone = true;

    @Reference
    HttpService httpService;

    @Reference
    LogService logger;

    @Activate
    public void start() {

	logger.log(LogService.LOG_INFO, "Starting API-GATEWAY configuration..");

	HttpContext httpContext = createHttpContextFromConfig(httpService);

	try {
	    addStaticResources(httpService, httpContext);
	    addDynamicMapping(httpService, httpContext);
	} catch (NamespaceException e) {

	    logger.log(LogService.LOG_ERROR, e.getMessage());
	} catch (ServletException e) {

	    logger.log(LogService.LOG_ERROR, e.getMessage());
	}

    }

    @Deactivate
    public void stop() {

	logger.log(LogService.LOG_INFO, "Stopping API-GATEWAY configuration..");

	removeStaticResources();

	removeDynamicMapping();
    }

    private void addStaticResources(HttpService httpService, HttpContext httpContext) throws NamespaceException {
	httpService.registerResources("/", "static/index.html", httpContext);
    }

    private void removeStaticResources() {
	httpService.unregister("/");
    }

    private void addDynamicMapping(HttpService httpService, HttpContext httpContext)
	    throws ServletException, NamespaceException {

	Dictionary<String, String> initParams = new Hashtable<String, String>();
	httpService.registerServlet("/eins", new ResourceServlet("eins"), initParams, httpContext);
	httpService.registerServlet("/zwei", new ResourceServlet("zwei"), initParams, httpContext);
    }

    private void removeDynamicMapping() {
	httpService.unregister("/eins");
	httpService.unregister("/zwei");
    }

    /*
     * TODO: This context has no security yet!
     */
    private HttpContext createHttpContextFromConfig(HttpService httpService) {
	HttpContext context = httpService.createDefaultHttpContext();
	return context;
    }

}
