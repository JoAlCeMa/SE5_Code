package be.odisee.brainstorm.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Community")
public class Community extends Rol {

    public Community(){}

    public Community(String status, String usernaam, Gebruiker persoon){
        super(status,usernaam,persoon);
    }

    public Community(int id, String status, String usernaam, Gebruiker persoon){
        super(id,status,usernaam,persoon);
    }
    
    public Community(String status, String usernaam)
    {
    	super(status, usernaam);
    }

    @Override
    public String getType() {
        return "Community";
    }

}