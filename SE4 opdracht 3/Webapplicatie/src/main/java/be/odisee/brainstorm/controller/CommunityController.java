package be.odisee.brainstorm.controller;

import java.util.List;

import be.odisee.brainstorm.domain.Rol;
import be.odisee.brainstorm.domain.Route;
import be.odisee.brainstorm.service.BrainstormSessieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

// om deze controller te gebruiken, moet je uw rol gebruiken van Organisator
@Controller
public class CommunityController {

    @Autowired
    protected BrainstormSessieService brainstormSessieService=null; // ready for dependency injection

    @RequestMapping(value={"/organisator/index.html", "/organisator/home.html"},method=RequestMethod.GET)
    public String index(ModelMap model){
        List<Route> deLijst = brainstormSessieService.getNietOkRoute();
        model.addAttribute("routes", deLijst);
        return "/organisator/index";
    }
    // je zal naar index.jsp gaan

    @RequestMapping(value={"/organisator/route.html"},method=RequestMethod.GET)
    public String persoonDetail(@RequestParam("id") Integer id, ModelMap model){
        Route route = brainstormSessieService.zoekRouteMetId(id);
        model.addAttribute("route", route);
        return "/organisator/route";
    }
    // je zal naar route.jsp gaan
    
    @RequestMapping(value={"/organisator/verwijderRoute.html"},method=RequestMethod.GET)
    public String routeVerwijderen(@RequestParam("id") Integer id, ModelMap model){
    	brainstormSessieService.verwijderRoute(id);
    	return "redirect:/organisator/index.html";
    }
    //Je zal terug naar index gaan.
    
    @RequestMapping(value={"/organisator/controlOk.html"},method=RequestMethod.GET)
    public String routeControlOk(@RequestParam("id") Integer id, ModelMap model){
    	brainstormSessieService.routeBetrouwOk(id);
    	return "redirect:/organisator/index.html";
    }
    
}
