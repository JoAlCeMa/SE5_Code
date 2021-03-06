
package be.odisee.brainstorm.dao;

import org.hibernate.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

class HibernateDao {

    SessionFactory sessionFactory;

    protected HibernateDao() {
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected void sessionSaveObject(Object o){
        try{
            sessionFactory.getCurrentSession().save(o);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected Object sessionGetObjectById(String classname, int id){
        Object result = null;
        try{
            result = sessionFactory.getCurrentSession().createQuery("from "+classname+" where id="+id).uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
    protected List sessionGetObjectByBetrouwbaarheid(String classname, int betrouw, int control)
    {
    	 Query query = null;
  		List result = null;
         try{
         	System.out.println(classname);
             query = sessionFactory.getCurrentSession().createQuery("from "+classname + " where betrouw=" + betrouw + " and control=" + control);
             result = query.list();
         }
         catch (Exception e){
             e.printStackTrace();
         }
         return result;
    }
    
    protected Object sessionGetObjectByStringParameterValue(String classname, String parameter, String value){
        Object result = null;
        try{
            result = sessionFactory.getCurrentSession().createQuery("from "+classname+" where "+parameter+"='"+value+"'").uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }    
    
    protected Object getLastObjectOfQuery(String qstr){
        Object result = null;
        try{
            @SuppressWarnings("rawtypes")
			List list = sessionFactory.getCurrentSession().createQuery(qstr).list();
            // als er geen objecten in het resultaat zitten, retourneren we result = null
            if (!list.isEmpty()) result = list.get(list.size()-1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    protected Object sessionGetObjectBy1StringParameterNamedQuery(String qstr, String parameter, String value){

        // geeft een antlr probleem .. voorlopig is er geen oplossing voor

        Query query = null;
        Object result = null;
        try{
            query = sessionFactory.getCurrentSession().createQuery(qstr);
            query.setString(parameter, value);
            result = query.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    protected Object sessionGetObjectByQuery(String qstr){

        // work arround omdat vorige niet werkt

        Object result = null;
        try{
            Query query = sessionFactory.getCurrentSession().createQuery(qstr);
            result = query.uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
	protected List sessionGetAllObjects(String classname) {
        Query query = null;
 		List result = null;
        try{
        	System.out.println(classname);
            query = sessionFactory.getCurrentSession().createQuery("from "+classname);
            result = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    protected void sessionUpdateObject(Object o){
        try{
            sessionFactory.getCurrentSession().update(o);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    
    protected void sessionDeleteObject(String classname, int id){
    	try{
    	    Query q = sessionFactory.getCurrentSession().createQuery("delete " + classname + " where id = " +id);
    	    q.executeUpdate();
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }
    
    protected void sessionDeleteObjectByPersoonId(String classname, int id){
    	try{
    	    Query q = sessionFactory.getCurrentSession().createQuery("delete " + classname + " where persoon_id = " +id);
    	    q.executeUpdate();
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }
    	
    	 protected void sessionUpdateRouteAlles(String classname, int id, String naam, double breedtegraad, double lengtegraad, String type, double afstand){
    		 try{
    			 Query q = sessionFactory.getCurrentSession().createQuery("update " + classname + " set naam= '" +naam + "' ,breedtegraad= " + breedtegraad + " ,lengtegraad= " + lengtegraad+ " ,type= '" +type + "' ,afstand= " + afstand + ",betrouw= "+ 0 + ",control=" + 0 +" where id = " + id);
    	    	    q.executeUpdate();
    		 }
    		 catch (Exception e){
    	    		e.printStackTrace();
    	    	}
    	 }

    	 protected void sessionRouteFieldOk(String classname, int id)
    	 {
    		 try{
    			 Query q = sessionFactory.getCurrentSession().createQuery("update " + classname + " set control= " + 1 + " where id=" + id);
    			 q.executeUpdate();    		 }
    		 catch (Exception e){
    			 e.printStackTrace();
    		 }
    	 }
    	 
    	 protected void sessionRouteBetrouwOk(String classname, int id)
    	 {
    		 try{
    			 Query q = sessionFactory.getCurrentSession().createQuery("update " + classname + " set betrouw= " + 1 + " where id=" + id);
    			 q.executeUpdate();    		 }
    		 catch (Exception e){
    			 e.printStackTrace();
    		 }
    	 }
    	  
    	 protected void sessionInsertRights(int id, String rechten, String classname, String username)
    	 {
    		 try{
    			 System.out.println("insert into  " + classname + " (type, status, usernaam, persoon_id) values ( '" + rechten + "', 'aktief', '" + username + "', " + id + ")");
    			 Query q = sessionFactory.getCurrentSession().createSQLQuery("insert into  " + classname + " (type, status, usernaam, persoon_id) values ( '" + rechten + "', 'aktief', '" + username + "', " + id + ")"); 
    			 q.executeUpdate();    		 }
    		 catch (Exception e){
    			 e.printStackTrace();
    		 }
    	 }
}
