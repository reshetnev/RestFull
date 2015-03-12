package com.epam.reshetnev.restful.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class CustomInternalServerError extends WebApplicationException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create a HTTP 500 (Internal Server Error) exception.
     */
    public CustomInternalServerError() {
        super(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
    }

    /**
     * Create a HTTP 500 (Internal Server Error) exception.
     * 
     * @param message
     *            the String that is the entity of the 500 response.
     */
    public CustomInternalServerError(String message) {
        super(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(message).type("text/plain").build());
    }
}
