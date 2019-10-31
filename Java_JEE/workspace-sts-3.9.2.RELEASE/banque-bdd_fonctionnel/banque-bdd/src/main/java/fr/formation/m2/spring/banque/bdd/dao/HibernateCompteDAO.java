package fr.formation.m2.spring.banque.bdd.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import fr.formation.m2.spring.banque.bdd.entities.Client;
import fr.formation.m2.spring.banque.bdd.entities.Compte;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;

public class HibernateCompteDAO implements CompteDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//@Override
	public void ajouterCompte(Compte compte) throws BanqueException {
		try {
			sessionFactory.getCurrentSession().persist(compte);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new BanqueException("Erreur d'ajout du compte");
		}
	}
	//@Override
	public Compte rechercherCompteParNumero(Long numero) throws BanqueException {
		try {
			return (Compte) sessionFactory.getCurrentSession().load(Compte.class, new Long(numero));
		} catch (HibernateException e) {
			throw new BanqueException("Erreur de recherche du compte");
		}
	}
	//@Override
	public List<Compte> rechercherComptesClient(Client client) throws BanqueException {
		try {
			String sql = "from compte as c where c.client=?";
			return sessionFactory.getCurrentSession().createQuery(sql).setEntity(1, client).list();
		} catch (HibernateException e) {
			throw new BanqueException("Erreur de recherche des comptes");
		}
	}
	//@Override
	public void modifierCompte(Compte compte) throws BanqueException {
		try {
			sessionFactory.getCurrentSession().merge(compte);
		} catch (HibernateException e) {
			throw new BanqueException("Erreur de modification du compte");
		}
	}
}
