package be.odisee.brainstorm.dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.stereotype.Repository;

import be.odisee.brainstorm.domain.Gebruiker;


@Repository("persoonDao")
public class PersoonHibernateDao extends HibernateDao implements PersoonDao {

    public Gebruiker savePersoon(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        Gebruiker persoon = new Gebruiker(id, status, voornaam, familienaam, emailadres, paswoord);
        sessionSaveObject(persoon);
        return persoon;
    }

    public Gebruiker savePersoon(String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        Gebruiker persoon = new Gebruiker(status, voornaam, familienaam, emailadres, paswoord);
        sessionSaveObject(persoon);
        return persoon;
    }

    public Gebruiker getPersoonById(int persoonId) {
        return (Gebruiker) sessionGetObjectById("Gebruiker", persoonId);
    }

    @Override
    public Gebruiker getPersoonByEmailadres(String emailadres) {
        return (Gebruiker) sessionGetObjectByStringParameterValue("Gebruiker", "emailadres", emailadres);
    }

    public List<Gebruiker> getAllPersons() {
        return (List<Gebruiker>) sessionGetAllObjects("Gebruiker");
    }

    public void updatePersoon(Gebruiker persoon) {
        sessionUpdateObject(persoon);
    }

	@Override
	public void deletePersoon(int id) {
		sessionDeleteObjectByPersoonId("Rol", id);
		sessionDeleteObject("Gebruiker", id);
	}
}
