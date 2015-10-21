package be.hubrussel.brainstorm.controller;

import be.hubrussel.brainstorm.domain.Route;
import be.hubrussel.brainstorm.service.BrainstormSessieService;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/route")
public class PersoonController {

    @Autowired
    protected BrainstormSessieService brainstormSessieService=null; // ready for dependency injection

    @RequestMapping(value={"/home.html","/index.html"},method=RequestMethod.GET)
    public String home(){
    	return "index";
    }
    
    // REST GET ... breng de toestand van bestaande resource van de server naar de client
    
    @RequestMapping(value={"/{id}"},method=RequestMethod.GET)
    public @ResponseBody Route getPersoon(@PathVariable("id") Integer id, Model model){
    	
        Route persoon = brainstormSessieService.zoekRouteMetId(id);
        return persoon;
    }
}
