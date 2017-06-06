/**
 * 
 */
package com.vip.dw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vip.dw.model.DevEnviroment;
import com.vip.dw.model.ProdEnviroment;
import com.vip.dw.model.SysEnviroment;

/**
 * @author fang08.li
 *
 */

@Configuration
public class EnvConfig {
	
	
	@Bean
	@Profile("dev")
	SysEnviroment getDevEnv(){
		
		return new DevEnviroment("dev");
		
	}
	
	
	
	@Bean
	@Profile("prod")
	SysEnviroment getProdEnv(){
		
		return new ProdEnviroment("prod");
		
	}

}
