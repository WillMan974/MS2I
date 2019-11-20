package fr.ort.m1.spring.bank_bdd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.ort.m1.spring.bank_bdd.dao.ClientDAO;
import fr.ort.m1.spring.bank_bdd.entities.Client;
import fr.ort.m1.spring.bank_bdd.util.BankException;

public class TestClient {
	
	private static ApplicationContext context;
	private static ClientDAO clientTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("bdd-context.xml");
		clientTest = (ClientDAO) context.getBean("clientDAO");
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
	public void testAddClient() {
		//Create a customer to inject into BDD
		Client clientToAdd = new Client();
		clientToAdd.setAdresse("21 Spring Street");
		clientToAdd.setCodePostal("31234");
		clientToAdd.setNom("Jean-Pierre");
		clientToAdd.setPrenom("Hibernator");
		clientToAdd.setVille("Java-City");
		clientToAdd.setId(1989);
		clientToAdd.setMotDePasse("J2EE*Spring_Hibernate");
		
//		try {
//			clientTest.addClient(clientToAdd);
//		} catch (BankException e) {
//			e.printStackTrace();
//		}
		
		Client result = new Client();
		try {
			result = clientTest.searchClientById(clientToAdd.getId());
		} catch (BankException e) {
			e.printStackTrace();
			}
		
		//assertEquals(clientToAdd.getId(), result);
	}

}
