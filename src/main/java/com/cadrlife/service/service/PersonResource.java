package com.cadrlife.service.service;


import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.cadrlife.service.domain.Person;

@Path("person")
@Singleton
public class PersonResource {
    private PersonService personService;


	@Inject
    public PersonResource(PersonService personService) {
		this.personService = personService;
    }

    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public Person get(@QueryParam("id") String id) {
         return personService.findById(id);
	}
        
}