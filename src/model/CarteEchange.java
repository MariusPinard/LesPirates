package model;
import java.security.SecureRandom;
import java.util.Random;

public class CarteEchange extends Carte {
	
	private Random random;

	public CarteEchange(String nom, String description) {
		super(nom, TypeCarte.SPECIALE, description);
		
		try {
			random = SecureRandom.getInstanceStrong();
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	
	
	public Carte appliquerEffetEchange(Pirate joueurActuel, Pirate adversaire, int indexCarte) {
		Carte carteChoisie = joueurActuel.supprimerCarteMain(indexCarte);
		int indexCarteAdversaire = random.nextInt(adversaire.getTailleMain());
		while (adversaire.getMain()[indexCarteAdversaire] == null) {
			indexCarteAdversaire = random.nextInt(adversaire.getTailleMain());
		}
		Carte carteAdversaire=adversaire.supprimerCarteMain(indexCarteAdversaire);
		adversaire.ajouterCarteMain(carteChoisie);
		joueurActuel.ajouterCarteMain(carteAdversaire);
		
		return carteAdversaire;
		}
	
	@Override
	public void appliquerEffet(Pirate joueurActuel, Pirate adversaire) {
		
	}
	
	public void appliquerEffetPuissance(Pirate joueurActuel, Pirate adversaire) {
		
	}
}
