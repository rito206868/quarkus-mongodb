package com.quarkus.mongodb.model;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "user")
public class User extends PanacheMongoEntity {

	public String name;
	public Integer mobile;

	public User(String name, Integer mobile) {
		this.name = name;
		this.mobile = mobile;
	}

    // entity methods
    public static User findByName(String name) {
        return find("name", name).firstResult();
    }
    
    public static void deleteUser(String name) {
        delete("name", name);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

}