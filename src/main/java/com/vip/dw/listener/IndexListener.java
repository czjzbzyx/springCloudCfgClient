package com.vip.dw.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
    public class IndexListener implements ServletContextListener {
	
	

        @Override
        public void contextInitialized(ServletContextEvent servletContextEvent) {
            System.out.println("IndexListener contextInitialized");
        }
        
        

        @Override
        public void contextDestroyed(ServletContextEvent servletContextEvent) {
            System.out.println("IndexListener contextDestroyed");
        }
    }