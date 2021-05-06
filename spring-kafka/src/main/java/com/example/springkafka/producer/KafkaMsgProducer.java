package com.example.springkafka.producer;

import com.example.springkafka.data.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaMsgProducer {

    String topicName="employee-kafka-topic";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMsgToTopic(Employee employee) {

        log.debug("Message sent to topic is: "+employee.toString());
        this.kafkaTemplate.send(topicName, employee);

    }
}
