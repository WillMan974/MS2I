package fr.ort.m1.spring.banque.bdd.exec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.ort.m1.spring.banque.bdd.dao.ClientDAO;
import fr.ort.m1.spring.banque.bdd.dao.CompteDAO;
import fr.ort.m1.spring.banque.bdd.entities.Client;
import fr.ort.m1.spring.banque.bdd.entities.Compte;
import fr.ort.m1.spring.banque.bdd.util.BanqueException;

public class Start {
	private static ApplicationContext contexte;
	
	public static void main(String[] args) {
		
		contexte = new ClassPathXmlApplicationContext("bdd-context.xml");
		Client c1 = new Client();
		c1.setNom("Dubois");
		c1.setPrenom("Pierre");
		c1.setAdresse("rue de Rémusat");
		c1.setCodePostal("31000");
		c1.setVille("Toulouse");
		c1.setMotdepasse("1234");
		
		Client c2 = new Client();
		c2.setNom("Durand");
		c2.setPrenom("Paul");
		c2.setAdresse("rue des lois");
		c2.setCodePostal("31000");
		c2.setVille("Toulouse");
		c2.setMotdepasse("abcd");
		
		ClientDAO c = (ClientDAO) contexte.getBean("clientDAO");
		try {
			c.ajouterClient(c1);
			c.ajouterClient(c2);
		} catch (BanqueException e) {
			System.out.println("erreur création du client");
			e.printStackTrace();
		}
		Compte cpt1 = new Compte();
		cpt1.setClient(c1);
		cpt1.setNumero(13);
		cpt1.setSolde(999);
		Compte cpt2 = new Compte();
		cpt2.setClient(c1);
		cpt2.setNumero(14);
		cpt2.setSolde(1000);
		
		CompteDAO cpt = (CompteDAO) contexte.getBean("compteDAO");
		try {
			cpt.ajouterCompte(cpt1);
			cpt.ajouterCompte(cpt2);
		} catch (BanqueException e) {
			System.out.println("erreur creation de compte");
			e.printStackTrace();
		}
		
		

	}

}
