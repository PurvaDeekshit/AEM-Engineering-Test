package com.docker.application.dockerinttoroman.service;

import com.docker.application.dockerinttoroman.controller.IntegerToRomanController;
import com.docker.application.dockerinttoroman.entity.IntegerToRoman;
import com.docker.application.dockerinttoroman.entity.IntegerToRomanResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class IntegerToRomanService {

    private static IntegerToRoman integerToRomanObject = new IntegerToRoman();
    private static Integer number;
    private static Logger logger = LoggerFactory.getLogger(IntegerToRomanService.class);

    private static final String INVALID_INPUT = "Invalid input specified";
    private static final String INVALID_RANGE = "Invalid Input Range";
    private static final String CONVERSION_ERROR_NULL = "Null received while converting integer to roman";
    private static final String CONVERSION_ERROR_EMPTY = "Empty string received while converting integer to roman";

    public static  ResponseEntity convertToRoman(String query) {

        //validate if input can be converted to integer
        number = integerToRomanObject.parseInput(query);
        if (number == null) {
            logger.error(INVALID_INPUT);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(INVALID_INPUT);
        }

        //validate if input in expected range
        Boolean validateResult = integerToRomanObject.validateInputRange(number);
        if (validateResult == false) {
            logger.error(INVALID_RANGE);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(INVALID_RANGE);
        }

        //convert to roman
        String  romanOutput = integerToRomanObject.getRoman(number);
        //check if null
        if (romanOutput == null ) {
            logger.error(CONVERSION_ERROR_NULL);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CONVERSION_ERROR_NULL);
        }
        //check if empty
        if (romanOutput.isEmpty()) {
            logger.error(CONVERSION_ERROR_EMPTY);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CONVERSION_ERROR_EMPTY);
        }

        //return output in json format
        return ResponseEntity.status(HttpStatus.OK).body(new IntegerToRomanResponse(number,romanOutput));
    }
}
