package com.epam.reshetnev.restful.jersey.client;

import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestWebServiceJerseyClient {

    private static Logger log = Logger
            .getLogger(RestWebServiceJerseyClient.class.getName());

    public void get(String url) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(url);
            Response response = webTarget.request().get();
            if (response.getStatus() != 200) {
                throw new RuntimeException("Error: " + response.getStatus()
                        + " " + response.getStatusInfo());
            }
            log.info(response.getStatus() + " " + response.getStatusInfo());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public <T> void post(T object, String url) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(url);
            Response response = webTarget.request().post(
                    Entity.entity(object, MediaType.APPLICATION_JSON));
            if (response.getStatus() != 201) {
                throw new RuntimeException("Error: " + response.getStatus()
                        + " " + response.getStatusInfo());
            }
            log.info(response.getStatus() + " " + response.getStatusInfo());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public <T> void put(T object, String url) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(url);
            Response response = webTarget.request().put(
                    Entity.entity(object, MediaType.APPLICATION_JSON));
            if (response.getStatus() != 200) {
                throw new RuntimeException("Error: " + response.getStatus()
                        + " " + response.getStatusInfo());
            }
            log.info(response.getStatus() + " " + response.getStatusInfo());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public void delete(String url) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(url);
            Response response = webTarget.request().delete();
            if (response.getStatus() != 200) {
                throw new RuntimeException("Error: " + response.getStatus()
                        + " " + response.getStatusInfo());
            }
            log.info(response.getStatus() + " " + response.getStatusInfo());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

}
