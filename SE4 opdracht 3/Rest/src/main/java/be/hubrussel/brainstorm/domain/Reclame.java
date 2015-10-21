package be.hubrussel.brainstorm.domain;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="reclame")
public class Reclame implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String adverteerdernaam;
	private String reclamebericht;
	private Date startdatum;
	private String status;
	private int views;
	
	 public Reclame(){  }
	 
	 public Reclame(String adverteerdernaam, String reclamebericht, Date startdatum, String status, int views) {
	    	this.adverteerdernaam = adverteerdernaam;
	    	this.reclamebericht = reclamebericht;
	    	this.startdatum = startdatum;
	    	this.status = status;
	    	this.views = views;
	    }

	    public Reclame(int id, String adverteerdernaam, String reclamebericht, Date startdatum, String status, int views) {
	    	this.id = id;
	    	this.adverteerdernaam = adverteerdernaam;
	    	this.reclamebericht = reclamebericht;
	    	this.startdatum = startdatum;
	    	this.status = status;
	    	this.views = views;
	    }

	    @XmlElement(name="id")
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		 @XmlElement(name="adverteerdernaam")
		public String getAdverteerdernaam() {
			return adverteerdernaam;
		}

		public void setAdverteerdernaam(String adverteerdernaam) {
			this.adverteerdernaam = adverteerdernaam;
		}

		@XmlElement(name="reclamebericht")
		public String getReclamebericht() {
			return reclamebericht;
		}

		public void setReclamebericht(String reclamebericht) {
			this.reclamebericht = reclamebericht;
		}

		@XmlElement(name="startdatum")
		public Date getStartdatum() {
			return startdatum;
		}

		public void setStartdatum(Date startdatum) {
			this.startdatum = startdatum;
		}

		@XmlElement(name="status")
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@XmlElement(name="views")
		public int getViews() {
			return views;
		}

		public void setViews(int views) {
			this.views = views;
		}

	    
	    
}