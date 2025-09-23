package com.sample;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//@ComponentScan("package_name")
public class AppConfig {
	
	@Bean
	@Primary
	public IBank getBankClass1()
	{
		return new CITI();
	}
	
	@Bean
	public IBank getBankClass2()
	{
		return new CITI();
	}
	
	
	
}
