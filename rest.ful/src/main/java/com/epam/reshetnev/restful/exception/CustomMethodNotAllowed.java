package com.epam.reshetnev.restful.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class CustomMethodNotAllowed extends WebApplicationException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create a HTTP 405 (Method Not Allowed) exception.
     */
    public CustomMethodNotAllowed() {
        super(Response.status(Response.Status.METHOD_NOT_ALLOWED).build());
    }

    /**
     * Create a HTTP 405 (Method Not Allowed) exception.
     * 
     * @param message
     *            the String that is the entity of the 405 response.
     */
    public CustomMethodNotAllowed(String message) {
        super(Response.status(Response.Status.METHOD_NOT_ALLOWED)
                .entity(message).type("text/plain").build());
    }
}
