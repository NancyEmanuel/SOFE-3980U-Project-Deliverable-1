package com.ontariotechu.sofe3980U.Classes;

public class Airport {

private String airportname;
private String airportabbreviation;
private String airportcountry;
private String airportaddress;
private String airporttimezone;

public Airport(String airportname, String airportabbreviation, String airportcountry, String airportaddress, String airporttimezone  ) {
    this.airportname = airportname;
    this.airportabbreviation = airportabbreviation;
    this.airportcountry = airportcountry;
    this.airportaddress = airportaddress;
    this.airporttimezone = airporttimezone;
}

// get and set the listed variables 

public void setairportname(String airportname) {
    this.airportname = airportname;
}

public String getairportname() {
    return airportname;
}

public void setairportabbreviation(String airportabbreviation) {
    this.airportabbreviation = airportabbreviation;
}

public String getairportabbreviation() {
    return airportabbreviation;
}

public void setairportcountry(String airportcountry) {
    this.airportcountry = airportcountry;
}

public String getairportcountry() {
    return airportcountry;
}

public void setairportaddress(String airportaddress) {
    this.airportaddress = airportaddress;
}

public String getairportaddress() {
    return airportaddress;
}

public void setairporttimezone(String airporttimezone) {
    this.airporttimezone = airporttimezone;
}

public String getairporttimezone() {
    return airporttimezone;
}


}