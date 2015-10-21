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

// om deze controller te gebruiken, moet je uw rol gebruiken van Field
@Controller
public class FieldController {

    @Autowired
    protected BrainstormSessieService brainstormSessieService=null; // ready for dependency injection

    @RequestMapping(value={"/field/index.html", "/field/home.html"},method=RequestMethod.GET)
    public String index(ModelMap model){
        List<Route> deLijst = brainstormSessieService.getBetrouwRoute();
        model.addAttribute("routes", deLijst);
        return "/field/index";
    }
    // je zal naar index.jsp gaan
    
    
    @RequestMapping(value={"/field/route.html"},method=RequestMethod.GET)
    public String persoonDetail(@RequestParam("id") Integer id, ModelMap model){
        Route route = brainstormSessieService.zoekRouteMetId(id);
        model.addAttribute("route", route);
        return "/field/route";
    }
    // je zal naar route.jsp gaan
    
    @RequestMapping(value={"/field/verwijderRoute.html"},method=RequestMethod.GET)
    public String routeVerwijderen(@RequestParam("id") Integer id, ModelMap model){
    	brainstormSessieService.verwijderRoute(id);
    	return "redirect:/field/index.html";
    }
    //Je zal terug naar index gaan.
    
    @RequestMapping(value={"/field/controlOk.html"},method=RequestMethod.GET)
    public String routeControlOk(@RequestParam("id") Integer id, ModelMap model){
    	brainstormSessieService.routecontrolOk(id);
    	return "redirect:/field/index.html";
    }
    
}