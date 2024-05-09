package com.julionborges.flight;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://flight-app-svc:8081/flight")
public interface FlightService {

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    FlightDTO findById(@QueryParam("id") Long id);

    @GET
    @Path("findByTravelOrderId")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(value = 2000)
    @Fallback(fallbackMethod = "fallback")
    @CircuitBreaker(
            requestVolumeThreshold = 4,
            failureRatio = 0.5,
            delay = 5000,
            successThreshold = 2
    )
    FlightDTO findByTravelOrderId(@QueryParam("travelOrderId") Long travelOrderId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    FlightDTO save(FlightDTO flight);

    default FlightDTO fallback(Long travelOrderId) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setTravelOrderId(travelOrderId);
        flightDTO.setFromAirport("");
        flightDTO.setToAirport("");

        return flightDTO;
    }

}
