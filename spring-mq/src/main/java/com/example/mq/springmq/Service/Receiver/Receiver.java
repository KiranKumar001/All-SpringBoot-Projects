package com.example.mq.springmq.Service.Receiver;

import com.example.mq.springmq.Service.MqConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    @Autowired
    JmsTemplate jsmJmsTemplateReceiver;

    public String receiveMsgFromMQ() {
        try{
            return jsmJmsTemplateReceiver.receiveAndConvert(MqConfig.getMQ()).toString();
        }catch(JmsException ex){
            ex.printStackTrace();
            return "FAILED receiving message!!!";
        }
    }


}
