package fr.ort.m1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.m2.spring.banque.bdd.entities.Client;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;
import fr.ort.m1.exec.BddUtils;

@Controller
public class FormController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 1. Controller qui demandera l'affichage du formulaire
	
	@RequestMapping(value="/ajoutClient")
	public String ajoutClient(Model model) {
		model.addAttribute("message", "Ajout d'un client" );
		// 2. Formulaire qui sera appelé
		return "addClient"; 
	}
	
	// 3. Controller qui sera appelé après la validation du formulaire
	
	@RequestMapping(value="/ajoutClient", method=RequestMethod.POST)
	public String clientAjoute(HttpServletRequest req, Model mod) throws BanqueException {
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String adresse = req.getParameter("adresse");
		String codePostal = req.getParameter("codePostal");
		String ville = req.getParameter("ville");
		
		Client c = new Client();
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setAdresse(adresse);
		c.setVille(ville);
		c.setCodepostal(codePostal);
		
		mod.addAttribute("nouveauClient", c);
		BddUtils.addNewCustomer(c);
		return "resultat"; // 
	}
	
	
	@RequestMapping(value="/modifClient")
	public String clientModifie(HttpServletRequest req, Model mod) throws BanqueException {
		mod.addAttribute("customersList", BddUtils.getCustomersList());
		Client cl = (Client) req.getAttribute("client");
		logger.info("DEBUGWILL", cl.lightToString());
		return "modifyClient";
	}
	

	
	
	@ModelAttribute ("clientAModifier")
	public Client clientAModifier(HttpServletRequest req, Model model) {
		Client cl = (Client) req.getAttribute("client");
		logger.info("DEBUGWILL", cl.lightToString());
		
		
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String adresse = req.getParameter("adresse");
		String codePostal = req.getParameter("codePostal");
		String ville = req.getParameter("ville");
		
		Client c = new Client();
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setAdresse(adresse);
		c.setVille(ville);
		c.setCodepostal(codePostal);
		return c;
		
	}

}
