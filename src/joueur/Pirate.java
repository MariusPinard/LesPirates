package joueur;

import carte.Carte;
import joueur.Jeu;
import java.security.SecureRandom;
import java.util.Random;

import affichage.Affichage;


public class Pirate {
	
	protected int numeroJoueur;
	protected int pv;
	protected int popularite;
	protected Pirate adversaire;
	protected Carte [] main;
	
	public Pirate (int numeroJoueur, int pv, int popularite) {
		this.numeroJoueur=numeroJoueur;
		this.pv=pv;
		this.popularite=popularite;
		this.main=new Carte[5];
	}
	
	public void augmenterPopularite (int popu) {
		this.popularite+=popu ;
	}
	
	public void diminuerPV (int coup) {
		this.pv-=coup;
	}
	
	public void jouerCarte (Carte carte) {
		if (carte.getType()=="popularite") {
			this.jouerCartePopularite(carte);
		} else if (carte.getType() == "attaque") {
			this.jouerCarteAttaque(carte, this.adversaire);
		}
	}
	
	public void jouerCartePopularite (Carte carte) {
		this.augmenterPopularite(carte.getPopularite());
		this.diminuerPV(carte.getPV());
	}
	
	public void jouerCarteAttaque(Carte carte, Pirate pirate) {
		
	}
		
	public int getNumeroJoueur () {
		return this.numeroJoueur;
	}
	
	
	
	public Carte [] getMain () {
		return this.main;
	}
	
}
