package com.udea.testing.program1.statisticsAPI.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.testing.program1.statisticsAPI.model.NumberSet;
import com.udea.testing.program1.statisticsAPI.model.StatisticsRepository;
import com.udea.testing.program1.statisticsAPI.rabbitconf.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.1
 */
@RestController
@RequestMapping("/")
public class StatisticsApiController {

    @Autowired
    StatisticsRepository statisticsRepository;
    Publisher publisher = new Publisher();

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/linearreg")
    public ResponseEntity<NumberSet> createStdDeviationRequest(@RequestBody NumberSet numberSet) {
        ObjectMapper mapper = new ObjectMapper();
        numberSet.setId(UUID.randomUUID().toString());
        try {
            publisher.publishMessageAsync("udea.testing.calculate", "linear", mapper.writeValueAsString(numberSet));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<NumberSet>(HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getRequest() {
        return new ResponseEntity<>(statisticsRepository.findAll(), HttpStatus.OK);
    }
}
