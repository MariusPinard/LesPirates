package model;

public class CartePuissance extends Carte{
	
	public CartePuissance(String nom, String description) {
		super(nom, TypeCarte.SPECIALE, description);

	}

	@Override
	public void appliquerEffet(Pirate joueurActuel, Pirate adversaire) {
		
	}

	@Override
	public void appliquerEffetPuissance(Pirate joueurActuel, Pirate adversaire) {
		adversaire.diminuerPV(joueurActuel.getPopularite());
	}

	@Override
	public Carte appliquerEffetEchange(Pirate joueurActuel, Pirate adversaire, int choisirCarte) {
		return null;
	}
}
