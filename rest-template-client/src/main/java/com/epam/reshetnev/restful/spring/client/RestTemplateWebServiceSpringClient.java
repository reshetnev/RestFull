package com.epam.reshetnev.restful.spring.client;

import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.epam.reshetnev.restful.entity.User;

public class RestTemplateWebServiceSpringClient {

    private static Logger log = Logger
            .getLogger(RestTemplateWebServiceSpringClient.class.getName());

    private RestTemplate restTemplate;
    private final String url = "http://localhost:8080/rest.ful/api/users/";

    public RestTemplateWebServiceSpringClient() {
        restTemplate = new RestTemplate();
    }
    
    @SuppressWarnings("unchecked")
    public ConcurrentMap<String, User> getUsers() {
        try {
            ConcurrentMap<String, User> users = restTemplate.getForObject(url, ConcurrentMap.class);
            log.info(HttpStatus.OK + " " + HttpStatus.OK.name());
            return users;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Error: " + e.getStatusCode() + " " + e.getStatusText());
        }
        return null;
    }

    public User getUserById(String userId) {
        try {
            User user = restTemplate.getForObject(url+userId, User.class);
            log.info(HttpStatus.OK + " " + HttpStatus.OK.name());
            return user;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Error: " + e.getStatusCode() + " " + e.getStatusText());
        }
        return null;
    }

    public void createUser(User user) {
        try {
            restTemplate.postForEntity(url, user, User.class);
            log.info(HttpStatus.CREATED + " " + HttpStatus.CREATED.name());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Error: " + e.getStatusCode() + " " + e.getStatusText());
        }
    }

    public void updateUser(User user, String userId) {
        try {
            restTemplate.put(url+userId, user, User.class);
            log.info(HttpStatus.OK + " " + HttpStatus.OK.name());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Error: " + e.getStatusCode() + " " + e.getStatusText());
        }
    }

    public void deleteUser(String userId) {
        try {
            restTemplate.delete(url+userId);
            log.info(HttpStatus.OK + " " + HttpStatus.OK.name());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Error: " + e.getStatusCode() + " " + e.getStatusText());
        }
    }

}
