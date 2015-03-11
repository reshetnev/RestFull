package com.epam.reshetnev.restful.service;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.reshetnev.restful.dao.UserDao;
import com.epam.reshetnev.restful.entity.User;
import com.epam.reshetnev.restful.exception.CustomInternalServerError;
import com.epam.reshetnev.restful.exception.CustomNotFoundException;

@Component
@Path("/users")
public class UserService {

    @Autowired
    private UserDao userDao;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getUsers() {
        return Response.status(200).entity(userDao.getUsers()).build();
    }

    @GET
    @Path("/{userId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getUserById(@PathParam("userId") String userId) {
        User user = userDao.getUserById(userId);
        if (user == null) {
            throw new CustomNotFoundException("User with userId = " + userId
                    + " is not found.");
        }
        return Response.status(200).entity(user).build();
    }

    @POST
    @Path("/create")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response createUser(User user) {
        URI createdUri = UriBuilder.fromUri(
                "http://localhost:8080/rest/users/" + user.getUserId()).build();
        boolean result = userDao.createUser(user);
        if (!result) {
            throw new CustomInternalServerError("User with userId = "
                    + user.getUserId() + " already exists.");
        }
        return Response.created(createdUri).entity(userDao.getUsers()).build();
    }

    @PUT
    @Path("/{userId}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateUser(@PathParam("userId") String userId, User newUser) {
        boolean result = userDao.updateUser(userId, newUser);
        if (!result) {
            throw new CustomInternalServerError("User with userId = " + userId
                    + " not exists.");
        }
        return Response.status(200).entity(userDao.getUsers()).build();
    }

    @DELETE
    @Path("/{userId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response deleteUser(@PathParam("userId") String userId) {
        boolean result = userDao.deleteUser(userId);
        if (!result) {
            throw new CustomInternalServerError("User with userId = " + userId
                    + " not exists.");
        }
        return Response.status(200).entity(userDao.getUsers()).build();
    }

}
