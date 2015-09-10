package com.bigledger.emp_to_db.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.bigledger.emp_to_db.*"}) //http://stackoverflow.com/questions/4787719/spring-console-application-configured-using-annotations
public class MainAppConfig implements ApplicationContextAware {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private ApplicationContext applicationContext;

	/**
	 * 
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}
