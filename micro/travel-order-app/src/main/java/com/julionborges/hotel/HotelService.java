package com.julionborges.hotel;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:8082/hotel")
public interface HotelService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HotelDTO> listAll();

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public HotelDTO findById(Long id);

    @GET
    @Path("findByTravelOrderId")
    @Produces(MediaType.APPLICATION_JSON)
    public HotelDTO findByTravelOrderId(Long travelOrderId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public HotelDTO save(HotelDTO hotel);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public HotelDTO updateHotel(HotelDTO hotel);

    @DELETE
    public void deleteById(Long id);


}
