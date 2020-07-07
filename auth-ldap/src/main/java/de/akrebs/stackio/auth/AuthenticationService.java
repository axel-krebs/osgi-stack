package de.akrebs.stackio.auth;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This is an example of an interface that is expected to be implemented by Providers of the API. Adding methods to this
 * interface is a minor change, because only Providers will be affected.
 * </p>
 * 
 * @see ProviderType
 * @since 1.0
 */
@ProviderType
public interface AuthenticationService {

    UserProfile autheticate(Credentials creds);

}
