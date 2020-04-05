package com.quarkus.mongodb.model;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "user")
public class User extends PanacheMongoEntity {

	public String name;
	public String mobile;

	public User(String name, String mobile) {
		this.name = name;
		this.mobile = mobile;
	}
	
	public User() {
		
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}