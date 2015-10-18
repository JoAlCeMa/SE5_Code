package be.hubrussel.brainstorm.service;

import be.hubrussel.brainstorm.domain.*;
import be.hubrussel.brainstorm.dao.*;
import be.hubrussel.brainstorm.domain.Route;
import be.hubrussel.brainstorm.dao.PersoonDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.*;

@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class BrainstormSessieServiceImpl implements BrainstormSessieService {

    private PersoonDao routeDao;
    
    @Autowired
    public void setPersoonDao(PersoonDao routeDao) {
        this.routeDao = routeDao;
    }

    public BrainstormSessieServiceImpl(){}

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Route zoekRouteMetId(int id){
    	System.out.println("hier ben ik" + id);
    	return routeDao.getRouteById(id);
        //return routeDao.getRouteById(id);
    }

}