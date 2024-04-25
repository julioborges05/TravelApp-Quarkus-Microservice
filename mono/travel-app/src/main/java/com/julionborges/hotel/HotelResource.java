package com.julionborges.hotel;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("hotel")
public class HotelResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> listAll() {
        return Hotel.listAll();
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel findById(@QueryParam("id") Long id) {
        Optional<Hotel> optionalHotel = Hotel.findByIdOptional(id);

        if(optionalHotel.isEmpty())
            throw new NotFoundException("Não encontrado!");

        return optionalHotel.get();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel save(Hotel hotel) {
        hotel.setId(null);
        hotel.persist();

        return hotel;
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel updateHotel(Hotel hotel) {
        Optional<Hotel> optionalHotel = Hotel.findByIdOptional(hotel.getId());

        if(optionalHotel.isEmpty())
            throw new NotFoundException("Não encontrado!");

        Hotel dbHotel = optionalHotel.get();
        dbHotel.setTravelOrderId(hotel.getTravelOrderId());
        dbHotel.setNights(hotel.getNights());
        dbHotel.persist();

        return dbHotel;
    }

    @DELETE
    @Transactional
    public void deleteById(@QueryParam("id") Long id) {
        Hotel.deleteById(id);
    }

}
