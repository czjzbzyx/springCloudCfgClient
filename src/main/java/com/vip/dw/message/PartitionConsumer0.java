package com.vip.dw.message;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

//@Component
public class PartitionConsumer0 {

    @KafkaListener(id="pconsumer0",topicPartitions={@TopicPartition(topic="lizi2",partitions={"0"})})
	
    public void processMessage(String content) {
    	
      System.out.println("---pconsumer(0)--->"+content);
    }

}