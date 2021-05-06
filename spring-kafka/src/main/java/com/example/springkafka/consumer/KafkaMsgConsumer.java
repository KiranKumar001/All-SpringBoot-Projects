package com.example.springkafka.consumer;

import com.example.springkafka.data.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMsgConsumer {

    @KafkaListener(topics = "employee-kafka-topic", groupId = "emp")
    public void consumeMsgFromTopic(Employee employee) {

        System.out.println("Msg retrieved from consumer is: "+employee.toString());

    }
}
