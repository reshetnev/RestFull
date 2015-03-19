package com.epam.reshetnev.restful.jersey.client;

import java.util.Map;
import java.util.logging.Logger;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.epam.reshetnev.restful.entity.User;

public class RestWebServiceJerseyClient {

    private static Logger log = Logger
            .getLogger(RestWebServiceJerseyClient.class.getName());
    private final String url = "http://localhost:8080/rest.ful/api/users/";
    
    @SuppressWarnings("unchecked")
    public Map<String, User> getUsers() {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(url);
            Response response = webTarget.request().get();
            Map<String, User> users = response.readEntity(Map.class);
            log.info(response.getStatus() + " " + response.getStatusInfo());
            return users;
        } catch (WebApplicationException e) {
            log.info(e.getMessage());
        }
        return null;
    }

    public User getUserById(String userId) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(url+userId);
            Response response = webTarget.request().get();
            User user = response.readEntity(User.class);
            log.info(response.getStatus() + " " + response.getStatusInfo());
            return user;
        } catch (WebApplicationException e) {
            log.info(e.getMessage());
        }
        return null;
    }

	public void createUser(User user) {
		try {
			Client client = ClientBuilder.newClient();
			WebTarget webTarget = client.target(url);
			Response response = webTarget.request().post(
					Entity.entity(user, MediaType.APPLICATION_JSON));
			log.info(response.getStatus() + " " + response.getStatusInfo());
		} catch (WebApplicationException e) {
			log.info(e.getMessage());
		}
	}

    public void updateUser(User user, String userId) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(url+userId);
            Response response = webTarget.request().put(
                    Entity.entity(user, MediaType.APPLICATION_JSON));
            log.info(response.getStatus() + " " + response.getStatusInfo());
        } catch (WebApplicationException e) {
            log.info(e.getMessage());
        }
    }

    public void deleteUser(String userId) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(url+userId);
            Response response = webTarget.request().delete();
            log.info(response.getStatus() + " " + response.getStatusInfo());
        } catch (WebApplicationException e) {
            log.info(e.getMessage());
        }
    }

}
