package view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Affichage	implements IAffichage {

	private final Scanner scanner = new Scanner(System.in);
    
    @Override
    public void afficherBienvenue() {
        System.out.println("Bienvenue dans le jeu des pirates !");
    }
    
    @Override
    public String[] getNomJoueurs() {
    	String[] nomJoueurs = new String[2];
		for (int i = 0; i < 2; i++) {
			System.out.print("Entrez le nom du joueur " + (i + 1) + " : ");
			nomJoueurs[i] = scanner.nextLine().trim();
		}
		System.out.println("");
		return nomJoueurs;
    }
    
    @Override
	public void afficherDebutJeu () {
		System.out.println("La partie va commencer.");
	}
	
    @Override
    public void afficherEtatJeu(String[] etatJoueur1, String[] etatJoueur2, String[][] zonePopulariteJoueur1,
			String[][] zonePopulariteJoueur2, String[] zoneAttaque) {
		
		System.out.println("Etat actuel du jeu : ");
		
		
		System.out.println("Pirate 1 : " + etatJoueur1[0] + " a " + etatJoueur1[1] + 
				" points de vie et " + etatJoueur1[2] + " points de popularité .");
		System.out.println("Pirate 2 : " + etatJoueur2[0] + " a " + etatJoueur2[1] + 
				" points de vie et " + etatJoueur2[2] + " points de popularité .");
		System.out.println();
		
		
		System.out.println("Zone de Popularité du Joueur 1 :");
		if (zonePopulariteJoueur1.length == 0) {
			System.out.println("Aucune carte.");
		} else {
			for (int i = 0; i < zonePopulariteJoueur1.length; i++) {
				System.out.println(zonePopulariteJoueur1[i][0] + " de type " + zonePopulariteJoueur1[i][2] + " : " + zonePopulariteJoueur1[i][1]);

			}
		}
		
		System.out.println();
		
		System.out.println("Zone de Popularité du Joueur 2");
		if (zonePopulariteJoueur2.length == 0) {
			System.out.println("Aucune carte.");
		} else {
			for (int i = 0; i < zonePopulariteJoueur2.length; i++) {
				System.out.println(zonePopulariteJoueur2[i][0] + " : " + zonePopulariteJoueur2[i][1]);
			}
		}
		
		System.out.println();
		System.out.println("Zone d'Attaque : ");
		if (zoneAttaque[0]==null) {
			System.out.println("Aucune carte.");
		} else {
			System.out.println(zoneAttaque[0] + " : " + zoneAttaque[1]);
		}
		System.out.println();
	}
    
    
    public void afficherCartePiochee(String [] carte, String nomJoueur) {
		System.out.println(nomJoueur + " a pioché la carte " + carte[0] + " de type " + carte[2] + " : " + carte[1]);

    }
    
    @Override
    public void afficherCarteJouee(String [] carte, String nomJoueur) {
    	System.out.println(nomJoueur + " joue la carte " + carte[0] + " de type " + carte[2] + " : " + carte[1]);
    }
	
	@Override
	public void afficherTourActuel(String nomJoueur) {
		System.out.println("Au tour de " + nomJoueur);
		System.out.println();
	}
	


	@Override
	public int getChoixCarte() {
		System.out.println("Choisissez une carte (1-5) : ");
		try {
			return Integer.parseInt(scanner.nextLine().trim())-1;
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	@Override
	public void afficherErreurChoix() {
		System.out.println("Choix invalide, rééssayez s'il vous plait.");
	}
	
	public void afficherResultatEchange(String carteDonnee, String carteRecue) {
		System.out.println("Vous avez donné la carte " + carteDonnee + " et reçu la carte " + carteRecue);
	}

	@Override
	public void afficherVainqueur(String vainqueur) {
		System.out.println(vainqueur);
	}
	

	public static void main(String[] args) {

	}
    
}