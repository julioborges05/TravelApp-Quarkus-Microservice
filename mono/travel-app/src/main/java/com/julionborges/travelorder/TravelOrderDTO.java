package com.julionborges.travelorder;

import com.julionborges.flight.Flight;
import com.julionborges.hotel.Hotel;

public class TravelOrderDTO {

    private String fromAirport;
    private String toAirport;
    private Integer nights;

    public TravelOrderDTO() {
    }

    public TravelOrderDTO(String fromAirport, String toAirport, Integer nights) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.nights = nights;
    }

    public static TravelOrderDTO of(Flight flight, Hotel hotel) {
        return new TravelOrderDTO(flight.getFromAirport(), flight.getToAirport(), hotel.getNights());
    }

    public static TravelOrderDTO of(String fromAirport, String toAirport, Integer nights) {
        return new TravelOrderDTO(fromAirport, toAirport, nights);
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

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }
}
