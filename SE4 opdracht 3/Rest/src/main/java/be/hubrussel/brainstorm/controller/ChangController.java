package be.hubrussel.brainstorm.controller;

import java.util.Date;

import be.hubrussel.brainstorm.domain.*;
import be.hubrussel.brainstorm.service.BrainstormSessieService;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/reclame")
public class ChangController {
	
	// REST POST
	@RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Reclame createReclame(@RequestBody Reclame reclame, HttpServletResponse response) 
    		throws BindException{
    	
    	//brainstormSessieService.voegPersoonToe(persoon);
		//Reclame nieuwReclame = 
		reclame.setId(2);
        response.setHeader("Location", "/reclame/"+reclame.getId());
        return reclame;
    }
	
// REST GET ... breng de toestand van bestaande resource van de server naar de client
    
    @RequestMapping(value={"/{id}"},method=RequestMethod.GET)
    public @ResponseBody Reclame getReclame(@PathVariable("id") Integer id, Model model){
    	
    	Date date = new Date();
        Reclame reclame = new Reclame(1,"TomTom", "Stormstraat", date, "gelukt", 500);
        return reclame;
    }
	
}