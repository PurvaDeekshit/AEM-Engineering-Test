package com.docker.application.dockerinttoroman.service;

import com.docker.application.dockerinttoroman.entity.IntegerToRoman;
import com.docker.application.dockerinttoroman.entity.IntegerToRomanResponse;
import com.docker.application.dockerinttoroman.entity.MultithreadedIntegerToRoman;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MultithreadedIntegerToRomanService {
    private static IntegerToRoman integerToRomanObject = new IntegerToRoman();
    private static Integer minNumber;
    private static Integer maxNumber;
    private static Logger logger = LoggerFactory.getLogger(IntegerToRomanService.class);

    private static final String INVALID_INPUT = "Invalid input specified";
    private static final String INVALID_RANGE = "Invalid Input Range";
    private static final String MIN_GREATER_THAN_OR_EQUAL_TO_MAX = "Min number is greater than or equal to Max number";

    public static ResponseEntity convertToRoman(String min, String max) {

        //validate if min number can be converted to integer or is not null
        minNumber = integerToRomanObject.parseInput(min);
        if (minNumber == null) {
            logger.error(INVALID_INPUT);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(INVALID_INPUT);
        }

        //validate if max number can be converted to integer or is not null
        maxNumber = integerToRomanObject.parseInput(max);
        if (maxNumber == null) {
            logger.error(INVALID_INPUT);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(INVALID_INPUT);
        }

        //validate if min number in expected range
        Boolean validateResultMin = integerToRomanObject.validateInputRange(minNumber);
        if (validateResultMin == false) {
            logger.error(INVALID_RANGE);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(INVALID_RANGE);
        }

        //validate if max number in expected range
        Boolean validateResultMax = integerToRomanObject.validateInputRange(maxNumber);
        if (validateResultMax == false) {
            logger.error(INVALID_RANGE);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(INVALID_RANGE);
        }

        //validate if min is less than max
        Boolean validateMinLessThanMax = integerToRomanObject.validateMinLessThanMax(minNumber, maxNumber);
        if (validateMinLessThanMax == false) {
            logger.error(MIN_GREATER_THAN_OR_EQUAL_TO_MAX);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MIN_GREATER_THAN_OR_EQUAL_TO_MAX);
        }

        return MultithreadedIntegerToRoman.executeTask(minNumber, maxNumber);
    }
}
