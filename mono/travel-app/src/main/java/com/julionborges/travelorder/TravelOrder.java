package com.julionborges.travelorder;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class TravelOrder extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name = "travelOrderSequence",
            sequenceName = "travel_order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "travelOrderSequence")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
