package com.julionborges.travelorder;

import com.julionborges.flight.Flight;
import com.julionborges.flight.FlightResource;
import com.julionborges.hotel.Hotel;
import com.julionborges.hotel.HotelResource;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("travel-order")
public class TravelOrderResource {

    @Inject
    private FlightResource flightResource;

    @Inject
    private HotelResource hotelResource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDTO> listAll() {
        return TravelOrder
                .<TravelOrder> listAll()
                .stream()
                .map(travelOrder -> {
                    Flight flight = flightResource.findByTravelOrderId(travelOrder.getId());
                    Hotel hotel = hotelResource.findByTravelOrderId(travelOrder.getId());

                    return TravelOrderDTO.of(flight, hotel);
                })
                .collect(Collectors.toList());
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
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder save(TravelOrderDTO travelOrderDto) {
        TravelOrder travelOrder = new TravelOrder();
        travelOrder.setId(null);
        travelOrder.persist();

        Flight flight = new Flight(travelOrder.getId(), travelOrderDto.getFromAirport(), travelOrderDto.getToAirport());
        flightResource.save(flight);

        Hotel hotel = new Hotel(travelOrder.getId(), travelOrderDto.getNights());
        hotelResource.save(hotel);

        return travelOrder;
    }

    @DELETE
    @Transactional
    public void delete(@QueryParam("id") Long id) {
        TravelOrder.deleteById(id);
    }
}
