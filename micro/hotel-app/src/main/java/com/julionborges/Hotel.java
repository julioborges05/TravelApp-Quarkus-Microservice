package com.julionborges;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class Hotel extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name = "hotelSequence",
            sequenceName = "hotel_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotelSequence")
    private Long id;
    private Long travelOrderId;
    private Integer nights;

    public Hotel() {
    }

    public Hotel(Long travelOrderId, Integer nights) {
        this.travelOrderId = travelOrderId;
        this.nights = nights;
    }

    public static Optional<Hotel> findByTravelOrderId(Long travelOrderId) {
        return Hotel.find("travelOrderId", travelOrderId).singleResultOptional();
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

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }
}
