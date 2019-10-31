package fr.ort.wmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/test2")
	public ModelAndView test2(HttpServletRequest req, HttpServletResponse rep) {
		logger.info("Welcome to test2 page !");
		
		Map<String, Object> model = new HashMap<String, Object>();
		
			
		model.put("un", "janvier");
		model.put("deux", "février");
		model.put("trois", "mars");
		
		return new ModelAndView("test2", "data", model);
	}
	
	@RequestMapping(value="/test2a")
	public String noModel(Model model) {
		
		model.addAttribute("un", "lundi");
		model.addAttribute("deux", "mardi");
		model.addAttribute("trois", "mercredi");

		return "test2a";
	}
	
	@RequestMapping(value="/test3")
	public String attenteParam(@RequestParam String param, Model model) throws Exception {
		
		if (param.isEmpty()) param = "erreur";
		
		model.addAttribute("chaine", param);
		return "test3";
	}
	
	@RequestMapping(value="/test3a")
	public String option(@RequestParam (value="param", required=false) String param, Model model) {
		model.addAttribute("chaine", param);
		if (param.isEmpty()) param = "paramètre absent";
		return "test3a"; 
	}
	
}
