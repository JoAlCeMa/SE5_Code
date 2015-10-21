package be.odisee.brainstorm.dao;

import be.odisee.brainstorm.domain.*;

import java.util.List;

public interface RouteDao {

    public Route saveRoute(int id, String status, String naam, double breedtegraad, double lengtegraad, String type);

    public Route saveRoute(String string, String naam, double breedtegraad, double lengtegraad, String type);

    public Route getRouteById(int persoonId);

    public List<Route> getAllRoutes();
    
    public List<Route> getOKRoute();

    public void updateRoute(Route persoon);
    
    public void verwijderRoute (int routeId);
    
    public void veranderRoute (Route route);
    
    public List<Route> getNietOkRoute();
    
    public List<Route> getBetrouwRoute();

    public void routeBetrouwOk(int id);
    
    public void routeControlOk(int id);
}