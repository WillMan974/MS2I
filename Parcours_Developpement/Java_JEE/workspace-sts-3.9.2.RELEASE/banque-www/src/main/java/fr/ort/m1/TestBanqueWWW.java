package fr.ort.m1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.ort.m1.spring.banque.bdd.entities.Client;
import fr.ort.m1.spring.banque.bdd.entities.Compte;
import fr.ort.m1.spring.banque.bdd.util.BanqueException;
import fr.ort.m1.spring.metier.BanqueService;

public class TestBanqueWWW {
	
	private static ApplicationContext contexte;
	
	public static void main(String[] args) {
		contexte = new ClassPathXmlApplicationContext("metier-contexte.xml");
		BanqueService bs = (BanqueService) contexte.getBean("banqueService");
		
		List<Compte> comptes = null;
		
		try {
			Client c1 = bs.authentifier("2", "abcd");
			comptes = bs.mesComptes(c1.getId());
			
			//DEBUG TEST
//			System.out.println("Client : " + c1.getNom() + ", " + c1.getPrenom());
//			System.out.println(c1.getAdresse());
//			System.out.println(c1.getCodepostal() + " " + c1.getVille().toUpperCase());
			
			long compteADebiter = comptes.get(0).getNumero();
			long compteACrediter = comptes.get(1).getNumero();
			
			bs.virement(compteADebiter, compteACrediter, 500);
			
		} catch (BanqueException e) {
			// TODO: handle exception
			
					}

	}

}
