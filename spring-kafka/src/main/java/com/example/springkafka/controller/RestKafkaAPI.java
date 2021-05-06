package com.example.springkafka.controller;

import com.example.springkafka.data.Employee;
import com.example.springkafka.producer.KafkaMsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RestKafkaAPI {

    @Autowired
    KafkaMsgProducer kafkaMsgProducer;

    @PostMapping(path = "/post")
    public void publishMsgToTopic(@RequestBody Employee employee) {

        kafkaMsgProducer.sendMsgToTopic(employee);

    }
}
