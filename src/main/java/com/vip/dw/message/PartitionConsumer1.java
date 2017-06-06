package com.vip.dw.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.ConsumerFactory;

//@Component
public class PartitionConsumer1 {
	
	
	
	@Autowired
	private ConsumerFactory<Object,Object> consumerFactory;

    @KafkaListener(id="pconsumer1",topicPartitions={@TopicPartition(topic="lizi2",partitions={"1"})})
	
    public void processMessage(String content) {
    	
      System.out.println("---pconsumer(1)--->"+content);
      
      System.out.println(consumerFactory.getClass());
    }

}