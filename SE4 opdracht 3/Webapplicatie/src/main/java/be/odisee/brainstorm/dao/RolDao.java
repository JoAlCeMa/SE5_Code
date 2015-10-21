package be.odisee.brainstorm.dao;

import be.odisee.brainstorm.domain.Rol;

public interface RolDao {

    public Rol saveRol(Rol rol);

    public Rol getRolById(int id);

    public Rol getRolByUserid(String userid);
    
    public void insertRol(int id, String rechten);

}
