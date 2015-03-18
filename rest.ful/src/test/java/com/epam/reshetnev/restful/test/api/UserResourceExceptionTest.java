package com.epam.reshetnev.restful.test.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.reshetnev.restful.entity.User;
import com.epam.reshetnev.restful.exception.CustomNotFoundException;
import com.epam.reshetnev.restful.resource.UserResource;

public class UserResourceExceptionTest extends JerseyTest {

    @SuppressWarnings("resource")
    @Override
    protected Application configure() {
        ResourceConfig resourceConfig = new ResourceConfig(UserResource.class);
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml");
        resourceConfig.property("contextConfig", context);
        return resourceConfig;
    }

    @Test
    public void testGetUserById() throws CustomNotFoundException {
        Response response = target("/users/5").request().get();
        Assert.assertEquals("User with userId = 5 is not found.",
                response.getStatus(), 404);
    }

    @Test
    public void testCreateUser() {
        User user = new User("1", "d", "duser", "4d");
        Entity<User> entity = Entity.entity(user, MediaType.APPLICATION_JSON);
        Response response = target("/users").request().post(entity);
        Assert.assertEquals("User with userId = 1 already exists.",
                response.getStatus(), 500);
    }

    @Test
    public void testUpdateUser() {
        User user = new User("5", "e", "euser", "5e");
        Entity<User> entity = Entity.entity(user, MediaType.APPLICATION_JSON);
        Response response = target("/users/5").request().put(entity);
        Assert.assertEquals("User with userId = 5 not exists.",
                response.getStatus(), 405);
    }

    @Test
    public void testDeleteUser() {
        Response response = target("/users/4").request().delete();
        Assert.assertEquals("User with userId = 4 not exists.",
                response.getStatus(), 500);
    }
}
