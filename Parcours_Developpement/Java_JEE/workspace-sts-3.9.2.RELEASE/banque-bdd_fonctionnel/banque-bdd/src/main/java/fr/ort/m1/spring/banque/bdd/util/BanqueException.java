package fr.ort.m1.spring.banque.bdd.util;

import org.hibernate.SessionFactory;

public class BanqueException extends Exception {
	

	public BanqueException() {
		// TODO Auto-generated constructor stub
	}

	public BanqueException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BanqueException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public BanqueException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BanqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
