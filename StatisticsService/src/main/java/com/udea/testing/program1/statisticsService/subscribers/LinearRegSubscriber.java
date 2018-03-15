package com.udea.testing.program1.statisticsService.subscribers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.testing.program1.statisticsService.model.NumberLinkedList;
import com.udea.testing.program1.statisticsService.model.NumberSet;
import com.udea.testing.program1.statisticsService.model.StatisticsRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.1
 */
@Service
public class LinearRegSubscriber implements MessageListener {

    @Autowired
    StatisticsRepository statisticsRepository;

    @Override
    public void onMessage(Message message) {
        ObjectMapper objectMapper = new ObjectMapper();
        NumberSet numberSet;
        try {
            numberSet = objectMapper.readValue(message.getBody(), NumberSet.class);
            numberSet.setList(new NumberLinkedList(numberSet.getSetX(), numberSet.getSetY()));
            numberSet.calculateCorrelation();
            numberSet.setList(null);
            statisticsRepository.save(numberSet);
            //publisher.publishMessageAsync("udea.testing.result", "linear", objectMapper.writeValueAsString(numberSet));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
