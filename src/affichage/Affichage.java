package affichage;

import carte.Carte;
import joueur.Pirate;

public class Affichage {
	
	public Affichage () {
		
	}
	
	public void afficherCarte (Pirate pirate, Carte carte) {
		System.out.println("Le joueur" + pirate.getNumeroJoueur() + "joue la carte" + carte.getNom());
	}
}
