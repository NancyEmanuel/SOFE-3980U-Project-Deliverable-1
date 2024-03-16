package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookFlightsInterfaceController  {

	@GetMapping("/")
	public String getBookingView(@RequestParam(name="FullName", required=false, defaultValue="") String FullName, Model model) {
		model.addAttribute("FullName", FullName);
		//model.addAttribute("FullName", FullName.length()>0);
        return "Main_Booking_Interface";
	}
	

}