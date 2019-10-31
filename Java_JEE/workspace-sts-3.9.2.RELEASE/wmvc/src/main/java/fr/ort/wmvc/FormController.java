package fr.ort.wmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {
	
	// 1. Controller qui demandera l'affichage du formulaire
	
	@RequestMapping(value="/ajoutClient")
	public String ajoutClient() {
		
		// 2. Formulaire qui sera appelé
		return "addClient"; 
	}
	
	// 3. Controller qui sera appelé après la validation du formulaire
	
	@RequestMapping(value="/ajoutClient", method=RequestMethod.POST)
	public String clientAjoute(HttpServletRequest req, Model mod) {
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
		c.setCodePostal(codePostal);
		
		mod.addAttribute("nouveauClient", c);
		
		return "resultat"; // 
	}

}
