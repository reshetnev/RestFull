package com.epam.reshetnev.restful;

import java.util.Collection;

import com.epam.reshetnev.restful.entity.User;
import com.epam.reshetnev.restful.service.UserService;

public class RestClient {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Collection<User> users= userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

    }

}
