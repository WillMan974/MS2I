package fr.ort.m1.spring.aspects;

import java.util.Iterator;

import org.aspectj.lang.JoinPoint;

public class Logging {
	
	public void beforeMethod(JoinPoint jp) {
		String methodName = jp.getSignature().toString();
		Object [] args = jp.getArgs();
		StringBuilder builder = new StringBuilder();
		builder.append("Method : ");
		builder.append(methodName);
		builder.append(" invoqué avec les paramètres : ");
		
		for (Object o : args) {
			builder.append(o);
			builder.append(" - ");
		}
		System.out.println(builder);
		
	}
	
	public void afterMethod(JoinPoint jp, Object result) {
		String methodName = jp.getSignature().toShortString();
		System.out.println("Méthode " + methodName + " a produit : " + result.toString());
	}
}
