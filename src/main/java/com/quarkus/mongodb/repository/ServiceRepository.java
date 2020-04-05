package com.quarkus.mongodb.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import com.quarkus.mongodb.model.User;

@ApplicationScoped
public class ServiceRepository {

	public List<User> findAll() {
		return User.findAll().list();
	}

	public User findByName(String name) {
		return User.find("name", name).firstResult();
	}

	public Response save(User user) {
		user.persist();
		return Response.status(201).build();
	}
	

    public Response update(String name, User user) {
        user.update();
        return Response.status(201).build();
    }

	public Response delete(String name) {		
		User user = User.findByName(name);
		user.delete();
		return Response.status(201).build();
	}

}