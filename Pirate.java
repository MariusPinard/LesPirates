package joueur;

import carte.Carte;

public class Pirate {
	
	protected int pv;
	protected int popularite;
	protected Carte [] main;
	
	public Pirate (int pv, int popularite) {
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
		affichage(carte);
		this.augmenterPopularite(carte.getPopularite());
		this.diminuerPV(carte.getPV());
	}
}
