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
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Component
@Path("/users")
@Api(value = "/users", description = "Operations about users")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class UserService {

    @Autowired
    private UserDao userDao;

    @GET
    @ApiOperation(value = "Get the collection (list the users)",
    response = User.class,
    responseContainer = "ConcurrentMap")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok") })
    public Response getUsers() {
        return Response.status(200).entity(userDao.getUsers()).build();
    }

    @GET
    @Path("/{userId}")
    @ApiOperation(value = "Retrieve a representation of the user.",
    response = User.class,
    responseContainer = "User")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
    	      @ApiResponse(code = 404, message = "User not found") })
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
    public Response deleteUser(@PathParam("userId") String userId) {
        boolean result = userDao.deleteUser(userId);
        if (!result) {
            throw new CustomInternalServerError("User with userId = " + userId
                    + " not exists.");
        }
        return Response.status(200).entity(userDao.getUsers()).build();
    }

}
