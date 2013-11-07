package com.restclient.client;

/**
 * User: jenda_000
 * Date: 31.10.13
 * Time: 21:40
 */


import com.restclient.model.Hotel;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Client that knows how to interact with the Hotel REST web service
 * @author Jan Hrubeš
 */
public class HotelClient extends BaseClient
{
    public HotelClient(String baseUrl) {
        super(baseUrl);
    }

    /**
     * Queries the RESTful web service for all hotels
     *
     * @return List<Hotel> hotels
     */
    public List<Hotel> getHotels()
    {
        WebTarget hotelResource = this.resource.path("hotels");

        Invocation.Builder builder = hotelResource.request(MediaType.APPLICATION_JSON);

        // Set the path from which we wish to get the object, request XML, and use JAXB
        // to convert the response to a Book object
        List<Hotel> hotels = builder.get( new GenericType<List<Hotel>>() {});

        // Return the book from the server
        return hotels;
    }

    /**
     * Queries the RESTful web service for the hotel with the specified id
     *
     * @param id        The id of the hotel to retrieve
     *
     * @return          A Hotel object representing the response from the RESTful web service
     */
    public Hotel getHotel( String id )
    {
        WebTarget hotelResource = this.resource.path("hotel/" + id);

        Invocation.Builder builder = hotelResource.request(MediaType.APPLICATION_JSON);

        Hotel hotel = builder.get(Hotel.class);

        // Set the path from which we wish to get the object, request XML, and use JAXB
        // to convert the response to a Book object

        // Return the book from the server
        return hotel;
    }
}