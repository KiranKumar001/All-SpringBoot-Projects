package com.example.mq.springmq.controller;

import com.example.mq.springmq.Service.Receiver.Receiver;
import com.example.mq.springmq.Service.Sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MqController {

    @Autowired
    Sender sender;

    @Autowired
    Receiver receiver;

    @PutMapping(path = "/put/{msg}")
    public String sendMsg(@PathVariable(value = "msg") String msg) {

        return sender.sendMsgToMQ(msg);

    }

    @GetMapping(path = "/get")
    public String receiveMsg() {

        return receiver.receiveMsgFromMQ();

    }

}
