package com.ontariotechu.sofe3980U;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
                                      @RequestParam("DepartureDate") String DepartureDatestr,
                                      @RequestParam("ArriveDate") String ArriveDatestr,
                                      @RequestParam("timeFormat") String timeFormat,
                                      Model model) {

                                        LocalDate DepartureDate = LocalDate.parse(DepartureDatestr);
    LocalDate ArriveDate = LocalDate.parse(ArriveDatestr);

        //get the available flights 
        List<Flight> FlightList = getFlightlist();


      
    // filtering the flights based on user selected airports 
        List<Flight> availableFlights = new ArrayList<>();
        for (Flight flight : FlightList) {
          
            if (flight.getFromAirport().getAirportAbbreviation().equals(FromAirportAbbrev) && flight.getDestinationAirport().getAirportAbbreviation().equals(DepartureAirportAbbrev) && flight.getDepartureDate().isEqual(DepartureDate)  && 
            flight.getArriveDate().isEqual(ArriveDate)) {
                availableFlights.add(flight);
            }
        }

        model.addAttribute("availableFlights", availableFlights);
        model.addAttribute("timeFormat", timeFormat);
        return "AvailableFlights";
    }

    @PostMapping("/bookFlight")
    public String bookFlight(@RequestParam(value = "selectedFlight", required = false) Integer selectedFlightIndex,
                             @RequestParam(value = "timeFormat", required = false) String timeFormat,
                             Model model) {
        List<Flight> allFlights = getFlightlist();
        if (selectedFlightIndex != null && selectedFlightIndex >= 0 && selectedFlightIndex < allFlights.size()) {
            Flight selectedFlight = allFlights.get(selectedFlightIndex);
            String formattedTime = formatDepartureTime(selectedFlight.getDepartureTime(), timeFormat);
            model.addAttribute("selectedFlight", selectedFlight);
            model.addAttribute("formattedTime", formattedTime); // Add the formatted time to the model
            return "TicketConfirmation";
        } else {
            model.addAttribute("error", "Flight selection is invalid or not present.");
            return "AvailableFlights";
        }
    }

    @PostMapping("/Bookroundtrip")
    public String bookRoundTrip(@RequestParam("FromAirport") String FromAirportAbbrev,
                                @RequestParam("ToAirport") String ToAirportAbbrev,
                                @RequestParam("ReturnAirport") String returnAirportAbbrev,
                                Model model) {
        List<Flight> flightList = getFlightlist();
        List<Flight> outboundFlights = new ArrayList<>();
        List<Flight> returnFlights = new ArrayList<>();
        for (Flight flight : flightList) {
            if (flight.getFromAirport().getAirportAbbreviation().equals(FromAirportAbbrev) &&
                    flight.getDestinationAirport().getAirportAbbreviation().equals(ToAirportAbbrev)) {
                outboundFlights.add(flight);
            }
            if (flight.getFromAirport().getAirportAbbreviation().equals(returnAirportAbbrev) &&
                    flight.getDestinationAirport().getAirportAbbreviation().equals(FromAirportAbbrev)) {
                returnFlights.add(flight);
            }
        }
        model.addAttribute("outboundFlights", outboundFlights);
        model.addAttribute("returnFlights", returnFlights);
        return "RoundTripFlights";
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        try {
            Date departureTime1 = dateFormat.parse("10:00");
            Date departureTime2 = dateFormat.parse("15:00");
            Date departureTime3 = dateFormat.parse("21:00");

      LocalDate departureDateflight1 = LocalDate.of(2024, 4, 1); 
      LocalDate arriveDateflight1 = LocalDate.of(2024, 4, 2);

        flights.add(new Flight(
            new Airport("Toronto Pearson", "YYZ", "Canada", "100 Toronto Street", "UTC-12:00"),
            new Airport("LosAngeles International", "LAX", "USA", "500 Hollywood Blv", "UTC-03:00"),
            departureDateflight1,
        arriveDateflight1,
        departureTime1
            ));

            LocalDate departureDateflight2 = LocalDate.of(2024, 4, 3); 
            LocalDate arriveDateflight2 = LocalDate.of(2024, 4, 4);

        flights.add(new Flight(
                new Airport("Toronto Pearson", "YYZ", "Canada", "100 Toronto Street", "UTC-12:00"),
                new Airport("Heathrow Airport", "LHR", "USA", "1573 Heathrow Street", "UTC-08:00"),
                departureDateflight2,
                arriveDateflight2,
                departureTime2
        
                ));

                LocalDate departureDateflight3 = LocalDate.of(2024, 4, 5); 
    LocalDate arriveDateflight3 = LocalDate.of(2024, 4, 6); 

        flights.add(new Flight(
                new Airport("LosAngeles International", "LAX", "USA", "500 Hollywood Blv", "UTC-03:00"),
                new Airport("Dubai International Airport", "DXB", "Dubai", "56 Ortin Ave", "UTC-08:00"),
                departureDateflight3,
                arriveDateflight3,
                departureTime2
                ));


            } catch (ParseException e) {
                e.printStackTrace();
            }
        // Add more dummy flights as needed
        return flights;
    }
    
      public String convertTimeFormat(String time, String format) {
        try {
            if (format.equals("12")) {
                // Convert 24-hour format to 12-hour format
                SimpleDateFormat inFormat = new SimpleDateFormat("HH:mm");
                SimpleDateFormat outFormat = new SimpleDateFormat("hh:mm a");
                Date date = inFormat.parse(time);
                return outFormat.format(date);
            } else {
                // Convert 12-hour format to 24-hour format
                SimpleDateFormat inFormat = new SimpleDateFormat("hh:mm a");
                SimpleDateFormat outFormat = new SimpleDateFormat("HH:mm");
                Date date = inFormat.parse(time);
                return outFormat.format(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return "error TIME1127";
        }
    }
    private String formatDepartureTime(Date departureTime, String timeFormat) {
        SimpleDateFormat inFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat outFormat;

        if ("12".equals(timeFormat)) {
            outFormat = new SimpleDateFormat("hh:mm a");
        } else {
            outFormat = new SimpleDateFormat("HH:mm");
        }

        return outFormat.format(departureTime);
    }

}

