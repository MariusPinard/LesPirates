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
		affichage.afficherCarte(this, carte);
		if (carte.getType()=="popularite") {
			this.jouerCartePopularite(carte);
		} else if (carte.getType() == "attaque") {
			this.jouerCarteAttaque(Carte carte, jo)
		}
	}
	
	public void jouerCartePopularite (Carte carte) {
		this.augmenterPopularite(carte.getPopularite());
		this.diminuerPV(carte.getPV());
	}
		
	
	public int getNumeroJoueur () {
		return this.numeroJoueur;
	}
	
	public void piocher() {
		
		Random random=null;
		try {
			random = SecureRandom.getInstanceStrong();
			} catch (Exception e) {
			e.printStackTrace();
			}
		int r=random.nextInt(40);
		
		for (int i=0 ; i < 5 ; i++) {
			if (this.main[i]==null) {		
				this.main[i]=listeCartes[r];
			}
		}
	}
}
