package de.akrebs.stackio.auth.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import de.akrebs.stackio.auth.AuthenticationService;
import de.akrebs.stackio.auth.Credentials;
import de.akrebs.stackio.auth.UserProfile;
import de.akrebs.stackio.registry.api.DomainServiceRegistry;

@Component()
public class AuthenticationServiceImpl implements AuthenticationService {

    @Reference
    public DomainServiceRegistry memBus;
    
    @Override
    public UserProfile autheticate(Credentials creds) {
	
	return null;
    }
}
