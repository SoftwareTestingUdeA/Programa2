package com.udea.testing.program1.statisticsServiceConsumer.subscribers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.testing.program1.statisticsServiceConsumer.model.Node;
import com.udea.testing.program1.statisticsServiceConsumer.model.NumberSet;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.1
 */
@Component
public class StdDeviationResultSubscriber implements MessageListener {

    @Override
    public void onMessage(Message message) {
        ObjectMapper objectMapper = new ObjectMapper();
        NumberSet numberSet = null;
        try {
            numberSet = objectMapper.readValue(message.getBody(), NumberSet.class);

            System.out.println("Conjunto: " + numberSet.getSet().toString() +
                    "\nMedia: " + numberSet.getMean().toString() +
                    "\nDesviación Estándar: " + numberSet.getStdDeviation());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
