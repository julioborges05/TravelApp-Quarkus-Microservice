package com.julionborges.hotel;

public class HotelDTO {

    private Long id;
    private Long travelOrderId;
    private Integer nights;

    public HotelDTO() {
    }

    public HotelDTO(Long travelOrderId, Integer nights) {
        this.travelOrderId = travelOrderId;
        this.nights = nights;
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
