package no.hvl.dat108.webshop.controllers;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.webshop.util.LoginUtil;

@Controller
@RequestMapping("/${app.url.logout}")
public class LogoutController {
	
	@Value("${app.message.loggedOut}") private String LOGGED_OUT_MESSAGE;
	@Value("${app.url.login}") private String LOGIN_URL;
	
	/* 
	 * POST /logout er forespørselen for å logge ut.
	 */
	@PostMapping
    public String loggUt(HttpSession mobil, RedirectAttributes ra) {
		
		if (LoginUtil.erBrukerInnlogget(mobil)) {
			LoginUtil.loggUtBruker(mobil);
		}
   	
		ra.addFlashAttribute("redirectMessage", LOGGED_OUT_MESSAGE);
		return "redirect:" + LOGIN_URL;
    }
	
	@GetMapping
	public String loggerUt(HttpSession mobil, RedirectAttributes ra) {
		
		if (LoginUtil.erBrukerInnlogget(mobil)) {
			LoginUtil.loggUtBruker(mobil);
		}
   	
		ra.addFlashAttribute("redirectMessage", LOGGED_OUT_MESSAGE);
		return "redirect:" + LOGIN_URL;
    }
	
}