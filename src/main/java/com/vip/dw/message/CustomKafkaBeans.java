package com.vip.dw.message;

import java.util.Map;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public  class CustomKafkaBeans {

    /**
     * Customized ProducerFactory bean.
     * @param properties the kafka properties.
     * @return the bean.
     */
    @Bean
    public ProducerFactory<?, ?> kafkaProducerFactory(KafkaProperties properties) {
        Map<String, Object> producerProperties = properties.buildProducerProperties();
        
        return new DefaultKafkaProducerFactory<Object, Object>(producerProperties);
    }

    /**
     * Customized ConsumerFactory bean.
     * @param properties the kafka properties.
     * @return the bean.
     */
    @Bean
    public ConsumerFactory<?, ?> kafkaConsumerFactory(KafkaProperties properties) {
        Map<String, Object> consumerProperties = properties.buildConsumerProperties();
        consumerProperties.put("session.timeout.ms",60000);
        consumerProperties.put("heartbeat.interval.ms", 10000);
        consumerProperties.put("enable.auto.commit", true);
        consumerProperties.put("max.poll.interval.ms", 300000);
        consumerProperties.put("auto.commit.interval.ms", 5000);
        consumerProperties.put("group.id", "test-consumer-group3");
        return new DefaultKafkaConsumerFactory<Object, Object>(consumerProperties);
    }

}