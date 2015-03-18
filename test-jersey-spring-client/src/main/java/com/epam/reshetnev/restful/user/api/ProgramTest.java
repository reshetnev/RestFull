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
		jerseyClient.get(url);
		RestTemplateWebServiceSpringClient springClient = new RestTemplateWebServiceSpringClient();
		springClient.get(url);
		
		url = "http://localhost:8080/rest.ful/api/users";
		log.info("GET     "+url);
		jerseyClient.get(url);
		springClient.get(url);
		
		url = "http://localhost:8080/rest.ful/api/users/1";
        log.info("GET     "+url);
        jerseyClient.get(url);
        springClient.get(url);
		
		url = "http://localhost:8080/rest.ful/api/users";
		log.info("POST     "+url);
		User user = new User("2", "b", "buser", "2b");
		jerseyClient.post(user, url);
		springClient.post(user, url);
		
		url = "http://localhost:8080/rest.ful/api/users";
		log.info("POST     "+url);
		user = new User("4", "d", "duser", "4d");
		jerseyClient.post(user, url);
	    user = new User("5", "e", "euser", "5e");
		springClient.post(user, url);
		
		url = "http://localhost:8080/rest.ful/api/users/6";
		log.info("PUT     "+url);
		user = new User("6", "f", "fuser", "6f");
		jerseyClient.put(user, url);
		springClient.put(user, url);
		
		url = "http://localhost:8080/rest.ful/api/users/4";
		log.info("PUT     "+url);
		user = new User("5", "x", "xuser", "4x");
		jerseyClient.put(user, url);
	    user = new User("5", "z", "zuser", "4z");
		springClient.put(user, url);

		url = "http://localhost:8080/rest.ful/api/users/6";
		log.info("DELETE     "+url);
		jerseyClient.delete(url);
		springClient.delete(url);
		
		url = "http://localhost:8080/rest.ful/api/users/5";
		log.info("DELETE     "+url);
		springClient.delete(url);
		url = "http://localhost:8080/rest.ful/api/users/4";
		log.info("DELETE     "+url);
		jerseyClient.delete(url);

	}

}
