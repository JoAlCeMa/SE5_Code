package be.odisee.brainstorm.controller;

import java.util.List;

import javax.validation.Valid;

import be.odisee.brainstorm.domain.*;
import be.odisee.brainstorm.service.BrainstormSessieService;
import be.odisee.brainstorm.service.UserContextService;
import be.odisee.brainstorm.domain.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// om deze controller te gebruiken, moet je uw rol gebruiken van Facilitator, Deelnemer, Observator of Verslaggever
// als Organisator of Administrator mag je deze controller niet gebruiken
@Controller
public class GebruikerController {

    @Autowired
    protected BrainstormSessieService brainstormSessieService=null; // ready for dependency injection

    @Autowired
    protected UserContextService userContextService=null;

    @RequestMapping(value={"/brainstorm/index.html", "/brainstorm/home.html"},method=RequestMethod.GET)
    public String index(ModelMap model){
        System.out.println("in brainstormController");
        List<Route> deLijst = brainstormSessieService.geefOKRoute();
        model.addAttribute("routes", deLijst);
        return "/brainstorm/index";
    }
    // je zal naar index.jsp gaan

    
    @RequestMapping(value={"/brainstorm/route.html"},method=RequestMethod.GET)
    public String persoonDetail(@RequestParam("id") Integer id, ModelMap model){
    	 Gebruiker dePersoon = userContextService.getAuthenticatedPersoon();
         Rol deRol = brainstormSessieService.zoekRolMetId(id);
         model.addAttribute("rol", deRol);
        Route route = brainstormSessieService.zoekRouteMetId(id);
        model.addAttribute("route", route);
        return "/brainstorm/route";
    }
    //Je zal naar route.jsp gaan
    
    Route deroute;
    @RequestMapping(value={"/brainstorm/veranderRoute.html"},method=RequestMethod.GET)
    public String routeVeranderFormulier(@RequestParam("id") Integer id, ModelMap model){
    	deroute = brainstormSessieService.zoekRouteMetId(id);
        model.addAttribute("route", deroute);
        return "/brainstorm/veranderRoute";
    }
    
    @RequestMapping(value={"/brainstorm/veranderRoute.html"},method=RequestMethod.POST)
    public String routeVerander(@ModelAttribute("route") Route route, ModelMap model){
    	deroute.setNaam(route.getNaam());
    	deroute.setBreedtegraad(route.getBreedtegraad());
    	deroute.setLengtegraad(route.getLengtegraad());
    	deroute.setType(route.getType());
    	deroute.setAfstand(route.getAfstand());
        brainstormSessieService.veranderRoute(deroute);
        System.out.println("DEBUG route verander id: "+deroute.getNaam());
        return "/brainstorm/index";
    }
    
    @RequestMapping(value={"/brainstorm/nieuweRoute.html"},method=RequestMethod.GET)
    public String persoonFormulier(ModelMap model){
        Route route = new Route();
        model.addAttribute("deroute", route);
        return "/brainstorm/nieuweRoute";
    }
    // je zal naar nieuweRoute.jsp gaan

    @RequestMapping(value={"/brainstorm/nieuweRoute.html"},method=RequestMethod.POST)
    public String persoonToevoegen(@ModelAttribute("deroute") Route route, ModelMap model){
    	
        Route nieuweRoute = brainstormSessieService.voegRouteToe(route.getNaam(),
                                                                            route.getBreedtegraad(),
                                                                            route.getLengtegraad(),
                                                                            route.getType(),
                                                                            route.getAfstand());
        System.out.println("DEBUG routegegevens naam: "+route.getNaam());
        System.out.println("DEBUG routegegevens afstand: "+route.getAfstand());
        return "redirect:/brainstorm/route.html?id="+nieuweRoute.getId();
    }
    // je zal naar de detailpagina van de toegevoegde route gaan
}
