package model;

public class CartePopularite extends Carte {
	
	private int pointsPopularite;
	private int coutVie;
	public CartePopularite(String nom, int pointsPopularite, int coutVie, String description) {
		super(nom, TypeCarte.POPULARITE, description);
		this.pointsPopularite=pointsPopularite;
		this.coutVie=coutVie;
	}
	
	public int getPointsPopularite() {
		return pointsPopularite;
	}
	
	public int getCoutVie() {
		return coutVie;
	}
	
	
	@Override
	public void appliquerEffet(Pirate joueurActuel,Pirate adversaire) {
		joueurActuel.diminuerPV(coutVie);
		joueurActuel.augmenterPopularite(pointsPopularite);
		}
}
