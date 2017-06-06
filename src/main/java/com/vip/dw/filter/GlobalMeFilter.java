/**
 * 
 */
package com.vip.dw.filter;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author fang08.li
 *
 */

@Configurable
public class GlobalMeFilter {
	
	
	@Bean
	public FilterRegistrationBean encodeFilter(){
		
		
		CharacterEncodingFilter characterEncodingFilter=new CharacterEncodingFilter();
		
		
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		
		filterRegistrationBean.setFilter(characterEncodingFilter);
		
		filterRegistrationBean.addUrlPatterns("/*");
		
		filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		
		return filterRegistrationBean;
		
	}

	
	
}
