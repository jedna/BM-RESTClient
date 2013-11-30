package com.restclient.client;

import com.restclient.model.Hotel;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Client that knows how to interact with the Hotel REST web service
 *
 * @author Jan Hrubeš
 */

public class HotelClient extends BaseClient
{
    public HotelClient() {
        this.setBaseUrl("http://localhost:8080/rest/hotel");
    }

    /**
     * Queries the RESTful web service for all hotels
     *
     * @return List<Hotel> hotels
     */
    public List<Hotel> getHotels()
    {
        WebTarget hotelResource = this.getResource().path("");

        Invocation.Builder builder = hotelResource.request(MediaType.APPLICATION_JSON);

        return builder.get( new GenericType<List<Hotel>>() {});
    }

    /**
     * Queries the RESTful web service for the hotel with the specified id
     *
     * @param id        The id of the hotel to retrieve
     *
     * @return          A Hotel object representing the response from the RESTful web service
     */
    public Hotel getHotel( Long id )
    {
        WebTarget hotelResource = this.getResource().path(id.toString());

        Invocation.Builder builder = hotelResource.request(MediaType.APPLICATION_JSON);

        return builder.get(Hotel.class);
    }

    public Hotel createHotel(Hotel hotel)
    {
        WebTarget hotelResource = this.getResource().path("create");

        Invocation.Builder builder = hotelResource.request();

        return builder.post(Entity.json(hotel), Hotel.class);
    }
}