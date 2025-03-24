package controller;

import view.IAffichage;
import view.Affichage;
import controller.Controle;
import model.Jeu;

public class Main {
	public static void main(String[] args) {
		IAffichage affichage = new Affichage();
		Jeu jeu = new Jeu();
		Controle controle = new Controle(affichage, jeu);
		controle.demarrer();
	}
}