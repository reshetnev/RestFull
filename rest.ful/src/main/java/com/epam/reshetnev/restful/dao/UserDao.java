package com.epam.reshetnev.restful.dao;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.epam.reshetnev.restful.entity.User;

public class UserDao {
    private ConcurrentMap<String, User> users;
    private int count = 1;
    private String key = Integer.toString(count);    
    
    public UserDao() {
        users = new ConcurrentHashMap<String, User>();
        users.put(key, new User(key,"a","auser","1a"));
        count++;
        key = Integer.toString(count);    
        users.put(key, new User(key,"b","buser","2b"));
        count++;
        key = Integer.toString(count);    
        users.put(key, new User(key,"c","cuser","3c"));        
        count++;
        key = Integer.toString(count);    
    }

    public ConcurrentMap<String, User> getUsers() {
        return users;
    }
    
    public User findUserById(String userId) {
        return users.get(userId);
    }
    
    public boolean createUser(User user) {
        boolean result = false;
        if (!users.containsKey(key)) {
            users.put(key, user);
            result = true;
            count++;
            key = Integer.toString(count);    
        }
        return result;
    }
    
    public boolean updateUser(String userId, User newUser) {
        return users.replace(userId, users.get(userId), newUser);
    }
    
    public boolean deleteUser(String userId, User user) {
        return users.remove(userId, user);
    }

}
