package be.odisee.brainstorm.service;

import be.odisee.brainstorm.domain.*;
import be.odisee.brainstorm.utilities.RolNotFoundException;
import be.odisee.brainstorm.domain.Route;

import java.util.List;

import org.springframework.stereotype.Service;

public interface BrainstormSessieService {

    

    public Gebruiker voegPersoonToe(int id, String voornaam, String familienaam, String emailadres, String paswoord);

    public Gebruiker voegPersoonToe(String voornaam, String familienaam, String emailadres, String paswoord);

    public Gebruiker zoekPersoonMetId(int id);

    public Gebruiker zoekPersoonMetEmailadres(String username);

    public List<Gebruiker> geefAllePersonen();

    public Rol voegRolToe(String type, int persoonId, String usernaam) throws RolNotFoundException;

    public Rol zoekRolMetId(int id);

    public Rol zoekRolMetUserid(String userid);
    
    public List<Route> geefAlleRoutes();
    
    public List<Route> geefOKRoute();
    
    public List<Route> getNietOkRoute();
    
    public List<Route> getBetrouwRoute();
    
    public Route zoekRouteMetId(int id);
    
    public void veranderRoute(Route route);

    public Route voegRouteToe(String naam, double breedtegraad, double lengtegraad, String type);
    
    public void verwijderRoute(int routeId);
    
    public void routeBetrouwOk(int id);
    
    public void routecontrolOk(int id);
    
    public void inserRights(int id, String rechten, String username);
    
}