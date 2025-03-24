package view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Affichage2	implements IAffichage2 {

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

		System.out.printf("Joueur 1 : %-20s | Vie : %-3s | Popularité : %-3s       │%n", etatJoueur1[0],
				etatJoueur1[1], etatJoueur1[2]);
		System.out.printf("│ Joueur 2 : %-20s | Vie : %-3s | Popularité : %-3s       │%n", etatJoueur2[0],
				etatJoueur2[1], etatJoueur2[2]);
		
		System.out.println();
		
		System.out.println("Zone de Popularité du Joueur 1 :");
		if (zonePopulariteJoueur1.length == 0) {
			System.out.println("Aucune carte");
		} else {
			for (int i = 0; i < zonePopulariteJoueur1.length; i++) {
				System.out.printf("Carte %d : %-21s | Popularité : %-2s | Coût : %-2s Vie │%n", i + 1,
						zonePopulariteJoueur1[i][0], zonePopulariteJoueur1[i][3], zonePopulariteJoueur1[i][2]);
			}
		}
		
		System.out.println();
		
		System.out.println("Zone de Popularité du Joueur 2");
		if (zonePopulariteJoueur2.length == 0) {
			System.out.println("Aucune carte");
		} else {
			for (int i = 0; i < zonePopulariteJoueur2.length; i++) {
				System.out.printf("│ Carte %d : %-21s | Popularité : %-2s | Coût : %-2s Vie │%n", i + 1,
						zonePopulariteJoueur2[i][0], zonePopulariteJoueur2[i][3], zonePopulariteJoueur2[i][2]);
			}
		}
		
		System.out.println();
		System.out.println("Zone d'Attaque");
		if ("".equals(zoneAttaque[0])) {
			System.out.println("Aucune car");
		} else {
			System.out.printf("│ Carte : %-20s | Dégâts : %-2s   │%n", zoneAttaque[0],
					zoneAttaque[2]);
		}
		System.out.println();
	}
    
    
    @Override
    public void afficherCarteJouee(String nom) {
    	System.out.println("");
    }
	
	@Override
	public void afficherTourActuel(String nomJoueur) {
		System.out.printf("Au tour de %-20s %n", nomJoueur.toUpperCase());
		System.out.println();
	}
	


	@Override
	public int getChoixCarte() {
		System.out.println("Choisissez une carte (1-5) : ");
		try {
			return Integer.parseInt(scanner.nextLine().trim());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	@Override
	public void afficherErreurChoix() {
		System.out.println("Choix invalide, rééssayez s'il vous plait.");
	}

	@Override
	public void afficherVainqueur(String name) {
		System.out.println("La partie est terminée, le gaganant est : " + name + ". Félicitations !");
	}
	

	public static void main(String[] args) {

	}
/*import view.IAffichage2;
import view.Affichage2;
import controller.Controle;
import model.Jeu;

public class Main {
	public static void main(String[] args) {
		IAffichage2 affichage = new Affichage2();
		Jeu jeu = new Jeu();
		Controle controle = new Controle(affichage, jeu);
		controle.demarrer();
	}
}*/
    
}