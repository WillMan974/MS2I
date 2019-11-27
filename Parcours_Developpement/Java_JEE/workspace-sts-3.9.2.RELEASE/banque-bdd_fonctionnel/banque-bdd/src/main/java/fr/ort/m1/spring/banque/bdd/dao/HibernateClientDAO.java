package fr.ort.m1.spring.banque.bdd.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import fr.ort.m1.spring.banque.bdd.entities.Client;
import fr.ort.m1.spring.banque.bdd.util.BanqueException;

public class HibernateClientDAO implements ClientDAO {
	
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//@Override
	public void ajouterClient(Client client) throws BanqueException {
		try {
			 sessionFactory.getCurrentSession().persist(client);
		 } catch (HibernateException e) {
			 e.printStackTrace();
			 throw new BanqueException("Erreur d'ajout du client");
		 }
	}

	//@Override
	public Client rechercherClientParId(Long id) throws BanqueException {
		try {
			 return (Client) sessionFactory.getCurrentSession().load(Client.class, new Long(id));
		 } catch (HibernateException e) {
			 throw new BanqueException("Erreur de recherche du client");
		 }
	}

	//@Override
	public List<Client> rechercherTousLesClients() throws BanqueException {
		try {
			String hql = "from Client as c"; 
			return  sessionFactory.getCurrentSession().createQuery(hql).list();
		 } catch (HibernateException e) {
			 throw new BanqueException("Erreur recherche des clients");
		 }
	}

}
