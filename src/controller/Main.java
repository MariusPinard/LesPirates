package controller;

import view.IAffichage2;
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
}