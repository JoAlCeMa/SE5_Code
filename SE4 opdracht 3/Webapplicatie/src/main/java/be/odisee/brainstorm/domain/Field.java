package be.odisee.brainstorm.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Field")
public class Field extends Rol {



    public Field(){}

    public Field(String status, String usernaam,Gebruiker persoon){
        super(status,usernaam,persoon);
    }

    public Field(int id, String status, String usernaam, Gebruiker persoon){
        super(id,status,usernaam,persoon);
    }

    public Field(String status, String usernaam)
    {
    	super(status, usernaam);
    }
    
    @Override
    public String getType() {
        return "Field";
    }
}