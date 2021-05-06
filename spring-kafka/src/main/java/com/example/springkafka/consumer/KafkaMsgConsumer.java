package com.example.springkafka.consumer;

import com.example.springkafka.data.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaMsgConsumer {

    @KafkaListener(topics = "employee-kafka-topic", groupId = "emp")
    public void consumeMsgFromTopic(Employee employee) {

        log.debug("Msg retrieved from consumer is: "+employee.toString());

    }
}
