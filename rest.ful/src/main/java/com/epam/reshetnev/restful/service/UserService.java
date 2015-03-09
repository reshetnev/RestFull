package com.epam.reshetnev.restful.service;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.epam.reshetnev.restful.dao.UserDao;
import com.epam.reshetnev.restful.entity.User;

@Path("/users")
public class UserService {
    private UserDao userDao = new UserDao();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getAllUsers() {
        Collection<User> users = userDao.getUsers().values();
        return users;
    }
    
    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(String userId) {
        return userDao.findUserById(userId);
    }

}
