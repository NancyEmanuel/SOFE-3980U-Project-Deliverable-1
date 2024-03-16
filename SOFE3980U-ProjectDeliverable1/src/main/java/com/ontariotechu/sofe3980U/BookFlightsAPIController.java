package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BookFlightsAPIController {


//driect flight endpoint
	@GetMapping("/Bookdirect")
	public String Bookdirect(@RequestParam(name="FromAirport", required=true, defaultValue="") String FromAirport,
                       @RequestParam(name="DestinationAirport", required=true, defaultValue="") String DestinationAirport,
					   @RequestParam(name="DepartureTime", required=false, defaultValue="") String DepartureTime,
					   @RequestParam(name="ArriveTime", required=false, defaultValue="") String ArriveTime,
					   @RequestParam(name="Passengers", required=false, defaultValue="") String Passengers,
					   @RequestParam(name="FullName", required=false, defaultValue="") String FullName){
		//String Flight = FromAirport, DestinationAirport, DepartureTime, ArriveTime, Passengers, FullName;

		//concatenates strings together to make flight string containing all direct flight info 
		String Flight = FromAirport + DestinationAirport + DepartureTime + ArriveTime + Passengers + FullName  ;
// return message 
		return "Direct flight booked " + Flight;
		//return Flight.toString();
		//return Flight;
   
   
		  // test ex: http://localhost:8080/Bookdirect?FromAirport=LAX&DestinationAirport=TorontoPearson&FullName=JaneDoe: LAXTorontoPearsonJaneDoe
		 
	}
	


	//multistop flight endpoint
	@GetMapping("/Bookmultistop")
	public String Bookmultistop(@RequestParam(name="FromAirport", required=true, defaultValue="") String FromAirport,
                       @RequestParam(name="DestinationAirport", required=true, defaultValue="") String DestinationAirport,
					   @RequestParam(name="DepartureTime", required=false, defaultValue="") String DepartureTime,
					   @RequestParam(name="ArriveTime", required=false, defaultValue="") String ArriveTime,
					   @RequestParam(name="Stops", required=false, defaultValue="") String Stops,
					   @RequestParam(name="Passengers", required=false, defaultValue="") String Passengers,
					   @RequestParam(name="FullName", required=false, defaultValue="") String FullName) {
		//concatenates strings together to make flight string containing all multistop flight info 

		String Flight = FromAirport + DestinationAirport + DepartureTime + ArriveTime + Stops + Passengers + FullName;
///return message 
		return "Multistop flight booked " + Flight;
  
		
	}
	//oneway flight endpooint

	@GetMapping("/Bookoneway")
	public String Bookoneway(@RequestParam(name="FromAirport", required=true, defaultValue="") String FromAirport,
                       @RequestParam(name="DestinationAirport", required=true, defaultValue="") String DestinationAirport,
					   @RequestParam(name="DepartureTime", required=false, defaultValue="") String DepartureTime,
					   @RequestParam(name="ArriveTime", required=false, defaultValue="") String ArriveTime,
					   @RequestParam(name="Passengers", required=false, defaultValue="") String Passengers,
					   @RequestParam(name="FullName", required=false, defaultValue="") String FullName) {

		//concatenates strings together to make flight string containing all oneway flight info 

			String Flight = FromAirport + DestinationAirport + DepartureTime + ArriveTime + Passengers + FullName;
//return message 
		return "Oneway flight booked " + Flight;
     
		// http://localhost:8080/
	}

	//roundtrip endpoint 
	@GetMapping("/BookRoundTrip")
	public String BookRoundTrip(@RequestParam(name="FromAirport", required=true, defaultValue="") String FromAirport,
                       @RequestParam(name="DestinationAirport", required=true, defaultValue="") String DestinationAirport,
					   @RequestParam(name="DepartureTime", required=false, defaultValue="") String DepartureTime,
					   @RequestParam(name="ArriveTime", required=false, defaultValue="") String ArriveTime,
					   @RequestParam(name="ReturnFromAirport", required=false, defaultValue="") String ReturnFromAirport,
                       @RequestParam(name="ReturnDestinationAirport", required=false, defaultValue="") String ReturnDestinationAirport,
					   @RequestParam(name="ReturnDepartureTime", required=false, defaultValue="") String ReturnDepartureTime,
					   @RequestParam(name="ReturnArriveTime", required=false, defaultValue="") String ReturnArriveTime,
					   @RequestParam(name="Passengers", required=false, defaultValue="") String Passengers, 
					   @RequestParam(name="FullName", required=false, defaultValue="") String FullName) {
			String Flight = FromAirport + DestinationAirport + DepartureTime + ArriveTime + ReturnFromAirport + ReturnDestinationAirport + ReturnDepartureTime + ReturnArriveTime + Passengers + FullName;

		return "Roundtrip flight booked " + Flight;
    
		// http://localhost:8080/
	}
	

}