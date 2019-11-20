package fr.ort.m1.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
	
	private static ApplicationContext context;
	
	
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("app-context.xml");
		Hello bonjour = (Hello) context.getBean("hello");
		System.out.println(bonjour.sayHello("Léa"));
	}

}
