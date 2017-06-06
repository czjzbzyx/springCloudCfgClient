package com.vip.dw.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vip.dw.message.KafkaProxy;
import com.vip.dw.model.Student;
import com.vip.dw.model.SysEnviroment;


@Controller
@RefreshScope
public class HomeController {

	@Autowired
	SysEnviroment env;
	
	
	
	@Value("${name}")
	private String name;
	
	
	  @RequestMapping("/name")
	  @ResponseBody
      public String showLuckyWord() {
        return "The name is: " + name;
      }
	  
	  
	
	
	@Autowired
	private KafkaProxy kafkaProxy;
	
	private static final AtomicLong count=new AtomicLong();
			

	
	
	@RequestMapping("/")
	public String home() {

		return "index";
	}

	@RequestMapping(value="/student",produces="application/json")
	@ResponseBody
	public Student getStudent() throws Exception {

		Student student = new Student();
		
		
//		int i=0;
//		
//		int j=1;
//		
//		int c=j/i;

		student.setId(1);

		student.setName("lizi");
		return student;
	}

	@RequestMapping(value="/getEnv")
	@ResponseBody
	public SysEnviroment getEnv() throws Exception {

		return env;
	}
	
	
	private static ObjectMapper objectMapper=new ObjectMapper();
	
	
	
	@RequestMapping(value="/sendMessage/{partiton}")
	@ResponseBody
	public String sendMessage(@PathVariable("partiton") String partition) throws Exception {
		
		
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		
		
		Student student=new Student();
		
		long incrementAndGet = count.incrementAndGet();
		
		student.setId(new Long(incrementAndGet).intValue());
		
		student.setName("lizi"+incrementAndGet);
		
		
		
		
		kafkaProxy.sendMessage(objectMapper.writeValueAsString(student),Integer.parseInt(partition));

		return "send success";
	}

}
