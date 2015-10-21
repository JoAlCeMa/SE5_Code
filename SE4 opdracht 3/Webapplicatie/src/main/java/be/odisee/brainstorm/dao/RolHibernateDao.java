package be.odisee.brainstorm.dao;

import org.hibernate.*;
import org.springframework.stereotype.Repository;

import be.odisee.brainstorm.domain.Rol;

@Repository("rolDao")
public class RolHibernateDao extends HibernateDao implements RolDao {

    public Rol saveRol(Rol rol) {
        sessionSaveObject(rol);
        return rol;
    }

    public Rol getRolById(int id) {
        return (Rol) sessionGetObjectById("Rol", id);
    }

    public Rol getRolByUserid(String userid) {

        String qstr = "from Rol where usernaam = :userid";
        String parameter = "userid";
        String value=userid;

        return (Rol) sessionGetObjectBy1StringParameterNamedQuery(qstr,parameter,userid);
    }

    public void insertRol(int id, String rechten, String username)
    {
    	sessionInsertRights(id, rechten, "rollen", username);
    }

}
