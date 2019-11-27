package fr.ort.m1.spring.banque.bdd.dao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.ort.m1.spring.banque.bdd.entities.Client;
import fr.ort.m1.spring.banque.bdd.util.*;

public interface ClientDAO {

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BanqueException.class)
	public abstract void ajouterClient (Client client) throws BanqueException;

	@Transactional(propagation=Propagation.REQUIRED)
	public abstract Client rechercherClientParId (Long id) throws BanqueException;

	@Transactional(propagation=Propagation.REQUIRED)
	public abstract List<Client> rechercherTousLesClients() throws BanqueException;
	
	@Transactional(propagation=Propagation.REQUIRED , rollbackFor=BanqueException.class)
	public abstract void modifierClient(Client client) throws BanqueException;
}
