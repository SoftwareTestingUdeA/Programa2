package com.udea.testing.program1.statisticsServiceConsumer.subscribers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.testing.program1.statisticsServiceConsumer.model.NumberSet;
import com.udea.testing.program1.statisticsServiceConsumer.model.StatisticsRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.1
 */
@Service
public class LinearResultSubscriber implements MessageListener {

    @Autowired
    StatisticsRepository statisticsRepository;

    @Override
    public void onMessage(Message message) {

        ObjectMapper objectMapper = new ObjectMapper();
        NumberSet numberSet = null;
        try {
            numberSet = objectMapper.readValue(message.getBody(), NumberSet.class);
            statisticsRepository.save(numberSet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
