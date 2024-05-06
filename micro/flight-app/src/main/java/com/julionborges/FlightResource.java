package com.julionborges;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("flight")
public class FlightResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Flight> listAll() {
        return Flight.listAll();
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Flight findById(@QueryParam("id") Long id) {
        Optional<Flight> optionalFlight = Flight.findByIdOptional(id);

        if(optionalFlight.isEmpty())
            throw new NotFoundException("Não encontrado!");

        return optionalFlight.get();
    }

    @GET
    @Path("findByTravelOrderId")
    @Produces(MediaType.APPLICATION_JSON)
    public Flight findByTravelOrderId(@QueryParam("travelOrderId") Long travelOrderId) {
        Optional<Flight> optionalFlight = Flight.findByTravelOrderId(travelOrderId);

        if(optionalFlight.isEmpty())
            throw new NotFoundException("Não encontrado!");

        return optionalFlight.get();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Flight save(Flight flight) {
        flight.setId(null);
        flight.persist();

        return flight;
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Flight update(Flight flight) {
        Optional<Flight> optionalFlight = Flight.findByIdOptional(flight.getId());

        if(optionalFlight.isEmpty())
            throw new NotFoundException("Não encontrado!");

        Flight dbFlight = optionalFlight.get();
        dbFlight.setTravelOrderId(flight.getTravelOrderId());
        dbFlight.setFromAirport(flight.getFromAirport());
        dbFlight.setToAirport(flight.getToAirport());
        dbFlight.persist();

        return dbFlight;
    }

    @DELETE
    @Transactional
    public void deleteById(@QueryParam("id") Long id) {
        Flight.deleteById(id);
    }

}
