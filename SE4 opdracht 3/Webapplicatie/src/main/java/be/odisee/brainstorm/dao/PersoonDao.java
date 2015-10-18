package be.odisee.brainstorm.dao;

import be.odisee.brainstorm.domain.*;
import java.util.List;

public interface PersoonDao {

    public Gebruiker savePersoon(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord);

    public Gebruiker savePersoon(String string, String voornaam, String familienaam, String emailadres, String paswoord);

    public Gebruiker getPersoonById(int persoonId);

    public Gebruiker getPersoonByEmailadres(String emailadres);

    public List<Gebruiker> getAllPersons();

    public void updatePersoon(Gebruiker persoon);

}
