package com.cadrlife.service.service;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.glassfish.jersey.process.internal.RequestScoped;

import com.google.common.collect.ImmutableMap;

@Path("status")
@RequestScoped
public class StatusResource {

	@QueryParam("x")
	String x;

	@GET
	@Produces("application/json")
	public Map<String, String> get() {
		return ImmutableMap.of("ok", "ok");
	}
}