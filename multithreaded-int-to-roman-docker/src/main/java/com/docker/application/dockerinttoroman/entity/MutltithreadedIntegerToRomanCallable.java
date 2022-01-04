package com.docker.application.dockerinttoroman.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class MutltithreadedIntegerToRomanCallable implements Callable<String> {

    private Integer number;

    private static IntegerToRoman multithreadedIntegerToRomanObject = new IntegerToRoman();
    private static Logger logger = LoggerFactory.getLogger(MutltithreadedIntegerToRomanCallable.class);

    public MutltithreadedIntegerToRomanCallable (Integer number) {
        this.number = number;
    }

    //convert integer to roman for each number
    //return null if fail or roman string if success
    @Override
    public String call() throws Exception {
        logger.info("For num : " + number + " Thread name: " + Thread.currentThread().getName());
        String  romanOutput = multithreadedIntegerToRomanObject.getRoman(number);
        if(romanOutput == null || romanOutput.isEmpty()){
            logger.info("Output is null or empty for number : " + number);
            return null;
        }
        return romanOutput;
    }
}
