package com.cadrlife.service;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.core.Application;

import org.glassfish.hk2.api.ServiceLocator;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import com.cadrlife.service.service.PersonResource;
import com.cadrlife.service.service.PersonService;
import com.cadrlife.service.service.StatusResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.google.inject.Guice;


public class JaxRsApplicationOld extends Application {
    private final Set<Class<?>> classes;
    @Inject
    public JaxRsApplicationOld(ServiceLocator serviceLocator) {
        HashSet<Class<?>> c = new HashSet<Class<?>>();
        c.add(PersonResource.class);
        c.add(StatusResource.class);
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);

		GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
		guiceBridge.bridgeGuiceInjector(Guice.createInjector(new GuiceModule()));
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
    
    @Override
    public Set<Object> getSingletons() {
        final Set<Object> instances = new HashSet<Object>();
        JacksonJaxbJsonProvider jsonProvider = new JacksonJaxbJsonProvider();
        ObjectMapper mapper = new ObjectMapper();
		jsonProvider.setMapper(mapper);
		instances.add(jsonProvider);
		instances.add(new PersonService());
//        instances.add(new JacksonFeature());
        return instances;
    }
}