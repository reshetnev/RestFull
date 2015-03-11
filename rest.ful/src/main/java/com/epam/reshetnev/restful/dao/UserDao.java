package com.epam.reshetnev.restful.dao;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.epam.reshetnev.restful.entity.User;

public class UserDao {
    private ConcurrentMap<String, User> users;
    
    public UserDao() {
        users = new ConcurrentHashMap<String, User>();
        users.put("1", new User("1","a","auser","1a"));
        users.put("2", new User("2","b","buser","2b"));
        users.put("3", new User("3","c","cuser","3c"));        
    }

    public ConcurrentMap<String, User> getUsers() {
        return users;
    }
    
    public User findUserById(String userId) {
        return users.get(userId);
    }
    
    public User createUser(User user) {
        users.put(user.getUserId(), user);
        return findUserById(user.getUserId());
    }
    
    public User updateUser(String userId, User newUser) {
        return users.replace(userId, newUser);
    }
    
    public ConcurrentMap<String, User> deleteUser(String userId) {
    	users.remove(userId);
        return getUsers();
    }

}
