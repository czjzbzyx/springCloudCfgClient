package com.vip.dw.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = { "com.vip.dw.*" })
@ServletComponentScan(value = { "com.vip.dw.*" })
@EnableDiscoveryClient
public class Starter {

	public static void main(String[] args) {

		
		System.out.println(Math.abs("test-consumer-group3".hashCode()) % 50);
	
		SpringApplication.run(Starter.class, args);

	}

}
