package fr.ort.m1.exec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.formation.m2.spring.banque.bdd.dao.ClientDAO;
import fr.formation.m2.spring.banque.bdd.dao.CompteDAO;
import fr.formation.m2.spring.banque.bdd.entities.Client;
import fr.formation.m2.spring.banque.bdd.entities.Compte;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;

public class Start {
	private static ApplicationContext contexte;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		contexte = new ClassPathXmlApplicationContext("bdd-context.xml");
		Client c1 = new Client();
		c1.setNom("Dulac");
		c1.setPrenom("André");
		c1.setAdresse("Place de la Trinité");
		c1.setCodepostal("31000");
		c1.setVille("Toulouse");
		c1.setMotdepasse("1234");
		ClientDAO c = (ClientDAO) contexte.getBean("clientDAO");
		try {
			c.ajouterClient(c1);
		} catch (BanqueException e) {
			System.out.println("erreur création du client");
			e.printStackTrace();
		}
		Compte cpt1 = new Compte();
		cpt1.setClient(c1);
		cpt1.setNumero(15);
		cpt1.setSolde(999);
		CompteDAO cpt = (CompteDAO) contexte.getBean("compteDAO");
		try {
			cpt.ajouterCompte(cpt1);
		} catch (BanqueException e) {
			System.out.println("erreur création de compte");
			e.printStackTrace();
		}
	}

}
