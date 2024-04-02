package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
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
@WebMvcTest(BookFlightsInterfaceController.class)
public class BookFlightsInterfaceControllerTest {

    @Autowired
    private MockMvc mvc;
   


    @Test
    public void whenFullNameProvided_thenCorrectModelAndView() throws Exception {
        this.mvc.perform(get("/")
                .param("FullName", "Jane Doe"))
                .andExpect(status().isOk())
                .andExpect(view().name("BookingInterface"))
                .andExpect(model().attributeExists("FullName"))
                .andExpect(model().attribute("FullName", "Jane Doe"));
    }
    // Test without "FullName" parameter
    @Test
    public void whenFullNameNotProvided_thenDefaultModelAndView() throws Exception {
        this.mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("BookingInterface"))
                .andExpect(model().attributeExists("FullName"))
                .andExpect(model().attribute("FullName", ""));
    }

    
    @Test
    public void getbookingview() throws Exception {
        this.mvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(view().name("BookingInterface"));
    }

    @Test
    public void getavailableflightsview() throws Exception {
        this.mvc.perform(get("/bookFlight"))
            .andExpect(status().isOk())
            .andExpect(view().name("Availableflights"));
    }
}

