package com.udea.testing.program1.statisticsAPI.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.testing.program1.statisticsAPI.model.NumberSet;
import com.udea.testing.program1.statisticsAPI.rabbitconf.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.1
 */
@RestController
@RequestMapping("/{uuid}")
public class StatisticsApiController {

    Publisher publisher = new Publisher();

    @RequestMapping(method = RequestMethod.POST, value = "/mean")
    public ResponseEntity<NumberSet> createMeanRequest(@RequestBody NumberSet numberSet) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            publisher.publishMessageAsync("udea.testing.calculate", "mean", mapper.writeValueAsString(numberSet));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<NumberSet>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/stddeviation")
    public ResponseEntity<NumberSet> createStdDeviationRequest(@RequestBody NumberSet numberSet) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            publisher.publishMessageAsync("udea.testing.calculate", "stddeviation", mapper.writeValueAsString(numberSet));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<NumberSet>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getRequest() {
        return "OKOKOK";
    }
}
