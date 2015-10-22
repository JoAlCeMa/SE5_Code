package be.odisee.brainstorm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import be.odisee.brainstorm.domain.Route;

@Repository("routeDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class RouteHibernateDao extends HibernateDao implements RouteDao {

    public Route saveRoute(int id, String status, String naam, double breedtegraad, double lengtegraad, String type, double afstand) {
        Route route = new Route(id, status, naam, breedtegraad, lengtegraad, type, afstand);
        sessionSaveObject(route);
        return route;
    }
    
    @Override
	public Route saveRoute(String status, String naam, double breedtegraad, double lengtegraad, String type,
			double afstand) {
		Route route = new Route(status, naam, breedtegraad, lengtegraad, type, afstand);
        sessionSaveObject(route);
        return route;
	}

    public Route getRouteById(int routeId) {
        return (Route) sessionGetObjectById("Route", routeId);
    }

    @SuppressWarnings("unchecked")
	public List<Route> getAllRoutes() {
    	System.out.println("in implementatie");
        return (List<Route>) sessionGetAllObjects("Route");
    }

    public void updateRoute(Route route) {
        sessionUpdateObject(route);
    }

    public void verwijderRoute(int routeId){
    	sessionDeleteObject("Route", routeId);
    }
    
    public void veranderRoute (Route route){
    	sessionUpdateRouteAlles("Route", route.getId(), route.getNaam(), route.getBreedtegraad(), route.getLengtegraad(), route.getType(), route.getAfstand());
    }
    
    @SuppressWarnings("unchecked")
    public List<Route> getOKRoute()
    {
    	return (List<Route>) sessionGetObjectByBetrouwbaarheid("Route", 1,1);
    }
    
    @SuppressWarnings("unchecked")
    public List<Route> getNietOkRoute()
    {
    	return (List<Route>) sessionGetObjectByBetrouwbaarheid("Route", 0,0);
    }
    
    @SuppressWarnings("unchecked")
    public List<Route> getBetrouwRoute()
    {
    	return (List<Route>) sessionGetObjectByBetrouwbaarheid("Route", 1,0);
    }
    
    public void routeBetrouwOk(int id){
    	sessionRouteBetrouwOk("Route", id);
    }
    
    public void routeControlOk(int id){
    	System.out.println("In routeHibernate");
    	sessionRouteFieldOk("Route", id);
    }
}