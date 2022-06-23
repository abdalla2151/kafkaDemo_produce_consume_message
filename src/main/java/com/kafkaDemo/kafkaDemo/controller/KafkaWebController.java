package com.kafkaDemo.kafkaDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaDemo.kafkaDemo.service.IKafkaWebService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaWebController {
	
	
	 
	 
	@Autowired
	IKafkaWebService kafkaSender;

	@GetMapping(value = "/producer")
//	public String producer(@RequestParam("message") String message) {  
	public String producer( @RequestBody  String message) { 
		kafkaSender.send(message);

		return "Message sent to the Kafka Topic topic1 Successfully";
	}

}
