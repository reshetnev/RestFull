package com.epam.reshetnev.restful.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class CustomInternalServerError extends WebApplicationException {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
    * Create a HTTP 404 (Not Found) exception.
    */
    public CustomInternalServerError() {
        super(Response.status(500).build());
    }
       
        /**
    * Create a HTTP 404 (Not Found) exception.
    * @param message the String that is the entity of the 404 response.
    */
    public CustomInternalServerError(String message) {
        super(Response.status(500).
        entity(message).type("text/plain").build());
    }
}
