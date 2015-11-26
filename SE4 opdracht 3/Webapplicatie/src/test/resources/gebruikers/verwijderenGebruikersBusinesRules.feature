Feature: verwijderen van een gebruiker, alleen business rules

Het zou mogelijk moeten zijn om gebruikers te verwijderen. Als een gebruiker wordt verwijderd bestaat hij niet meer in het systeem.

Scenario: verwijderen van een gebruiker
Given dat ik de details van een gebruiker bekijk
When ik de gebruiker verwijder
Then moet ik terugkeren naar de lijst van gebruikers
And is de verwijderde gebruiker niet meer in de lijst