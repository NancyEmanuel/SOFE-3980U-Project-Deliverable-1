package com.ontariotechu.sofe3980U.Classes;

import java.time.LocalDate;

public class Flight {

private Airport FromAirport;
private Airport DestinationAirport;
private LocalDate DepartureTime;
private LocalDate ArriveTime;



public Flight(Airport FromAirport, Airport DestinationAirport, LocalDate DepartureTime, LocalDate ArriveTime ) {
    this.FromAirport = FromAirport;
    this.DestinationAirport = DestinationAirport;
    this.DepartureTime = DepartureTime;
    this.ArriveTime = ArriveTime;
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
public LocalDate getDepartureTime() {
    return DepartureTime;
}

public void setDepartureTime(LocalDate DepartureTime) {
    this.DepartureTime = DepartureTime;
}

public LocalDate getArriveTime() {
    return ArriveTime;
}

public void setArriveTime(LocalDate ArriveTime) {
    this.ArriveTime = ArriveTime;
}

}

