package be.hubrussel.brainstorm.dao;

import java.util.List;

import org.hibernate.*;

import be.hubrussel.brainstorm.domain.Route;


public class PersoonHibernateDao extends HibernateDao implements PersoonDao {

	 public Route getRouteById(int routeId) {
		 System.out.println("In de dao " + routeId);
	        return (Route) sessionGetObjectById("Route", routeId);
	    }

}
