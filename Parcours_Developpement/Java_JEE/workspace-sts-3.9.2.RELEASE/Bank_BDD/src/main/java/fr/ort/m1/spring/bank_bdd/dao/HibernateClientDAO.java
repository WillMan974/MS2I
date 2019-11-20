package fr.ort.m1.spring.bank_bdd.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import fr.ort.m1.spring.bank_bdd.entities.Client;
import fr.ort.m1.spring.bank_bdd.util.BankException;

public class HibernateClientDAO implements ClientDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addClient(Client client) throws BankException {
		try {
			sessionFactory.getCurrentSession().persist(client);		
			
		} catch (HibernateException hbe) {
			//hbe.printStackTrace();
			throw new BankException("error to add client");
		}
	}

	public Client searchClientById(Long id) throws BankException {
		try {
			return (Client) sessionFactory.getCurrentSession().get(Client.class, id);		
		} catch (HibernateException hbe) {
			//hbe.printStackTrace();
			throw new BankException("error to add client");
		}
	}

	public List<Client> searchAllClients() throws BankException {
		try {
			String hql = "from Client as c";
			return sessionFactory.getCurrentSession().createQuery(hql).list();	
		} catch (HibernateException hbe) {
			//hbe.printStackTrace();
			throw new BankException("error to add client");
		}
	}

}
