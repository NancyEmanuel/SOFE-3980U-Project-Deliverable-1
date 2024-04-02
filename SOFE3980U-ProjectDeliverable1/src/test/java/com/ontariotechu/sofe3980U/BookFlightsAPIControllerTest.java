package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ontariotechu.sofe3980U.BookFlightsAPIController;

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
    public void Bookdirectapi() throws Exception {
        this.mvc.perform(
            post("/Bookdirect-api").param("FromAirport", "LAX").param("DestinationAirport", "TorontoPearson")
        )
            .andExpect(status().isOk())
            .andExpect(content().string("Direct flight booked LAXTorontoPearson"));
        // .andDo(print())
        // this.mvc.perform(get("/Bookdirect").param("FromAirport","LAX").param("DestinationAirport","TorontoPearson"))
        // .andExpect(content().string("LAXTorontoPearson"));
    }

    
    @Test
    public void Bookindirectapi() throws Exception {
        this.mvc.perform(
            post("/Bookindirect-api").param("FromAirport", "LAX").param("DestinationAirport", "TorontoPearson")
        )
            .andExpect(status().isOk())
            .andExpect(content().string("In-Direct flight not booked, In-Direct flight aren't unavailable"));
        // .andDo(print())
        // this.mvc.perform(get("/Bookdirect").param("FromAirport","LAX").param("DestinationAirport","TorontoPearson"))
        // .andExpect(content().string("LAXTorontoPearson"));
    }
}
