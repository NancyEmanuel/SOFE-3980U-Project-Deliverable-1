package com.ontariotechu.sofe3980U.Classes;

public class Flight {

private Airport FromAirport;
private Airport DestinationAirport;
private Airport ReturnFromAirport;
private Airport ReturnDestinationAirport;
private Airport Stops; 
private Dates DepartureTime;
private Dates ArriveTime;
private Dates ReturnDepartureTime;
private Dates ReturnArriveTime;


public Flight(Airport FromAirport, Airport DestinationAirport,  Airport ReturnFromAirport,  Airport ReturnDestinationAirport,  Airport Stops,  Dates DepartureTime, Dates ArriveTime, Dates ReturnDepartureTime, Dates ReturnArriveTime ) {
    this.FromAirport = FromAirport;
    this.DestinationAirport = DestinationAirport;
    this.ReturnFromAirport = ReturnFromAirport;
    this.ReturnDestinationAirport = ReturnDestinationAirport;
    this.Stops = Stops;
    this.DepartureTime = DepartureTime;
    this.ArriveTime = ArriveTime;
    this.ReturnDepartureTime = ReturnDepartureTime;
    this.ReturnArriveTime = ReturnArriveTime;
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



public Airport getReturnFromAirport() {
    return ReturnFromAirport;
}

public void setReturnFromAirport(Airport ReturnFromAirport) {
    this.ReturnFromAirport = ReturnFromAirport;
}


public Airport getReturnDestinationAirport() {
    return ReturnDestinationAirport;
}


public void setReturnDestinationAirport(Airport ReturnDestinationAirport) {
    this.ReturnDestinationAirport = ReturnDestinationAirport;
}



public Airport getStops() {
    return Stops;
}

public void setStops(Airport Stops) {
    this.Stops = Stops;
}

public Dates getDepartureTime() {
    return DepartureTime;
}

public void setDepartureTime(Dates DepartureTime) {
    this.DepartureTime = DepartureTime;
}


public Dates getArriveTime() {
    return ArriveTime;
}

public void setArriveTime(Dates ArriveTime) {
    this.ArriveTime = ArriveTime;
}



public Dates getReturnDepartureTime() {
    return ReturnDepartureTime;
}

public void setReturnDepartureTime(Dates ReturnDepartureTime) {
    this.ReturnDepartureTime = ReturnDepartureTime;
}



public Dates getReturnArriveTime() {
    return ReturnArriveTime;
}

public void setReturnArriveTime(Dates ReturnArriveTime) {
    this.ReturnArriveTime = ReturnArriveTime;
}


}