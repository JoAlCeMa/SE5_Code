Feature: toevoegen van een gebruiker, alleen business rules

Het zou mogelijk moeten zijn om gebruikers toe te voegen. Als een gebruiker toegevoegd wordt moet hij in de lijst met gebruikers zichtbaar zijn.

Scenario: toevoegen van een gebruiker
Given dat ik een gebruiker toevoeg met correcte gegevens
When ik de gebruiker opsla
Then moet ik de details van gebruiker zien
And staat de net toegevoegde gebruiker in de lijst van alle gebruikers