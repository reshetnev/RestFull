package com.epam.reshetnev.restful.test.api;

import java.net.URI;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.reshetnev.restful.entity.User;
import com.epam.reshetnev.restful.service.UserResource;

public class UserResourceTest extends JerseyTest {
    
	@SuppressWarnings("resource")
    @Override
	protected Application configure() {
	    ResourceConfig resourceConfig = new ResourceConfig(UserResource.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		resourceConfig.property("contextConfig", context);
		return resourceConfig;
	}

    @Test
	public void testGetUsers() {
		Response response = target("/users").request().get();
		Assert.assertEquals(response.getStatus(), 200);
	}

	@Test
	public void testGetUserById() {
        User user = new User("2", "b", "buser", "2b");	    
		Response response = target("/users/2").request().get();
		Assert.assertEquals(response.getStatus(), 200);
        Assert.assertEquals(user, response.readEntity(User.class));
		
	}
	
    @Test
    public void testCreateUser() {
        User user = new User("4", "d", "duser", "4d");
        Entity<User> entity = Entity.entity(user, MediaType.APPLICATION_JSON);
        Response response = target("/users").request().post(entity);
        Assert.assertEquals(response.getStatus(), 201);
        URI uri = UriBuilder.fromUri("http://localhost:8080/rest.ful/api/users/4").build();
        Assert.assertEquals(uri, response.getLocation());
    }
    
    @Test
    public void testUpdateUser() {
        User user = new User("3", "e", "euser", "5e");
        Entity<User> entity = Entity.entity(user, MediaType.APPLICATION_JSON);
        Response response = target("/users/3").request().put(entity);
        Assert.assertEquals(response.getStatus(), 200);
    }
    
    @Test
    public void testDeleteUser() {
        Response response = target("/users/3").request().delete();
        Assert.assertEquals(response.getStatus(), 200);
    }    

}
