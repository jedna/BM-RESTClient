package com.restclient.client;

import com.restclient.model.User;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Client that knows how to interact with the User REST web service
 * @author Jan Hrubeš
 */
public class UserClient extends BaseClient
{
    public UserClient(String baseUrl) {
        super(baseUrl);
    }

    /**
     * Queries the RESTful web service for all users
     *
     * @return List<User> users
     */
    public List<User> getUsers()
    {
        WebTarget userResource = this.resource.path("users");

        Invocation.Builder builder = userResource.request(MediaType.APPLICATION_JSON);

        // Set the path from which we wish to get the object, request XML, and use JAXB
        // to convert the response to a Book object
        List<User> users = builder.get( new GenericType<List<User>>() {});

        // Return the book from the server
        return users;
    }

    /**
     * Queries the RESTful web service for the user with the specified id
     *
     * @param id        The id of the user to retrieve
     *
     * @return User     A User object representing the response from the RESTful web service
     */
    public User getUser( String id )
    {
        WebTarget userResource = this.resource.path("user/" + id);

        Invocation.Builder builder = userResource.request(MediaType.APPLICATION_JSON);

        User user = builder.get(User.class);

        // Set the path from which we wish to get the object, request XML, and use JAXB
        // to convert the response to a Book object

        // Return the book from the server
        return user;
    }
}