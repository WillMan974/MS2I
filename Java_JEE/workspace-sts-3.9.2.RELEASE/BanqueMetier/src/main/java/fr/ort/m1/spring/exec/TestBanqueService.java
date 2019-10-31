package fr.ort.m1.spring.exec;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.formation.m2.spring.banque.bdd.entities.Client;
import fr.formation.m2.spring.banque.bdd.entities.Compte;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;
import fr.ort.m1.spring.metier.BanqueService;

public class TestBanqueService {
	
	private static ApplicationContext contexte;
	
	public static void main(String[] args) throws BanqueException  {
		
		contexte = new ClassPathXmlApplicationContext("metier-contexte.xml");
		BanqueService bs = (BanqueService) contexte.getBean("banqueService");
		
		List<Compte> comptes = null;
		
		try {
			Client c1 = bs.authentifier("1", "1234");
			comptes = bs.mesComptes(c1.getId());
			
			long compteADebiter = comptes.get(0).getNumero();
			long compteACrediter = comptes.get(1).getNumero();
			
			bs.virement(compteADebiter, compteACrediter, 500);
			
		} catch (BanqueException e) {
			// TODO: handle exception
			
					}
	}

}
