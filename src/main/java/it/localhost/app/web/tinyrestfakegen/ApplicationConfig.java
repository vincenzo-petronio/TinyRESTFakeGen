/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.localhost.app.web.tinyrestfakegen;

import it.localhost.app.web.tinyrestfakegen.uri.*;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * FIX http://www.minh.io/tech/2014/10/27/jersey-2-on-jboss-7/
 */
public class ApplicationConfig extends ResourceConfig {
    
    	public ApplicationConfig() {

            // package scanning doesn't work in Jboss for some reason
            // packages( true, "it.localhost.app.web.tinyrestfakegen" );
            register(AboutResource.class);
            register(CitiesResource.class);
            register(CityResource.class);
            register(CountriesResource.class);
            register(CountryResource.class);
            register(UsersResource.class);
            register(UserResource.class);
        }
}
