package com.ontariotechu.sofe3980U;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.ontariotechu.sofe3980U.Classes.Airport;
import com.ontariotechu.sofe3980U.Classes.Flight;

@Controller
public class BookFlightsInterfaceController {

  

    @GetMapping("/")
    public String getBookingView(@RequestParam(name = "FullName", required = false, defaultValue = "") String FullName, Model model) {
        model.addAttribute("FullName", FullName);
        List<Airport> airports = getAirports(); //return airport list 
        model.addAttribute("airports", airports);
        return "BookingInterface"; 
    }



    @PostMapping("/Bookdirect")
    public String findAvailableFlights(@RequestParam("FromAirport") String FromAirportAbbrev,
                                      @RequestParam("DepartureAirport") String DepartureAirportAbbrev,
                                      @RequestParam("DepartureTime") String DepartureTimestr,
                                      @RequestParam("ArriveTime") String ArriveTimestr,
                                      Model model) {

                                        LocalDate DepartureTime = LocalDate.parse(DepartureTimestr);
    LocalDate ArriveTime = LocalDate.parse(ArriveTimestr);

        //get the available flights 
        List<Flight> FlightList = getFlightlist();


      
    // filtering the flights based on user selected airports 
        List<Flight> availableFlights = new ArrayList<>();
        for (Flight flight : FlightList) {
          
            if (flight.getFromAirport().getairportabbreviation().equals(FromAirportAbbrev) && flight.getDestinationAirport().getairportabbreviation().equals(DepartureAirportAbbrev) && flight.getDepartureTime().isEqual(DepartureTime)  && 
            flight.getArriveTime().isEqual(ArriveTime)) {
                availableFlights.add(flight);
            }
        }

        model.addAttribute("availableFlights", availableFlights);
        return "AvailableFlights";
    }

    // Returns a list of the airports

    private List<Airport> getAirports() {
       
        List<Airport> airports = new ArrayList<>();
        airports.add(new Airport("Toronto Pearson", "YYZ", "Canada", "100 Toronto Street", "UTC-12:00"));
        airports.add(new Airport("LosAngeles International", "LAX", "USA", "500 Hollywood Blv", "UTC-03:00"));
        airports.add(new Airport("Hartsfield–Jackson Atlanta International Airport", "ATL", "USA", "46 Rouge Ave", "UTC-07:00"));
        airports.add(new Airport("Dubai International Airport", "DXB", "Dubai", "56 Ortin Ave", "UTC-08:00"));

        
        return airports;
    }

    private List<Flight> getFlightlist() {
        List<Flight> flights = new ArrayList<>();
      

      LocalDate departureTimeflight1 = LocalDate.of(2024, 4, 1); 
      LocalDate arriveTimeflight1 = LocalDate.of(2024, 4, 2);

        flights.add(new Flight(
            new Airport("Toronto Pearson", "YYZ", "Canada", "100 Toronto Street", "UTC-12:00"),
            new Airport("LosAngeles International", "LAX", "USA", "500 Hollywood Blv", "UTC-03:00"),
            departureTimeflight1,
        arriveTimeflight1

            ));

            LocalDate departureTimeflight2 = LocalDate.of(2024, 4, 3); 
            LocalDate arriveTimeflight2 = LocalDate.of(2024, 4, 4);

        flights.add(new Flight(
                new Airport("Toronto Pearson", "YYZ", "Canada", "100 Toronto Street", "UTC-12:00"),
                new Airport("Heathrow Airport", "LHR", "USA", "1573 Heathrow Street", "UTC-08:00"),
                departureTimeflight2,
                arriveTimeflight2
        
                ));

                LocalDate departureTimeflight3 = LocalDate.of(2024, 4, 5); 
    LocalDate arriveTimeflight3 = LocalDate.of(2024, 4, 6); 

        flights.add(new Flight(
                new Airport("LosAngeles International", "LAX", "USA", "500 Hollywood Blv", "UTC-03:00"),
                new Airport("Dubai International Airport", "DXB", "Dubai", "56 Ortin Ave", "UTC-08:00"),
                departureTimeflight3,
                arriveTimeflight3
                ));
        // Add more dummy flights as needed
        return flights;
    }
    

}

