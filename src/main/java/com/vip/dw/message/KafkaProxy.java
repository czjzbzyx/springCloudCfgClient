package com.vip.dw.message;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaProxy {

	private final KafkaTemplate<String, String> kafkaTemplate;
	
	
	

	@Autowired
	public KafkaProxy(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
		
		this.kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {

			@Override
			public boolean isInterestedInSuccess() {
				
				return true;
			}

			@Override
			public void onError(String topic, Integer partition, String key, String value,
					Exception exception) {
				
				
			}

			@Override
			public void onSuccess(String topic, Integer partition, String key, String value,
					RecordMetadata recordMetadata) {
				
				System.out.println(value+" send out");
			}
			
			
		});
	}
	
	


	
	
	public void sendMessage(String message,Integer partion){
		
		kafkaTemplate.send("lizi2",partion,message);
	}
}