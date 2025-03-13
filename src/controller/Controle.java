package controller;

import model.Carte;
import model.Jeu;
import model.Pirate;
import view.IAffichage2;


public class Controle {
	
	private IAffichage2 affichage;
	private Jeu jeu;
	
	public Controle (IAffichage2 affichage, Jeu jeu) {
		this.affichage=affichage;
		this.jeu=jeu;
	}
	
	public void demarrer() {
		affichage.afficherBienvenue();
		String[]nomJoueurs=affichage.getNomJoueurs();
		affichage.afficherDebutJeu();
		jeu.initialiserJoueurs(nomJoueurs[0], nomJoueurs[1]);
		while (!jeu.getFin()) {
			
			Pirate joueurActuel=this.jeu.getJoueurActuel();
			affichage.afficherTourActuel(joueurActuel.getNom());
			
			Carte cartePiochee = jeu.piocher(joueurActuel);
			
			System.out.print(joueurActuel.getNom() + " a pioché ");
			afficherCarte(cartePiochee);
			afficherMain(joueurActuel);
			int choixCarte = choisirCarte(joueurActuel);
			Carte carteJouee = joueurActuel.getMain()[choixCarte-1];
			joueurActuel.jouerCarte(carteJouee);
			affichage.afficherCarteJouee(carteJouee.getNom());
		}
	}
	
	private void afficherCarte(Carte carte) {
		System.out.println("la carte " + carte.getNom() + " de type " + carte.getType() + " : " + carte.getDescription());
	}
	
	private void afficherMain (Pirate pirate) {
		System.out.println("Voici la main de " + pirate.getNom() + ". Quelle carte souhaite-t-il jouer ?");
		for (int i = 0 ; i < 5 ; i++) {
			System.out.println("Carte numéro " + (i+1));
			afficherCarte(pirate.getMain()[i]);
		}
	}
	
	private int choisirCarte (Pirate pirate) {
		int choix = affichage.getChoixCarte();
		while (pirate.getMain()[choix]==null) {
			choix = affichage.getChoixCarte();
		}
		return choix;
	}
}
