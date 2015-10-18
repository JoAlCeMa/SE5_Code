package be.odisee.brainstorm.service;

import be.odisee.brainstorm.domain.Gebruiker;

public interface UserContextService {

    public Gebruiker getAuthenticatedPersoon();
}
