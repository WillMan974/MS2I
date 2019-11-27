package fr.ort.m1.spring.metier;

import java.util.List;

import fr.ort.m1.spring.banque.bdd.dao.ClientDAO;
import fr.ort.m1.spring.banque.bdd.dao.CompteDAO;
import fr.ort.m1.spring.banque.bdd.entities.Client;
import fr.ort.m1.spring.banque.bdd.entities.Compte;
import fr.ort.m1.spring.banque.bdd.util.BanqueException;

public class BanqueServiceImpl implements BanqueService {

	private ClientDAO clientDAO;
	private CompteDAO compteDAO;
	
	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	public void setCompteDAO(CompteDAO compteDAO) {
		this.compteDAO = compteDAO;
	}
	

	public Client authentifier(String identifiant, String motDePasse) throws BanqueException {
		try {
			
			Client monClient = clientDAO.rechercherClientParId(Long.parseLong(identifiant));
			
			if (monClient != null && motDePasse != null && motDePasse.equals(monClient.getMotdepasse())) {
				return monClient;
			} else
				throw new BanqueException();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BanqueException("Erreur d'authenfification");
		}
	}

	

	public List<Compte> mesComptes(long idClient) throws BanqueException {
		 List<Compte> compteARetourner = null;
		
		try {
			
			Client monClient = clientDAO.rechercherClientParId(idClient);
			
			if (monClient != null ) {
				compteARetourner = compteDAO.rechercherComptesClient(monClient);
						}
			// lève une exception si compteARetourner est null
		} catch (Exception e) {
			e.printStackTrace();
			throw new BanqueException("Erreur lors de la récupération des comptes");
		}
		return compteARetourner;
	}
	
	
	

	public void virement(long numCompteADebiter, long numCompteACrediter, double montant) throws BanqueException {
		try {
			
			Compte monCompteADebiter = compteDAO.rechercherCompteParNumero(numCompteADebiter);
			Compte monCompteACrediter = compteDAO.rechercherCompteParNumero(numCompteACrediter);
			
			
			if (monCompteADebiter != null && monCompteACrediter != null) {
				if (!new Double(montant).equals(null)) {
					double newSoldeCompteADebiter = monCompteADebiter.getSolde() - montant;
					double newSoldeCompteACrediter = monCompteACrediter.getSolde() + montant;
					
					monCompteADebiter.setSolde(newSoldeCompteADebiter);					
					monCompteACrediter.setSolde(newSoldeCompteACrediter);
		
						}
				compteDAO.modifierCompte(monCompteADebiter);
				compteDAO.modifierCompte(monCompteACrediter);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BanqueException("Erreur lors du virement");
		}
	}
	
	
}
