package be.odisee.brainstorm.domain;

import be.odisee.brainstorm.utilities.RolNotFoundException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.annotations.Index;

@Entity
@Table(name="routes")
public class Route implements Serializable {

    /**
	 * 
	 */

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String status;

    @Column
    private String naam;

    @Column
    private double lengtegraad;

    @Column
    private double breedtegraad;

    @Column
    private String type;
    
    @Column
    private int betrouw;


	@Column
	private int control;

	/*
    // we zullen nu toch een verwijzing naar Persoon in Rol moeten toevoegen
    @OneToMany(fetch=FetchType.EAGER,mappedBy="route")
    private Set<Rol> m_Rollen= new HashSet<Rol>();
*/
    public Route(){

    }

    public Route(String status, String naam, double lengtegraad, double breedtegraad, String type) {
        this.status = status;
        this.naam = naam;
        this.lengtegraad = lengtegraad;
        this.breedtegraad = breedtegraad;
        this.type = type;
    }
 
 public Route(int id, String status, String naam, double lengtegraad, double breedtegraad, String type) {
	 	this.id = id;
        this.status = status;
        this.naam = naam;
        this.lengtegraad = lengtegraad;
        this.breedtegraad = breedtegraad;
        this.type = type;
    }


 public int getId() {
     return id;
 }


public String getNaam() {
     return naam;
 }

public String getStatus() {
	 return status;
}

public double getLengtegraad() {
		return lengtegraad;
	}

	public void setLengtegraad(double lengtegraad) {
		this.lengtegraad = lengtegraad;
	}


	public double getBreedtegraad() {
		return breedtegraad;
	}

	public void setBreedtegraad(double breedtegraad) {
		this.breedtegraad = breedtegraad;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getBetrouw() {
		return betrouw;
	}
    
	public void setBetrouw(int betrouw) {
		this.betrouw = betrouw;
	}


	public int getControl() {
		return control;
	}

	public void setControl(int control) {
		this.control = control;
	}
	
	
}