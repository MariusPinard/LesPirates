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
		
		
		jeu.distribuer(jeu.getJoueur1());
		jeu.distribuer(jeu.getJoueur2());
		
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
			
			jeu.tourSuivant();
		}
	}
	
	private void afficherCarte(Carte carte) {
		System.out.println("la carte " + carte.getNom() + " de type " + carte.getType() + " : " + carte.getDescription());
	}
	
	private void afficherMain (Pirate pirate) {
		System.out.println("Voici la main de " + pirate.getNom() + ". Quelle carte souhaite-t-il jouer ?");
		for (int i = 0 ; i < 5 ; i++) {
			System.out.println("Carte numÃ©ro " + (i+1));
			if (pirate.getMain()[i]!=null) {
				afficherCarte(pirate.getMain()[i]);
			} else {
				System.out.println("Emplacement vide");
			}
		}
	}
	
	private int choisirCarte (Pirate pirate) {
		int choix = affichage.getChoixCarte();
		while (pirate.getMain()[choix-1]==null) {
			choix = affichage.getChoixCarte();
		}
		return choix;
	}
	
}
