package no.hvl.dat108.webshop.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.webshop.interfaces.DeltagerRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import no.hvl.dat108.webshop.objects.Deltager;
import no.hvl.dat108.webshop.services.DeltagerService;
import no.hvl.dat108.webshop.services.PassordService;
import no.hvl.dat108.webshop.util.LoginUtil;

@Controller
public class PaameldingController {
	
	@Value("${app.message.ugyldigeDetaljer}") private String UGYLDIGE_DETALJER;
	@Value("${app.message.eksisterer}") private String EKSISTERER;
	
	@Autowired private DeltagerService service;
	@Autowired private PassordService passService;
	
    @GetMapping("/")
    public String redirectToPaaMeldingMedMelding(Model model) {
    	model.addAttribute("deltager", new Deltager());
    	return "paamelding_med_melding";
    }
    
    @GetMapping("/paamelding")
    public String redirectpaameldingToPaaMeldingMedMelding(Model model) {
    	model.addAttribute("deltager", new Deltager());
    	return "paamelding_med_melding";
    }
    
    @PostMapping("/lagreDeltager")
    public String lagreDeltager(@Valid @ModelAttribute("deltager") Deltager deltager,
    		HttpServletRequest request,
    		RedirectAttributes ra,
    		BindingResult bindingResult) {
    	
		if (bindingResult.hasErrors()) {
			ra.addFlashAttribute("redirectMessage", UGYLDIGE_DETALJER);
			System.err.print("lagreDeltager feilet");
			return "redirect:" + "paamelding_med_melding";
		}
		
		if(service.eksistererDeltager(deltager.getMobil())) {
			System.err.print("lagreDeltager feilet ");
			System.err.println(deltager.getMobil() + " eksisterer allerede");
			ra.addFlashAttribute("redirectMessage", EKSISTERER);
			return "paamelding_med_melding";
		}
		
		String salt = passService.genererTilfeldigSalt();
		String hash = passService.hashMedSalt(deltager.getPassord(), salt);
		deltager.setPassord(hash);
		deltager.setSalt(salt);
		
		System.err.println("DeltagerLagret");
		service.lagreDeltager(deltager);
	
    	LoginUtil.loggInnBruker(request, deltager.getMobil(), deltager.getFornavn(), deltager.getEtternavn());
    	
    	return "redirect:" + "deltagerliste";
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationExceptions(
      MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        Map<String, Object> model = new HashMap<>();
        model.put("errors", result.getAllErrors());
        return "redirect:paamelding_med_melding";
    }
    
}