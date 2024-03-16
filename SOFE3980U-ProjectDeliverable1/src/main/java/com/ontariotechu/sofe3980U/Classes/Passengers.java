package com.ontariotechu.sofe3980U.Classes;

public class Passengers {

private String FullName;
private int passengernumber;
private String passengeremailaddress;

public Passengers(String FullName, int passengernumber, String passengeremailaddress) {
    this.FullName = FullName;
    this.passengernumber = passengernumber;
    this.passengeremailaddress = passengeremailaddress;
}
// get and set the listed variables 

public String getFullname() {
    return FullName;
}

public void setFullname(String FullName) {
    this.FullName = FullName;
}

public int getpassengernumber() {
    return passengernumber;
}

public void setpassengernumber(int passengernumber) {
    this.passengernumber = passengernumber;
}

public String getpassengeremailaddress() {
    return passengeremailaddress;
}

public void setpassengeremailaddress(String passengeremailaddress) {
    this.passengeremailaddress = passengeremailaddress;
}

}
