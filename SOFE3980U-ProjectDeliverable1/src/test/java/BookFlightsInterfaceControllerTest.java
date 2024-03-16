package com.ontariotechu.sofe3980U;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(BookFlightsInterfaceController.class)
public class BookFlightsInterfaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Test with "FullName" parameter
    @Test
    void whenFullNameProvided_thenCorrectModelAndView() throws Exception {
        mockMvc.perform(get("/")
                .param("FullName", "Jane Doe"))
                .andExpect(status().isOk())
                .andExpect(view().name("Main_Booking_Interface"))
                .andExpect(model().attributeExists("FullName"))
                .andExpect(model().attribute("FullName", "Jane Doe"));
    }

    // Test without "FullName" parameter
    @Test
    void whenFullNameNotProvided_thenDefaultModelAndView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("Main_Booking_Interface"))
                .andExpect(model().attributeExists("FullName"))
                .andExpect(model().attribute("FullName", ""));
    }
}
