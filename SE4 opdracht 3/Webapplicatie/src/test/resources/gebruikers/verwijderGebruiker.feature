Feature: verwijderen van gebruikers

Er zijn gebruikers in het systeem. Nadat een gebruiker wordt geselecteerd en wordt verwijdert, is hij niet meer te zien in de lijst met gebruikers.

Scenario: Verwijder een gebruiker zonder rol
Given ik ben aangemeld als een administrator
And ik ben op de pagina met de lijst van gebruikers
And ik navigeer naar de gebruiker met de gebruikersnaam "mrh6eshik7 MUCrTncmmP9fXnPKQT1E"
And ik verwijder de gebruiker
Then kom ik naar de lijst van de gebruikers
And is gebruiker "mrh6eshik7 MUCrTncmmP9fXnPKQT1E" niet meer in de lijst
And sluit ik de browser

Scenario: Verwijder een gebruiker één rol
Given ik ben aangemeld als een administrator
And ik ben op de pagina met de lijst van gebruikers
And ik navigeer naar de gebruiker met de gebruikersnaam "uxNCIxUJWD z5ccmZKmHmz66NRDSyJ2"
And ik verwijder de gebruiker
Then kom ik naar de lijst van de gebruikers
And is gebruiker "uxNCIxUJWD z5ccmZKmHmz66NRDSyJ2" niet meer in de lijst
And sluit ik de browser

Scenario: Verwijder een gebruiker twee rollen
Given ik ben aangemeld als een administrator
And ik ben op de pagina met de lijst van gebruikers
And ik navigeer naar de gebruiker met de gebruikersnaam "zmiTCWVO31 0tAz4ReUBezEP4X8LHqE"
And ik verwijder de gebruiker
Then kom ik naar de lijst van de gebruikers
And is gebruiker "zmiTCWVO31 0tAz4ReUBezEP4X8LHqE" niet meer in de lijst
And sluit ik de browser