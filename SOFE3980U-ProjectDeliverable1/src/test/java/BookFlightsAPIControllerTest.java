package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BookFlightsAPIController.class)
public class BookFlightsAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void Bookdirect() throws Exception {
        this.mvc.perform(get("/Bookdirect").param("FromAirport","LAX").param("DestinationAirport","TorontoPearson").param("DepartureTime","02-12-2024").param("ArriveTime","02-12-2024")
        .param("Passengers","1").param("FullName","Jane Doe"))//.andDo(print())
       //this.mvc.perform(get("/Bookdirect").param("FromAirport","LAX").param("DestinationAirport","TorontoPearson"))
      
            .andExpect(status().isOk())
            .andExpect(content().string("Direct flight booked LAXTorontoPearson02-12-202402-12-20241Jane Doe"));
    //.andExpect(content().string("LAXTorontoPearson"));
    }

    @Test
    public void Bookmultistop() throws Exception {
        this.mvc.perform(get("/Bookmultistop").param("FromAirport","LAX").param("DestinationAirport","TorontoPearson").param("DepartureTime","02-12-2024").param("ArriveTime","02-12-2024")
        .param("Stops","JFK").param("Passengers","1").param("FullName","Jane Doe"))//.andDo(print())
       //this.mvc.perform(get("/Bookmultistop").param("FromAirport","LAX").param("DestinationAirport","TorontoPearson"))
      
        .andExpect(status().isOk())
        .andExpect(content().string("Multistop flight booked LAXTorontoPearson02-12-202402-12-2024JFK1Jane Doe"));
    //.andExpect(content().string("LAXTorontoPearson"));
    }

    @Test
    public void Bookoneway() throws Exception {
        this.mvc.perform(get("/Bookoneway").param("FromAirport","LAX").param("DestinationAirport","TorontoPearson").param("DepartureTime","02-12-2024").param("ArriveTime","02-12-2024")
        .param("Passengers","1").param("FullName","Jane Doe"))//.andDo(print())
       //this.mvc.perform(get("/Bookmultistop").param("FromAirport","LAX").param("DestinationAirport","TorontoPearson"))
        .andExpect(status().isOk())
        .andExpect(content().string("Oneway flight booked LAXTorontoPearson02-12-202402-12-20241Jane Doe"));
    //.andExpect(content().string("LAXTorontoPearson"));
    }

    @Test
    public void BookRoundTrip() throws Exception {
        this.mvc.perform(get("/BookRoundTrip").param("FromAirport","LAX").param("DestinationAirport","TorontoPearson").param("DepartureTime","02-12-2024").param("ArriveTime","02-12-2024")
        .param("ReturnFromAirport","TorontoPearson").param("ReturnDestinationAirport","LAX").param("ReturnDepartureTime","2-18-2024").param("ReturnArriveTime","2-19-2024").param("Passengers","1").param("FullName","Jane Doe"))//.andDo(print())
       //this.mvc.perform(get("/Bookmultistop").param("FromAirport","LAX").param("DestinationAirport","TorontoPearson"))
        .andExpect(status().isOk())
        .andExpect(content().string("Roundtrip flight booked LAXTorontoPearson02-12-202402-12-2024TorontoPearsonLAX2-18-20242-19-20241Jane Doe"));
    //.andExpect(content().string("LAXTorontoPearson"));
    }



    
}