package fr.ort.m1.spring.bank_bdd.dao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.ort.m1.spring.bank_bdd.entities.Client;
import fr.ort.m1.spring.bank_bdd.entities.Compte;
import fr.ort.m1.spring.bank_bdd.util.BankException;

public interface CompteDAO {
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BankException.class)
	public abstract void addCompte(Compte compte) throws BankException;
	
	@Transactional(propagation=Propagation.MANDATORY)
	public abstract Compte searchCompteByNum(long numero) throws BankException;

	@Transactional(propagation=Propagation.MANDATORY)
	public abstract List<Compte> searchAllComptesClient(Client client) throws BankException;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BankException.class)
	public void ModifyCompte(Compte compte) throws BankException;
	

}
