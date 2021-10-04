package com.example.springbootkafkaproducerexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class Controller {

    final
    KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "Kafka_Example" ;

    public Controller(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/publish/{message}")
    public String methodPOST(@PathVariable("message") String message) {

        kafkaTemplate.send(TOPIC, message);
        return "successfully";
    }
}
