package com.docker.application.dockerinttoroman.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IntegerToRomanController.class)
public class IntegerToRomanControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void validInput() throws  Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/romannumeral").param("query","1");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.jsonPath("$.input").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.output").value("I"));
    }

    @Test
    void invalidInput() throws  Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/romannumeral").param("query","abcd");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string("Invalid input specified"));
    }

    @Test
    void outOfRangeInputBelowMinimumValue() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/romannumeral").param("query","0");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string("Invalid Input Range"));
    }

    @Test
    void outOfRangeInputAboveMaximumValue() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/romannumeral").param("query","4000");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string("Invalid Input Range"));
    }
}
