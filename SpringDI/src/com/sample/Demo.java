package com.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	private static ApplicationContext context;

	public static void main(String[] args) {
		
		//No bean is used just interface used
//		CITI obj1= new CITI();//Tightly coupled with CITI class
//		IBank obj1 = new CITI();//not tightly coupled with CITI class but depend on Ibank interface but 
//		System.out.println(obj1.GetROI());
//		
//		HDFC obj2= new HDFC();
//		IBank obj2 = new HDFC();
//		System.out.println(obj2.GetROI());
		
		
		//getting bean(we use bean for getting object of a class) from xml based file
//		ApplicationContext context= new ClassPathXmlApplicationContext("Spring.xml");
		
//		context = new ClassPathXmlApplicationContext("Spring.xml");
//		IBank obj= (IBank)context.getBean("bankclass");
//		System.out.println(obj.GetROI());
		
		
		//getting bean from annoataion based method 
//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		IBank obj = context.getBean(IBank.class);
//		System.out.println(obj.GetROI());
		
		Product prod1 = new Product();
		prod1.setId(1);
		prod1.setName("apple");
		prod1.setPrice(54.87);
//		prod1.setCategory("Mobile");
		System.out.println(prod1);
		System.out.println(prod1.getId());
		System.out.println(prod1.getName());
		System.out.println(prod1.getPrice());
		System.out.println(prod1.hashCode());
		System.out.println(prod1.toString());
	}

}
