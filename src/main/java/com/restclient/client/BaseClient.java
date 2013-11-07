package com.restclient.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * BaseClient class
 */
public class BaseClient {

    private String baseUrl;
    protected WebTarget resource;

    /**
     * Constructor
     * @param baseUrl
     */
    public BaseClient(String baseUrl)
    {
        this.baseUrl = baseUrl;
        Client client = ClientBuilder.newClient();
        this.resource = client.target(baseUrl);
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public void setBaseUrl( String baseUrl )
    {
        this.baseUrl = baseUrl;
    }
}
