package be.odisee.brainstorm.service;

import be.odisee.brainstorm.domain.*;
import be.odisee.brainstorm.dao.*;
import be.odisee.brainstorm.utilities.RolNotFoundException;
import be.odisee.brainstorm.domain.Route;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
@Service("brainstormSessieService")
public class BrainstormSessieServiceImpl implements BrainstormSessieService {

    private PersoonDao persoonDao;
    private RolDao rolDao;
    private RouteDao routeDao;

    public BrainstormSessieServiceImpl(){}


    @Autowired
    public void setPersoonDao(PersoonDao persoonDao) {
        this.persoonDao = persoonDao;
    }

    @Autowired
    public void setRolDao(RolDao rolDao) {
        this.rolDao = rolDao;
    }

    @Autowired 
    public void setRouteDao(RouteDao routeDao){
    	this.routeDao = routeDao;
    }

    public Gebruiker voegPersoonToe(int id, String voornaam, String familienaam, String emailadres, String paswoord) {
        return persoonDao.savePersoon(id,"actief",voornaam,familienaam,emailadres,paswoord);
    }

    public Gebruiker voegPersoonToe(String voornaam, String familienaam, String emailadres, String paswoord) {
        return persoonDao.savePersoon("aktief",voornaam,familienaam,emailadres,paswoord);
    }

    public Gebruiker zoekPersoonMetId(int id){
        return persoonDao.getPersoonById(id);
    }

    public Gebruiker zoekPersoonMetEmailadres(String emailadres){
        return persoonDao.getPersoonByEmailadres(emailadres);
    }

    @Override
    public List<Gebruiker> geefAllePersonen() {
        return persoonDao.getAllPersons();
    }

    @Override
    public Rol voegRolToe(String type, int persoonId, String usernaam) throws RolNotFoundException {
       Gebruiker dePersoon = zoekPersoonMetId(persoonId);
        Rol deRol = dePersoon.voegRolToe(type, "actief", usernaam);
        deRol = rolDao.saveRol(deRol);
        return deRol;
    }

    public Rol zoekRolMetId(int id) {
        return rolDao.getRolById(id);
    }

    public Rol zoekRolMetUserid(String userid) {
        return rolDao.getRolByUserid(userid);
    }
    
    public List<Route> geefAlleRoutes() {
    	System.out.println("Hier ben ik");
        return routeDao.getAllRoutes();
    }

    public List<Route> geefOKRoute() {
    	return routeDao.getOKRoute();
    }
    
    public List<Route> getNietOkRoute() {
    	return routeDao.getNietOkRoute();
    }
    
    public List<Route> getBetrouwRoute() {
    	return routeDao.getBetrouwRoute();
    }
    
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Route zoekRouteMetId(int id){
        return routeDao.getRouteById(id);
    }
    
    public void veranderRoute(Route route)
    {
    	routeDao.veranderRoute(route);
    }
    
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Route voegRouteToe(String naam, double breedtegraad, double lengtegraad, String type) {
        return routeDao.saveRoute("aktief",naam,breedtegraad,lengtegraad,type);
    }
    
    public void verwijderRoute(int routeId){
    	routeDao.verwijderRoute(routeId);
    }
    
    public void routeBetrouwOk(int id)
    {
    	routeDao.routeBetrouwOk(id);
    }
    
    public void routecontrolOk(int id){
    	routeDao.routeControlOk(id);
    }
    
    public void inserRights(int id, String rechten)
    {
    	rolDao.insertRol(id, rechten);
    }
    // TODO deze en andere operaties (ook in andere klassen
    // met een versie met id en zonder id te refactoren (dubbele code)

    

    // TODO deze en andere operaties (ook in andere klassen
    // met een versie met id en zonder id te refactoren (dubbele code)
    
   

}