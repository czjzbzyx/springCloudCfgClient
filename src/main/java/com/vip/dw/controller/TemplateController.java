/**
 * 
 */
package com.vip.dw.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fang08.li
 *
 */
@Controller
public class TemplateController {
	
	
	 @RequestMapping("/helloHtml")
	    public String helloHtml(Map<String,Object> map){

	       map.put("hello","from TemplateController.helloHtml");
	       return "hello";
	    }
}
