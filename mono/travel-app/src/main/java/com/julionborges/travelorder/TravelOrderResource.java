package com.julionborges.travelorder;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("travel-order")
public class TravelOrderResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrder> listAll() {
        return TravelOrder.listAll();
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder getById(@QueryParam("id") Long id) {
        Optional<TravelOrder> optionalTravelOrder = TravelOrder.findByIdOptional(id);

        if(optionalTravelOrder.isEmpty())
            throw new NotFoundException("Não encontrado!");

        return optionalTravelOrder.get();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public TravelOrder save(TravelOrder travelOrder) {
        travelOrder.setId(null);
        travelOrder.persist();

        return travelOrder;
    }

    @DELETE
    @Transactional
    public void delete(@QueryParam("id") Long id) {
        TravelOrder.deleteById(id);
    }
}
