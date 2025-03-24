package view;

public interface IAffichage {
	
	
	void afficherBienvenue();

	String[] getNomJoueurs();

	void afficherDebutJeu ();

	void afficherEtatJeu(String[] etatJoueur1, String[] etatJoueur2, String[][] zonePopulariteJoueur1,
			String[][] zonePopulariteJoueur2, String[] zoneAttaque);
	
	void afficherCartePiochee(String[] carte, String nomJoueur);
	
	void afficherCarteJouee(String[] carte, String nomJoueur);

	void afficherTourActuel(String nomJoueur);

	int getChoixCarte();

	void afficherErreurChoix();

	void afficherVainqueur(String name);
}