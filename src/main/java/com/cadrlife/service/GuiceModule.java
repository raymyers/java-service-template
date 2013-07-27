package com.cadrlife.service;
import com.cadrlife.service.service.PersonService;
import com.google.inject.servlet.ServletModule;

public class GuiceModule extends ServletModule {

	@Override
	protected void configureServlets() {
		bind(PersonService.class);
	}

}