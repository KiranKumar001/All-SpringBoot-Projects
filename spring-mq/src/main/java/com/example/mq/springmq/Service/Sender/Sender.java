package com.example.mq.springmq.Service.Sender;

import com.example.mq.springmq.Service.MqConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    @Autowired
    JmsTemplate jmsTemplate;

    public String sendMsgToMQ(String msg) {

        try {
            jmsTemplate.convertAndSend(MqConfig.getMQ(), msg);
            return "Message Sent Successfully to MQ!!!";
        } catch(JmsException ex){
            ex.printStackTrace();
            return "FAILED send message to MQ!!!";
        }

    }
}
