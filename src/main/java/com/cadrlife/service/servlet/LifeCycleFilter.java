package com.cadrlife.service.servlet;

import com.cadrlife.service.service.PersonService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.servlet.*;
import java.io.IOException;

@Singleton
public class LifeCycleFilter implements Filter {
    private final PersonService personService;

    @Inject
    public LifeCycleFilter(PersonService personService) {
		this.personService = personService;
	}


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    	personService.close();
    }
}
