package com.docker.application.dockerinttoroman.controller;

import com.docker.application.dockerinttoroman.entity.MultithreadedIntegerToRoman;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IntegerToRomanController.class)
public class MultithreadedIntegerToRomanControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void validInput() throws  Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/romannumeral").param("min","1").param("max","2");
        mockMvc.perform(request)
               .andExpect(MockMvcResultMatchers.content().json("{\"conversions\":[{\"input\":\"1\",\"output\":\"I\"},{\"input\":\"2\",\"output\":\"II\"}]}"));
    }

    @Test
    void invalidInput() throws  Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/romannumeral").param("min","3").param("max","1");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string("Min number is greater than or equal to Max number"));
    }

    @Test
    void outOfRangeInputBelowMinimumValue() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/romannumeral").param("min","0").param("max","4000");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string("Invalid Input Range"));
    }

    @Test
    void maxLessThanMin() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/romannumeral").param("min","5").param("max","1");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string("Min number is greater than or equal to Max number"));
    }
}
