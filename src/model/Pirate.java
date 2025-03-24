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
	protected Carte[] zonePopularite = new Carte[20];
	protected int tailleZonePopularite=0;
	
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
	
	public int getVie() {
		return this.pv;
	}
	
	public int getPopularite() {
		return this.popularite;
	}
	
	public void ajouterZonePopularite(Carte carte) {
		zonePopularite[tailleZonePopularite]=carte;
		tailleZonePopularite++;
	}
	
	public Carte[] getZonePopularite() {
		return zonePopularite;
	}
	
	public int getTailleZonePopularite () {
		return tailleZonePopularite;
	}
	
	public Carte supprimerCarteMain(int index) {
		Carte carteSupprimee=main[index];
		main[index]=null;
		return carteSupprimee;
	}
	
	public Carte ajouterCarteMain(Carte carte) {
		int index=10;
		for (int i=0 ; i < 5 ; i++) {
			if (main[i]==null) {
				index=i;
			}
		}
		if (index!=10) {
			main[index]=carte;
			tailleMain++;
		}
		return carte;
	}
}
