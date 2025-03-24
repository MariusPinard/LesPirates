package controller;

import model.Carte;
import model.CarteAttaque;
import model.CartePopularite;
import model.Jeu;
import model.Pirate;
import model.TypeCarte;
import view.IAffichage;


public class Controle {
	
	private IAffichage affichage;
	private Jeu jeu;
	
	public Controle (IAffichage affichage, Jeu jeu) {
		this.affichage=affichage;
		this.jeu=jeu;
	}
	
	public void demarrer() {
		
		affichage.afficherBienvenue();
		String[]nomJoueurs=affichage.getNomJoueurs();
		affichage.afficherDebutJeu();
		jeu.initialiserJoueurs(nomJoueurs[0], nomJoueurs[1]);

		jeu.distribuer(jeu.getJoueur1()); jeu.distribuer(jeu.getJoueur2());
		Pirate joueurActuel=jeu.getJoueurActuel();
		
		
		while (!jeu.getFin()) {
			
			affichage.afficherTourActuel(joueurActuel.getNom());

			Carte cartePiochee = jeu.piocher(joueurActuel);
			
			affichage.afficherCartePiochee(carteTableau(cartePiochee),joueurActuel.getNom());
			afficherMain(joueurActuel);
			
			int choixCarte = choisirCarte(joueurActuel);
			Carte carteJouee = joueurActuel.getMain()[choixCarte];
			affichage.afficherCarteJouee(carteTableau(carteJouee),joueurActuel.getNom());
			jeu.jouerCarte(joueurActuel, choixCarte, carteJouee);
			
			if ("Echange furtif".equals(carteJouee.getNom())) {
				int indexCarteChoisie=choisirCarte(joueurActuel);
				Carte carteChoisie=joueurActuel.getMain()[indexCarteChoisie];
				affichage.afficherResultatEchange(carteChoisie.getNom(),
						carteJouee.appliquerEffetEchange(joueurActuel, joueurActuel.getAdversaire(), indexCarteChoisie).getNom());
				
			} else if ("Coup de Yaskawa".equals(carteJouee.getNom())) {
				carteJouee.appliquerEffetPuissance(joueurActuel, joueurActuel.getAdversaire());
				affichage.afficherResultatPuissance(joueurActuel.getPopularite());
			}
			
			affichage.afficherEtatJeu(creerEtatPirate(jeu.getJoueur1()), creerEtatPirate(jeu.getJoueur2()),
				cartesTableau(jeu.getJoueur1().getZonePopularite(), jeu.getJoueur1().getTailleZonePopularite()), 
				cartesTableau(jeu.getJoueur2().getZonePopularite(), jeu.getJoueur2().getTailleZonePopularite()),
				carteTableau(jeu.getZoneAttaque()));
			
			joueurActuel=joueurActuel.getAdversaire();
		}
		affichage.afficherVainqueur(jeu.getVainqueur());
	}
	
	private void afficherCarte(Carte carte) {
		System.out.println("la carte " + carte.getNom() + " de type " + carte.getType() + " : " + carte.getDescription());
	}
	
	private void afficherMain (Pirate pirate) {
		System.out.println("Voici la main de " + pirate.getNom() + ". Quelle carte souhaite-t-il jouer ?");
		for (int i = 0 ; i < 5 ; i++) {
			System.out.println("Carte numéro " + (i+1));
			if (pirate.getMain()[i]!=null) {
				afficherCarte(pirate.getMain()[i]);
			} else {
				System.out.println("Emplacement vide");
			}
		}
	}
	
	private int choisirCarte (Pirate pirate) {
		int choix = affichage.getChoixCarte();
		while (pirate.getMain()[choix]==null) {
			choix = affichage.getChoixCarte();
		}
		return choix;
	}
	
	private String[] carteTableau(Carte carte) {
		
		String [] tabCarte = new String[5];
		if (carte==null) {
			return tabCarte;
		}
		tabCarte[0]=carte.getNom();
		tabCarte[1]=carte.getDescription();
		if (carte.getType()==TypeCarte.POPULARITE) {
			CartePopularite carteP = (CartePopularite) carte;
			tabCarte[2]=String.valueOf(TypeCarte.POPULARITE);
			tabCarte[3]=String.valueOf(carteP.getPointsPopularite());
			tabCarte[4]=String.valueOf(carteP.getCoutVie());
		} else if (carte.getType()==TypeCarte.ATTAQUE) {
			CarteAttaque carteA = (CarteAttaque) carte;
			tabCarte[2]=String.valueOf(TypeCarte.ATTAQUE);
			tabCarte[3]=String.valueOf(carteA.getDegats());
			tabCarte[4]="";
		}
		return tabCarte;
	}
	
	private String[][] cartesTableau(Carte[] cartes, int nbCartes) {
		String[][] tabCartes = new String[nbCartes][];
		for (int i = 0; i < nbCartes; i++) {
			tabCartes[i] = carteTableau(cartes[i]);
		}
		return tabCartes;
	}
	
	private String[] creerEtatPirate(Pirate pirate) {
		
		String[] etat = new String[3];
		etat[0] = pirate.getNom();
		etat[1] = String.valueOf(pirate.getVie());
		etat[2] = String.valueOf(pirate.getPopularite());
		
		return etat;
		}
}
