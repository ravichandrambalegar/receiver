package com.example.jms.jms;

import com.example.jms.model.Company;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class JmsSubcriber {

    @JmsListener(destination = "${jms.activemq.topic}")
    public void receive(Company msg){
        System.out.println("Recieved Message: " + msg);
    }
}


