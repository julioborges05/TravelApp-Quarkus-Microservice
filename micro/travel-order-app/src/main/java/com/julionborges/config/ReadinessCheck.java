package com.julionborges.config;

import com.julionborges.flight.FlightService;
import com.julionborges.hotel.HotelService;
import jakarta.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @Inject
    @RestClient
    private FlightService flightService;

    @Inject
    @RestClient
    private HotelService hotelService;

    @Override
    public HealthCheckResponse call() {

        if (flightService.findById(1L) != null && hotelService.findById(1L) != null)
            return HealthCheckResponse.up("Ready");

        return HealthCheckResponse.down("Not ready");
    }

}
