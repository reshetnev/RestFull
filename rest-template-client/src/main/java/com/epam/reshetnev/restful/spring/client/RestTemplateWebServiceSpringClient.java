package com.epam.reshetnev.restful.spring.client;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class RestTemplateWebServiceSpringClient {

    private static Logger log = Logger
            .getLogger(RestTemplateWebServiceSpringClient.class.getName());

    private RestTemplate restTemplate;

    public RestTemplateWebServiceSpringClient() {
        restTemplate = new RestTemplate();
    }

    public void get(String url) {
        try {
            restTemplate.getForEntity(url, String.class);
            log.info(HttpStatus.OK + " " + HttpStatus.OK.name());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Error: " + e.getStatusCode() + " " + e.getStatusText());
        }
    }

    public <T> void post(T object, String url) {
        try {
            restTemplate.postForEntity(url, object, String.class);
            log.info(HttpStatus.CREATED + " " + HttpStatus.CREATED.name());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Error: " + e.getStatusCode() + " " + e.getStatusText());
        }
    }

    public <T> void put(T object, String url) {
        try {
            restTemplate.put(url, object, String.class);
            log.info(HttpStatus.OK + " " + HttpStatus.OK.name());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Error: " + e.getStatusCode() + " " + e.getStatusText());
        }
    }

    public void delete(String url) {
        try {
            restTemplate.delete(url);
            log.info(HttpStatus.OK + " " + HttpStatus.OK.name());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Error: " + e.getStatusCode() + " " + e.getStatusText());
        }
    }

}
