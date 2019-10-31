package fr.ort.m1.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartSalutation {
	

private static ApplicationContext context;
	
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("app-context.xml");
		Salutation salut = (Salutation) context.getBean("salutation");
		String msg = salut.saluerQqn("Théo");
		System.out.println(msg);
	}
	
}
