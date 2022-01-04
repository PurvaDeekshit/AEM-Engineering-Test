package com.docker.application.dockerinttoroman.entity;

import com.docker.application.dockerinttoroman.service.IntegerToRomanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntegerToRoman {

    public Integer number;
    Logger logger = LoggerFactory.getLogger(IntegerToRomanService.class);

    //parse input and convert to Integer
    public Integer parseInput(String query) {
        try {
            number = Integer.parseInt(query);
        } catch(Exception e){
            logger.error("Exception occurred while converting to Integer : " + e);
            return null;
        }
        return number;
    }

    //check if input is in valid range
    public Boolean validateInputRange(Integer number) {
        if (number < 1 || number >= 4000) {
            logger.error("Input provided : " + number + " is out of range");
            return false;
        }
        return true;
    }

    //convert integer to roman numeral
    public String getRoman(Integer number) {
        Integer[] integerValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder result = new StringBuilder();

        for (Integer i = integerValues.length-1; i >=0 && number > 0; i--) {
            while (number >= integerValues[i]) {
                number -= integerValues[i];
                result.append(romanSymbols[i]);
            }
        }
        return result.toString();
    }
}
