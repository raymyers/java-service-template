package com.cadrlife.service;

import javax.inject.Inject;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import com.cadrlife.service.service.PersonResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.google.inject.Guice;

public class JaxRsApplication extends ResourceConfig {
	@Inject
	public JaxRsApplication(ServiceLocator serviceLocator) {
		packages(PersonResource.class.getPackage().getName());
		GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);

		GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
		guiceBridge.bridgeGuiceInjector(Guice.createInjector(new GuiceModule()));
		JacksonJaxbJsonProvider jsonProvider = jsonProvider();
		register(jsonProvider);
	}

	private JacksonJaxbJsonProvider jsonProvider() {
		JacksonJaxbJsonProvider jsonProvider = new JacksonJaxbJsonProvider();
		ObjectMapper mapper = new ObjectMapper();
		// configure object mapper here
		jsonProvider.setMapper(mapper);
		return jsonProvider;
	}
}