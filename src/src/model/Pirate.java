package model;

import model.Jeu;
import view.Affichage;

import java.security.SecureRandom;
import java.util.Random;


public class Pirate {
	
	protected String nom;
	protected int numeroJoueur;
	protected int pv;
	protected int popularite;
	protected Pirate adversaire;
	protected Carte [] main;
	protected int tailleMain;
	
	public Pirate (int numeroJoueur, int pv, int popularite) {
		this.numeroJoueur=numeroJoueur;
		this.pv=pv;
		this.popularite=popularite;
		this.main=new Carte[5];
		this.tailleMain=0;
	}
	
	public void augmenterPopularite (int popu) {
		this.popularite+=popu ;
	}
	
	public void diminuerPV (int coup) {
		this.pv-=coup;
	}
	
	public void jouerCarte (Carte carte) {
		if (carte.getType()=="POPULARITE") {
			this.jouerCartePopularite(carte);
		} else if (carte.getType() == "ATTAQUE") {
			this.jouerCarteAttaque(carte, this.adversaire);
		}
	}

	
	public void jouerCartePopularite (Carte carte) {
		this.augmenterPopularite(carte.getPopularite());
		this.diminuerPV(carte.getPV());
	}
	
	public void jouerCarteAttaque(Carte carte, Pirate pirate) {
		this.augmenterPopularite(carte.getPopularite());
		pirate.diminuerPV(carte.getPV());
	}
		
	public int getNumeroJoueur () {
		return this.numeroJoueur;
	}
	
	public Carte [] getMain () {
		return this.main;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getTailleMain() {
		return this.tailleMain;
	}
	
	public Pirate getAdversaire() {
		return this.adversaire;
	}
}
