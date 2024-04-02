package com.ontariotechu.sofe3980U.Classes;

import java.time.LocalDate;
import java.util.Date;

public class Flight {
    private Airport FromAirport;
    private Airport DestinationAirport;
    private LocalDate DepartureDate;
    private LocalDate ArriveDate;
    private Date departureTime;

    public Flight(
        Airport FromAirport, Airport DestinationAirport, LocalDate DepartureDate, LocalDate ArriveDate,
        Date departureTime
    ) {
        this.FromAirport = FromAirport;
        this.DestinationAirport = DestinationAirport;
        this.DepartureDate = DepartureDate;
        this.ArriveDate = ArriveDate;
        this.departureTime = departureTime;
    }

    // get and set the listed variables
    public Airport getFromAirport() {
        return FromAirport;
    }

    public void setFromAirport(Airport FromAirport) {
        this.FromAirport = FromAirport;
    }

    public Airport getDestinationAirport() {
        return DestinationAirport;
    }

    public void setDestinationAirport(Airport DestinationAirport) {
        this.DestinationAirport = DestinationAirport;
    }

    public LocalDate getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(LocalDate DepartureDate) {
        this.DepartureDate = DepartureDate;
    }

    public LocalDate getArriveDate() {
        return ArriveDate;
    }

    public void setArriveDate(LocalDate ArriveDate) {
        this.ArriveDate = ArriveDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

}
