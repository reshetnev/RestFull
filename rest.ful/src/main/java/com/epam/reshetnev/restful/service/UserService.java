package com.epam.reshetnev.restful.service;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.reshetnev.restful.dao.UserDao;
import com.epam.reshetnev.restful.entity.User;

@Component
@Path("/users")
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<User> getAllUsers() {        
        return userDao.getUsers().values();
    }
    
    @GET
    @Path("/{userId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User getUserById(@PathParam("userId") String userId) {
        return userDao.findUserById(userId);
    }
    
    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User createUser(User user) {
    	return userDao.createUser(user);
    }
    
    @PUT
    @Path("/{userId}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User updateUser(@PathParam("userId") String userId, User newUser) {
    	return userDao.updateUser(userId, newUser);
    }
    
    @DELETE
    @Path("/{userId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<User> deleteUser(@PathParam("userId") String userId) {
    	userDao.deleteUser(userId);
    	return getAllUsers();
    }

}
