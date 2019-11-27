package fr.ort.m1;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.m2.spring.banque.bdd.dao.ClientDAO;
import fr.formation.m2.spring.banque.bdd.entities.Client;
import fr.formation.m2.spring.banque.bdd.entities.Compte;
import fr.formation.m2.spring.banque.bdd.util.BanqueException;
import fr.ort.m1.exec.BddUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		model.addAttribute("message", "Bienvenue sur l'interface d'administration Willy Bank !" );
		return "homeAdmin";
	}
	
	
	@RequestMapping(value="/listeClients")
	public ModelAndView listeClients(HttpServletRequest req, HttpServletResponse rep) throws BanqueException {
		logger.info("Customers list page");
		
		Map<String, List<Compte>> model = BddUtils.getAllCustomersAccounts();	
	
		
		logger.info("END GetAllCustomersAccounts Method");
		return new ModelAndView("listeClients", "data", model);
	}
	
//	@RequestMapping(value="/homeAdmin")
//	public ModelAndView listeClients(HttpServletRequest req, HttpServletResponse rep) throws BanqueException {
//		logger.info("Home admin page");
//		
//		Map<String, List<Compte>> model = BddUtils.getAllCustomersAccounts();	
//	
//		
//		logger.info("END GetAllCustomersAccounts Method");
//		return new ModelAndView("listeClients", "data", model);
//	}
	
}
