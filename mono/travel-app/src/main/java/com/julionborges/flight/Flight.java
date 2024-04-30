package com.julionborges.flight;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class Flight extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name = "flightSequence",
            sequenceName = "flight_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flightSequence")
    private Long id;
    private Long travelOrderId;
    private String fromAirport;
    private String toAirport;

    public Flight() {
    }

    public Flight(Long travelOrderId, String fromAirport, String toAirport) {
        this.travelOrderId = travelOrderId;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
    }

    public static Optional<Flight> findByTravelOrderId(Long travelOrderId) {
        return Flight.find("travelOrderId", travelOrderId).singleResultOptional();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTravelOrderId() {
        return travelOrderId;
    }

    public void setTravelOrderId(Long travelOrderId) {
        this.travelOrderId = travelOrderId;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }
}
