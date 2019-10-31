package fr.ort.m1.spring.bank_bdd.dao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.ort.m1.spring.bank_bdd.entities.Client;
import fr.ort.m1.spring.bank_bdd.util.BankException;


public interface ClientDAO {
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BankException.class)
	public abstract void addClient(Client client) throws BankException;
	
	@Transactional(propagation=Propagation.MANDATORY)
	public abstract Client searchClientById(Long id) throws BankException;
	
	@Transactional(propagation=Propagation.MANDATORY)
	public abstract List<Client> searchAllClients() throws BankException;
	
}
