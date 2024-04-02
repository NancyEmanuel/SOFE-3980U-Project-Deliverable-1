package com.ontariotechu.sofe3980U.Classes;

public class Airport {
    private String airportName;
    private String airportAbbreviation;
    private String airportCountry;
    private String airportAddress;
    private String airportTimezone;

    public Airport(String airportName, String airportAbbreviation, String airportCountry,
                   String airportAddress, String airportTimezone) {
        this.airportName = airportName;
        this.airportAbbreviation = airportAbbreviation;
        this.airportCountry = airportCountry;
        this.airportAddress = airportAddress;
        this.airportTimezone = airportTimezone;
    }

    public String getAirportName() { return airportName; }
    public void setAirportName(String airportName) { this.airportName = airportName; }
    public String getAirportAbbreviation() { return airportAbbreviation; }
    public void setAirportAbbreviation(String airportAbbreviation) { this.airportAbbreviation = airportAbbreviation; }
    public String getAirportCountry() { return airportCountry; }
    public void setAirportCountry(String airportCountry) { this.airportCountry = airportCountry; }
    public String getAirportAddress() { return airportAddress; }
    public void setAirportAddress(String airportAddress) { this.airportAddress = airportAddress; }
    public String getAirportTimezone() { return airportTimezone; }
    public void setAirportTimezone(String airportTimezone) { this.airportTimezone = airportTimezone; }
}

