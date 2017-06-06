package com.vip.dw.config;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


 @Configuration
public class MyConfiguration {

	//@Bean
	public HttpMessageConverters customerHttpMessageConverters() {

		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		converter.setFastJsonConfig(fastJsonConfig);

		return new HttpMessageConverters(converter);
	}
	
	
	@Bean
	public HttpMessageConverters customerHttpMessageConverters2() {
		
		
		ObjectMapper objectMapper=new ObjectMapper();
		
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		MappingJackson2HttpMessageConverter converter=new MappingJackson2HttpMessageConverter(objectMapper);

		return new HttpMessageConverters(converter);
	}

}
