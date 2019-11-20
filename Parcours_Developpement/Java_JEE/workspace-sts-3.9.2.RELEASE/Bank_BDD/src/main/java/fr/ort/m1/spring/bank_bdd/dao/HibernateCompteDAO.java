package fr.ort.m1.spring.bank_bdd.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import fr.ort.m1.spring.bank_bdd.entities.Client;
import fr.ort.m1.spring.bank_bdd.entities.Compte;
import fr.ort.m1.spring.bank_bdd.util.BankException;

public class HibernateCompteDAO implements CompteDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addCompte(Compte compte) throws BankException {
		try {
			sessionFactory.getCurrentSession().persist(compte);
			
		} catch (HibernateException hbe) {
			//hbe.printStackTrace();
			throw new BankException("Compte error");
		}
	}

	public Compte searchCompteByNum(long numero) throws BankException {
		try {
			sessionFactory.getCurrentSession().get(Compte.class, numero);
			
		} catch (HibernateException hbe) {
			//hbe.printStackTrace();
			throw new BankException("Compte error");
		}		return null;
	}

	public List<Compte> searchAllComptesClient(Client client) throws BankException {
		try {
			String hql = "from Compte as c where c.client=?";
			return sessionFactory.getCurrentSession().createQuery(hql).setEntity(0, client).list();
			
		} catch (HibernateException hbe) {
			//hbe.printStackTrace();
			throw new BankException("Compte error");
		}
	}

	public void ModifyCompte(Compte compte) throws BankException {
		try {
			sessionFactory.getCurrentSession().merge(compte);
		} catch (HibernateException hbe) {
			//hbe.printStackTrace();
			throw new BankException("Compte error");
		}
	}

}
