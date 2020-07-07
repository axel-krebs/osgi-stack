package de.akrebs.stackio.gateway.api.osgi;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.javasupport.JavaEmbedUtils;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Bundle;

/**
 * Will be executed each time the bundle starts; to be replaced by annotations!
 * 
 * @author akrebs
 */
public class Activator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {

	Bundle[] bundles = context.getBundles();
	for (int i = 0; i < bundles.length; i++) {
	    System.out.println(bundles[i]);
	}

	ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
	ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("ruby");
	List<String> scripts= new ArrayList<String>();
	scripts.add("router.rb");
	Ruby router = JavaEmbedUtils.initialize(scripts);
	RubyClass rb = router.getBinding();
	// WHAT
    }

}
