package be.odisee.brainstorm.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Deelnemer")
public class Deelnemer extends Rol {

/*

    public Deelnemer() {
    }

    public Deelnemer(String status, String usernaam, Gebruiker persoon) {
        super(status,usernaam,persoon);
    }

    public Deelnemer(int id, String status, String usernaam, Gebruiker persoon) {
        super(id,status,usernaam,persoon);
    }

    public Deelnemer(String status, String usernaam) {
    	super(status, usernaam);
    }
    
    */
	
    @Override
    public String getType() {
        return "Gebruiker";
    }
}