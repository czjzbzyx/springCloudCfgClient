package com.vip.dw.message;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class GroupConsumer0 {

   // @KafkaListener(group="test",id="consumer0",topicPartitions={@TopicPartition(topic="lizi2",partitions={"0"})})
	
	@KafkaListener(group="test",id="gconsumer0",topics={"lizi2"})
    public void processMessage(String content) {
    	
      System.out.println("---gconsumer(0)--->"+content);
    }

}