package be.odisee.brainstorm.service;

import java.util.Collection;

import be.odisee.brainstorm.domain.Gebruiker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service("userContextService")
public class UserContextServiceImpl implements UserContextService {

    @Autowired
    protected BrainstormSessieService brainstormSessieService=null; // ready for dependency injection

    @Override
    public Gebruiker getAuthenticatedPersoon() {
    
	    UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String username = principal.getUsername();
	    System.out.println("DEBUG: Username uit Principal is "+username);
	
	    Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	    for (GrantedAuthority authority : authorities){
	    	System.out.println("DEBUG: Granted authority is "+authority.getAuthority());
	    }
	    Gebruiker thePersoon = brainstormSessieService.zoekPersoonMetEmailadres(username);
	    System.out.println("Username: " + username);
	    System.out.println("thePersoon: " + thePersoon);
	    return thePersoon;
    }
}
