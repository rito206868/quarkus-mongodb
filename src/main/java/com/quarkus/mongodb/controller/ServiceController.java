package com.quarkus.mongodb.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.quarkus.mongodb.repository.ServiceRepository;
import com.quarkus.mongodb.model.User;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceController.class);

	@Inject
	ServiceRepository serviceRepository;

	@GET
	@Path("/search")
	public List<User> findAllUser() {
		  LOGGER.info("All user search");
		return serviceRepository.findAll();
	}

	@GET
	@Path("/search/{name}")
	public User findUser(@PathParam("name") String name) {
		  LOGGER.info("Specific user search");
		return serviceRepository.findByName(name);
	}

	@POST
	@Path("/save")
	public Response saveUser(@Valid User user) {
		  LOGGER.info("Create user");
		return serviceRepository.save(user);
	}

	@PUT
	@Path("/update/{name}")
	public Response updateUser(@PathParam("name") String name, @Valid User user) {
		  LOGGER.info("Update user");
		return serviceRepository.update(name, user);
	}

	@DELETE
	@Path("/delete/{name}")
	public Response deleteUser(@PathParam("name") String name) {
		  LOGGER.info("Delete user");
		return serviceRepository.delete(name);
	}
	
	   	@GET
	   	@Path("/hello")
	    public String hello() {
	        return "hello";
	    }

}