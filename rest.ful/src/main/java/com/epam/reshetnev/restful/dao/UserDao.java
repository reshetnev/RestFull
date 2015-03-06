package com.epam.reshetnev.restful.dao;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.epam.reshetnev.restful.entity.User;

public class UserDao {
    private ConcurrentMap<Long, User> users;
    private Long key;
    
    public UserDao() {
        users = new ConcurrentHashMap<Long, User>();
        users.put(1L, new User(1L,"a","auser","1a"));
        users.put(2L, new User(2L,"b","buser","2b"));
        users.put(3L, new User(3L,"c","cuser","3c"));        
        key = new Long(4L);
    }

    public ConcurrentMap<Long, User> getUsers() {
        return users;
    }
    
    public User findUserById(Long userId) {
        return users.get(userId);
    }
    
    public boolean createUser(User user) {
        boolean result = false;
        if (!users.containsKey(key)) {
            users.put(key, user);
            result = true;
            key++;
        }
        return result;
    }
    
    public boolean updateUser(Long userId, User newUser) {
        return users.replace(userId, users.get(userId), newUser);
    }
    
    public boolean deleteUser(Long userId, User user) {
        return users.remove(userId, user);
    }

}
