package be.odisee.brainstorm.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Administrator")
public class Administrator extends Rol {

    public Administrator(){}

    public Administrator(String status, String usernaam, Gebruiker persoon){
        super(status,usernaam,persoon);
    }

    public Administrator(int id, String status, String usernaam, Gebruiker persoon){
        super(id,status,usernaam,persoon);
    }

    public Administrator(String status, String usernaam)
    {
    	super(status,usernaam);
    }
    @Override
    public String getType() {
        return "Administrator";
    }
}