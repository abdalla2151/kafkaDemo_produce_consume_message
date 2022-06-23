package com.kafkaDemo.kafkaDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaWebService implements IKafkaWebService{
	
	@Value(value = "${kafka.topic_name}")
	 private String kafkaTopic;
	
	@Value(value = "${kafka.group_id}")
    private String kafkaGroupId;

	/********* produce message ********/
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
		
	public void send(String message) {
	    
	    kafkaTemplate.send(kafkaTopic, message);
	}
	
	/********* consume message ********/
	// Annotation required to listen the
    // message from kafka server
    @KafkaListener(topics = "${kafka.topic_name}", groupId = "${kafka.group_id}")
    public void  listener (String message)
    {
        System.out.println(  "You have a new Consuming message: "   + message);
    }

}
