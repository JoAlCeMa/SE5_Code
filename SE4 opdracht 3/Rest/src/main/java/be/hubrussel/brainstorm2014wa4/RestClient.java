package be.hubrussel.brainstorm2014wa4;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

import be.hubrussel.brainstorm.service.*;
import be.hubrussel.brainstorm.domain.*;

public class RestClient {
	 
	public static void main(String[] args) {
		RestTemplate rt = new RestTemplate();
		Reclame reclame;
		Route route;
		BrainstormSessieService brainstormSessieService = null;
	
	// REST POST laat toe - naast vele andere dingen - om een resource aan te maken
	
			Date date = new Date();
			//route = brainstormSessieService.zoekRouteMetId(3);
			reclame = new Reclame("TomTom", "Marjoleinstraat" ,date, "Aktief", 500 );
			reclame = rt.postForObject("http://localhost:8080/brainstorm2014WA4/reclame", reclame, Reclame.class);
		
			System.out.println("Reclame toegevoegd voor volgende route: "+ "Marjoleinstraat");
			
			//System.out.println("Nieuwe persoon toegevoegd "+dePersoon.getVoornaam()+" "+dePersoon.getFamilienaam()+" met id "+dePersoon.getId());
	}
		}
