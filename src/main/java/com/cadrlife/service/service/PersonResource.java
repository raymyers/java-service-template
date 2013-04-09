package com.cadrlife.service.service;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.cadrlife.service.domain.Person;
import com.google.inject.Singleton;

@Path("person")
@Singleton
public class PersonResource {
    private PersonService personService;


	@Inject
    public PersonResource(PersonService personService) {
		this.personService = personService;
    }

    @GET
	@Produces("application/json")
	public Person get(@QueryParam("id") String id) {
         return personService.findById(id);
	}
        
}