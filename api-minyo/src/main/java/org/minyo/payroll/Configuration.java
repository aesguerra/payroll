package org.minyo.payroll;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.http.MediaType;
@org.springframework.context.annotation.Configuration
public class Configuration extends RepositoryRestMvcConfiguration {
	
	@Override 
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		//config.setDefaultMediaType(MediaType.APPLICATION_JSON);
	}

}
