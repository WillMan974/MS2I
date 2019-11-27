package fr.ort.m1.spring.metier;

import java.util.List;

import fr.ort.m1.spring.banque.bdd.entities.Client;
import fr.ort.m1.spring.banque.bdd.entities.Compte;
import fr.ort.m1.spring.banque.bdd.util.BanqueException;

public interface BanqueService {
	
	//Authentification
	public abstract Client authentifier(String identifiant, String motDePasse) throws BanqueException;	
	
	//Mes comptes
	public abstract List<Compte> mesComptes(long idClient) throws BanqueException;
	
	//Virement
	public abstract void virement(long numCompteADebiter, long numCompteACrediter, double montant) throws BanqueException;
	

}
