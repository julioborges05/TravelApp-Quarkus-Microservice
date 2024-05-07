package com.julionborges.flight;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8081/flight")
public interface FlightService {

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public FlightDTO findById(@QueryParam("id") Long id);

    @GET
    @Path("findByTravelOrderId")
    @Produces(MediaType.APPLICATION_JSON)
    public FlightDTO findByTravelOrderId(@QueryParam("travelOrderId") Long travelOrderId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public FlightDTO save(FlightDTO flight);

}
