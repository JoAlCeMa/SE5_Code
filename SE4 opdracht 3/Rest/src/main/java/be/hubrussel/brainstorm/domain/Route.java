package be.hubrussel.brainstorm.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Index;

import javax.xml.bind.annotation.*;

@Entity
@Table(name="routes")
@XmlRootElement(name="route")
public class Route implements Serializable {

 	private static final long serialVersionUID = 1L;

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

    @XmlElement(name="id")
    public int getId() {
        return id;
    }
    
    @XmlElement(name="naam")
   public String getNaam() {
        return naam;
    }

    @XmlElement(name="status")
   public String getStatus() {
   	 return status;
   }

    @XmlElement(name="lengtegraad")
   public double getLengtegraad() {
   		return lengtegraad;
   	}

    
   	public void setLengtegraad(double lengtegraad) {
   		this.lengtegraad = lengtegraad;
   	}


   	@XmlElement(name="breedtegraad")
   	public double getBreedtegraad() {
   		return breedtegraad;
   	}

   	public void setBreedtegraad(double breedtegraad) {
   		this.breedtegraad = breedtegraad;
   	}

   	@XmlElement(name="type")
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

   	@XmlElement(name="betrouw")
   	public int getBetrouw() {
   		return betrouw;
   	}
       
   	public void setBetrouw(int betrouw) {
   		this.betrouw = betrouw;
   	}


   	@XmlElement(name="control")
   	public int getControl() {
   		return control;
   	}

   	public void setControl(int control) {
   		this.control = control;
    }

}