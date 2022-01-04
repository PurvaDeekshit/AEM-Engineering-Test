package com.docker.application.dockerinttoroman.entity;

import com.docker.application.dockerinttoroman.service.IntegerToRomanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.concurrent.*;

public class MultithreadedIntegerToRoman {

    private Integer min;
    private Integer max;
    private static ExecutorService service = Executors.newFixedThreadPool(10);

    private static Logger logger = LoggerFactory.getLogger(MultithreadedIntegerToRoman.class);

    private static ConcurrentSkipListMap<Integer, Future<String>> integerFutureMapping = new ConcurrentSkipListMap<>();
    private static ConcurrentSkipListMap<Integer, String> integerRomanMapping = new ConcurrentSkipListMap<>();
    private static final String CONVERSION_ERROR = "Error while converting integer to roman";

    public MultithreadedIntegerToRoman (Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    public static ResponseEntity executeTask(Integer min, Integer max) {

        //submit task for each number conversion to threadpool executor service
        //store future object in hashmap
        for (int num=min; num<=max; num++) {
            logger.info("Submitting task for num: " + num);
            Future<String> future = service.submit(new MutltithreadedIntegerToRomanCallable(num));
            integerFutureMapping.put(num, future);
        }

        //iterate over future object and get result for each conversion
        for (Integer key: integerFutureMapping.keySet()) {
            String result = null;
            try {
                result = integerFutureMapping.get(key).get();
                integerRomanMapping.put(key, result);
            } catch (InterruptedException e) {
                logger.info("InterruptedException occurred : " + e);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CONVERSION_ERROR);
            } catch (ExecutionException e) {
                logger.info("ExecutionException occurred : " + e);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CONVERSION_ERROR);
            }
        }

        //prepare array of output response objects
        IntegerToRomanResponse[] conversions = new IntegerToRomanResponse[integerRomanMapping.size()];

        for (Integer key: integerRomanMapping.keySet()) {
            logger.info("Key: " + key + " Output: " + integerRomanMapping.get(key));
            conversions[key-min] = new IntegerToRomanResponse(String.valueOf(key),integerRomanMapping.get(key));
        }

        //prepare hashmap for output with key as conversion and value as array of response objects
        HashMap<String, IntegerToRomanResponse[]> output = new HashMap<>();
        output.put("conversions", conversions);
        return ResponseEntity.ok(output);
    }
}
