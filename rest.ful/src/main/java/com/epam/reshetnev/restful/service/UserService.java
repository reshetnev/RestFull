package com.epam.reshetnev.restful.service;

import java.util.Collection;

import javax.ws.rs.GET;
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
        Collection<User> users = userDao.getUsers().values();
        return users;
    }
    
    @GET
    @Path("/{userId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User getUserById(@PathParam("userId") String userId) {
        return userDao.findUserById(userId);
    }

}
