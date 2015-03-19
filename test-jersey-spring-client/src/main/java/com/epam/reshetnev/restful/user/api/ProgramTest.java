package com.epam.reshetnev.restful.user.api;

import java.util.logging.Logger;

import com.epam.reshetnev.restful.entity.User;
import com.epam.reshetnev.restful.jersey.client.RestWebServiceJerseyClient;
import com.epam.reshetnev.restful.spring.client.RestTemplateWebServiceSpringClient;

public class ProgramTest {
    
    private static Logger log = Logger
            .getLogger(ProgramTest.class.getName());

	public static void main(String[] args) {
		String url = "http://localhost:8080/rest.ful/api/user";
		log.info("GET     "+url);
		
		RestWebServiceJerseyClient jerseyClient = new RestWebServiceJerseyClient();
		log.info(jerseyClient.getUserById("3").toString());
		RestTemplateWebServiceSpringClient springClient = new RestTemplateWebServiceSpringClient();
		log.info(springClient.getUserById("3").toString());
		
		url = "http://localhost:8080/rest.ful/api/users";
		log.info("GET     "+url);
		
        log.info(jerseyClient.getUsers().toString());
		log.info(springClient.getUsers().toString());
        
		url = "http://localhost:8080/rest.ful/api/users";
		log.info("POST     "+url);
		User user = new User("2", "b", "buser", "2b");
		jerseyClient.createUser(user);
		springClient.createUser(user);
		
		url = "http://localhost:8080/rest.ful/api/users";
		log.info("POST     "+url);
		user = new User("4", "d", "duser", "4d");
		jerseyClient.createUser(user);
	    user = new User("5", "e", "euser", "5e");
		springClient.createUser(user);
		
		url = "http://localhost:8080/rest.ful/api/users/6";
		log.info("PUT     "+url);
		user = new User("6", "f", "fuser", "6f");
		jerseyClient.updateUser(user, "6");
		springClient.updateUser(user, "6");
		
		url = "http://localhost:8080/rest.ful/api/users/4";
		log.info("PUT     "+url);
		user = new User("5", "x", "xuser", "4x");
		jerseyClient.updateUser(user, "4");
	    user = new User("5", "z", "zuser", "4z");
		springClient.updateUser(user, "4");

		url = "http://localhost:8080/rest.ful/api/users/6";
		log.info("DELETE     "+url);
		jerseyClient.deleteUser("6");
		springClient.deleteUser("6");
		
		url = "http://localhost:8080/rest.ful/api/users/5";
		log.info("DELETE     "+url);
		springClient.deleteUser("5");
		url = "http://localhost:8080/rest.ful/api/users/4";
		log.info("DELETE     "+url);
		jerseyClient.deleteUser("4");

	}

}
