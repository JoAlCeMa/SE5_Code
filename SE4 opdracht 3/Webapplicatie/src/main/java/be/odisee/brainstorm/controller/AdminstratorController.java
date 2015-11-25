package be.odisee.brainstorm.controller;

import be.odisee.brainstorm.domain.Gebruiker;
import be.odisee.brainstorm.domain.Rol;
import be.odisee.brainstorm.service.BrainstormSessieService;
import be.odisee.brainstorm.utilities.RolNotFoundException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminstratorController {

    @Autowired
    protected BrainstormSessieService brainstormSessieService = null; // ready for dependency injection

    @RequestMapping(value = {"/admin/index.html", "/admin/home.html"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        List<Gebruiker> deLijst = brainstormSessieService.geefAllePersonen();
        model.addAttribute("personen", deLijst);
        return "/admin/lijstPersonen";
    }
    // je zal naar index.jsp gaan
    
    int idUser;
    String username;
    
    @RequestMapping(value = {"/admin/persoon.html"}, method = RequestMethod.GET)
    public String persoonDetail(@RequestParam("id") Integer id, ModelMap model){
    	idUser = id;
        Gebruiker persoon = brainstormSessieService.zoekPersoonMetId(id);
        username = persoon.getEmailadres();
        model.addAttribute("persoon", persoon);
        return "/admin/persoon";
    }
    // je zal naar persoon.jsp gaan
    
    @RequestMapping(value = {"/admin/nieuwePersoon.html"}, method = RequestMethod.GET)
    public String persoonFormulier(ModelMap model) {
        Gebruiker persoon = new Gebruiker();
        model.addAttribute("depersoon", persoon);
        return "/admin/nieuwePersoon";
    }
    // je zal naar nieuwePersoon.jsp gaan

    @RequestMapping(value = {"/admin/nieuwePersoon.html"}, method = RequestMethod.POST)
    public String persoonToevoegen(@ModelAttribute("depersoon") @Valid Gebruiker persoon, BindingResult result, ModelMap model) {
    	if (result.hasErrors()) {
    		return "/admin/nieuwePersoon"; 
    		// fouten op de form => form opnieuw tonen
    	}
        Gebruiker toegevoegdPersoon = brainstormSessieService.voegPersoonToe(persoon.getVoornaam(), persoon.getFamilienaam(), persoon.getEmailadres(), persoon.getPaswoord());
        return "redirect:/admin/persoon.html?id=" + toegevoegdPersoon.getId();
    }
    // je zal naar de detailpagina van de toegevoegde persoon gaan
    
    @RequestMapping(value = {"/admin/rechten.html"}, method = RequestMethod.GET)
    public String rechten(ModelMap model) {
        return "/admin/rechten";
    }
    // je zal naar de pagina gaan van rechten.
    
    @RequestMapping(value = {"/admin/rechten.html"}, method = RequestMethod.POST)
    public String rechtenToevoegen(@ModelAttribute("rights") @Valid Rol rol, BindingResult result, ModelMap model) throws RolNotFoundException {
    	if (result.hasErrors()) {
    		return "/admin/nieuwePersoon"; 
    		// fouten op de form => form opnieuw tonen
    	}
    	Rol toegevoegdeRol = brainstormSessieService.voegRolToe(rol.getType(), idUser, rol.getType());
    	return "redirect:/admin/index.html";
    }
    
    @RequestMapping(value = {"/admin/grantCommunity.html"}, method = RequestMethod.GET)
    public String grantCommunity( ModelMap model) {
    	brainstormSessieService.inserRights(idUser, "Community", username);
    	// Rol toegevoegdeRol = brainstormSessieService.voegRolToe(rol.getType(), idUser, rol.getType());
    	return "redirect:/admin/index.html";
    }
    
    @RequestMapping(value = {"/admin/grantField.html"}, method = RequestMethod.GET)
    public String grantField( ModelMap model) {
    	brainstormSessieService.inserRights(idUser, "Field", username);
    	// Rol toegevoegdeRol = brainstormSessieService.voegRolToe(rol.getType(), idUser, rol.getType());
    	return "redirect:/admin/index.html";
    }
    
    @RequestMapping(value = {"/admin/grantGebruiker.html"}, method = RequestMethod.GET)
    public String grantGebruiker( ModelMap model) {
    	brainstormSessieService.inserRights(idUser, "Deelnemer", username);
    	// Rol toegevoegdeRol = brainstormSessieService.voegRolToe(rol.getType(), idUser, rol.getType());
    	return "redirect:/admin/index.html";
    }
    
    @RequestMapping(value = {"/admin/grantAdmin.html"}, method = RequestMethod.GET)
    public String grantAdmin( ModelMap model) {
    	brainstormSessieService.inserRights(idUser, "Administrator", username);
    	// Rol toegevoegdeRol = brainstormSessieService.voegRolToe(rol.getType(), idUser, rol.getType());
    	return "redirect:/admin/index.html";
    }
    
    @RequestMapping(value = {"/admin/verwijderPersoon.html"}, method = RequestMethod.GET)
    public String persoonVerwijderen(@RequestParam("id") int id, ModelMap model) {
    	System.out.println("De persoon met id " + id + " wordt verwijdert.");
        brainstormSessieService.verwijderPersoon(id);
        return "redirect:/admin/index.html";
    }
}
