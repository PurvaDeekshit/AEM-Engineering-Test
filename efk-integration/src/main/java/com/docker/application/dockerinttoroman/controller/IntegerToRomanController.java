package com.docker.application.dockerinttoroman.controller;

import com.docker.application.dockerinttoroman.service.IntegerToRomanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/romannumeral")
public class IntegerToRomanController {

    Logger logger = LoggerFactory.getLogger(IntegerToRomanController.class);

    @Operation(summary = "API to convert integer to roman numeral")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200",
                description = "Converted integer to roman numeral",
                content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",
                description = "Conversion of integer to roman numeral failed")
    })
    @GetMapping
    public ResponseEntity intToRoman (@RequestParam String query) {

        UUID uuid = UUID.randomUUID();
        logger.info("Received new request : " + uuid);
        logger.info("Input query param : " + query);
        return IntegerToRomanService.convertToRoman(query);
    }
}
