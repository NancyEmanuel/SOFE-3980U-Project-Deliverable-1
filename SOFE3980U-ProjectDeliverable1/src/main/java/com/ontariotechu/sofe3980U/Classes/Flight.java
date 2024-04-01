package com.ontariotechu.sofe3980U.Classes;

public class Flight {

private Airport FromAirport;
private Airport DestinationAirport;

public Flight(Airport FromAirport, Airport DestinationAirport ) {
    this.FromAirport = FromAirport;
    this.DestinationAirport = DestinationAirport;
  
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



}
