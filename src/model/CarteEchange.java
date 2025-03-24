package model;
import java.util.Random;

public class CarteEchange extends Carte {
	
	public CarteEchange(String nom, String description) {
		super(nom, TypeCarte.SPECIALE, description);
	}
	
	
	
	public void appliquerEffetSpecial(Pirate joueurActuel, Pirate adversaire, int indexCarte) {
		Carte carteChoisie = joueurActuel.supprimerCarteMain(indexCarte);
		Random random = null ;
		int indexCarteAdversaire = random.nextInt(adversaire.getTailleMain());
		while (adversaire.getMain()[indexCarteAdversaire] == null) {
			indexCarteAdversaire = random.nextInt(adversaire.getTailleMain());
		}
		Carte carteAdversaire=adversaire.supprimerCarteMain(indexCarteAdversaire);
		adversaire.ajouterCarteMain(carteChoisie);
		joueurActuel.ajouterCarteMain(carteAdversaire);
	}
	
	@Override
	public void appliquerEffet(Pirate joueurActuel, Pirate adversaire) {
		
	}
}
