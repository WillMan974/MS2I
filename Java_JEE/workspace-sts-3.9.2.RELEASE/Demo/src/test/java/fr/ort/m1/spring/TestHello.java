package fr.ort.m1.spring;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestHello {
	
	private static ApplicationContext contexte;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		contexte = new ClassPathXmlApplicationContext("app-context.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSayHello() {
		//fail("Not yet implemented");
		Hello hello = (Hello) contexte.getBean("hello");
		String msg = hello.sayHello("Will");
		
		assertEquals("Bonjour Will", msg);
		
	}
	

}
