package com.example.jms.jms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.adapter.JmsResponse;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;


@Component
public class JmsReplyConsumer {

    @Value("${jms.activemq.queue.respmsg}")
    String msgQueue;



    @JmsListener(destination = "${jms.activemq.queue.listen}", containerFactory="jsaFactory")
    public JmsResponse<Message<String>>  receive(String message, @Header("message") String msg){
        System.out.println("incomimg");

        System.out.println("incomimg msg :::::"+msg+message);
        String sendToQueue = "";


            sendToQueue = msgQueue;

            Message<String> response = MessageBuilder
                .withPayload(message)
                .setHeader("type", "test")
                .build();
        return JmsResponse.forQueue(response, sendToQueue);


    }
}
