package com.julionborges;

import com.julionborges.flight.FlightDTO;
import com.julionborges.flight.FlightService;
import com.julionborges.hotel.HotelDTO;
import com.julionborges.hotel.HotelService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("travel-order")
public class TravelOrderResource {

    @Inject
    @RestClient
    private FlightService flightService;

    @Inject
    @RestClient
    private HotelService hotelService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDTO> listAll() {
        return TravelOrder
                .<TravelOrder> listAll()
                .stream()
                .map(travelOrder -> {
                    FlightDTO flight = flightService.findByTravelOrderId(travelOrder.getId());
                    HotelDTO hotel = hotelService.findByTravelOrderId(travelOrder.getId());

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

        FlightDTO flight = new FlightDTO(travelOrder.getId(), travelOrderDto.getFromAirport(), travelOrderDto.getToAirport());
        flightService.save(flight);

        HotelDTO hotel = new HotelDTO(travelOrder.getId(), travelOrderDto.getNights());
        hotelService.save(hotel);

        return travelOrder;
    }

    @DELETE
    @Transactional
    public void delete(@QueryParam("id") Long id) {
        TravelOrder.deleteById(id);
    }
}
