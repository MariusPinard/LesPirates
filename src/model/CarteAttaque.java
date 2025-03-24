package model;

public class CarteAttaque extends Carte {
	
	private int degats;
	
	public CarteAttaque(String nom, int degats, String description) {
		super(nom, TypeCarte.ATTAQUE, description);
		this.degats=degats;
	}
	
	public int getDegats() {
		return degats;
	}

	
	@Override
	public void appliquerEffet(Pirate joueurActuel,Pirate adversaire) {
		adversaire.diminuerPV(degats);
	}
	
	public Carte appliquerEffetSpecial(Pirate joueurActuel, Pirate adversaire, int choisirCarte) {
		return null;
	}
}
