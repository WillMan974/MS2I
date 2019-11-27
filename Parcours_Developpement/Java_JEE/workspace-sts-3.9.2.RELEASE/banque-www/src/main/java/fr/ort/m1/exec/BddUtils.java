package fr.ort.m1.exec;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.ort.m1.spring.banque.bdd.dao.ClientDAO;
import fr.ort.m1.spring.banque.bdd.dao.CompteDAO;
import fr.ort.m1.spring.banque.bdd.entities.Client;
import fr.ort.m1.spring.banque.bdd.entities.Compte;
import fr.ort.m1.spring.banque.bdd.util.BanqueException;


public final class BddUtils {
	private static ApplicationContext contexte = new ClassPathXmlApplicationContext("bdd-context.xml");
	private static final Logger logger = LoggerFactory.getLogger(BddUtils.class);
	
	public static HashMap<String,List<Compte>> getAllCustomersAccounts() throws BanqueException{
		CompteDAO account = (CompteDAO) contexte.getBean("compteDAO");
				
		HashMap<String, List<Compte>> finalList = new HashMap<String, List<Compte>>();		
		List<Client> listClients = getCustomersList();
		
		//DEBUG
		//logger.info("WILLTEST");	
		//logger.info(listClients.get(0).lightToString());
		
		for (Client client : listClients) {
			finalList.put(client.lightToString(), account.rechercherComptesClient(client));
		}		
		return finalList;
	}
	
	
	public static List<Client> getCustomersList() throws BanqueException{
		ClientDAO customer = (ClientDAO) contexte.getBean("clientDAO");
		return customer.rechercherTousLesClients();
	}
	
	public static void addNewCustomer(Client newClient) throws BanqueException {
		ClientDAO customer = (ClientDAO) contexte.getBean("clientDAO");
		customer.ajouterClient(newClient);
	}

}
