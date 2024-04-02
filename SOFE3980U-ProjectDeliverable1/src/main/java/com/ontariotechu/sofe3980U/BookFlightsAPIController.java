package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontariotechu.sofe3980U.Classes.Flight;
//import com.ontariotechu.sofe3980U.Classes.FlightService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class BookFlightsAPIController {

	@GetMapping("/Bookdirect-api")
	public String showBookDirectForm() {
		return "BookingInterface";
	}

	@PostMapping("/Bookdirect-api")
	public String Bookdirectapi(
			@RequestParam(name = "FromAirport", required = true, defaultValue = "") String FromAirport,
			@RequestParam(name = "DestinationAirport", required = true, defaultValue = "") String DestinationAirport) {
		String Flight = FromAirport + DestinationAirport;
		return "Direct flight booked " + Flight;

		// test ex:
		// http://localhost:8080/Bookdirect?FromAirport=LAX&DestinationAirport=TorontoPearson&FullName=JaneDoe:
		// LAXTorontoPearsonJaneDoe

	}

	@PostMapping("/Bookindirect-api")
	public String Bookindirectapi(
			@RequestParam(name = "FromAirport", required = true, defaultValue = "") String FromAirport,
			@RequestParam(name = "DestinationAirport", required = true, defaultValue = "") String DestinationAirport) {
		return "In-Direct flight not booked, In-Direct flight aren't unavailable";

		// test ex:
		// http://localhost:8080/Bookindirect?FromAirport=LAX&DestinationAirport=TorontoPearson&FullName=JaneDoe:
		// LAXTorontoPearsonJaneDoe

	}
}
