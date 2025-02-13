package joueur;

import java.security.SecureRandom;
import java.util.Random;

import affichage.Affichage;
import carte.Carte;



public class Jeu {
	
	protected Carte[] listeCartes = new Carte [40];
	protected Carte [] pioche = new Carte [40];
	protected Pirate pirate1;
	protected Pirate pirate2;
	protected Affichage affichage = new Affichage();
	public Jeu() {
		this.pirate1= new Pirate(1,5,0);
		this.pirate2= new Pirate(2,5,0);
}
	
	
	public void creerPioche (Carte [] listeCartes) {
		while (pioche.length<40) {
			Random random=null;
			//random pour creer la pioche
			try {
				random = SecureRandom.getInstanceStrong();
				} catch (Exception e) {
				e.printStackTrace();
				}
			int i=random.nextInt(40);
			
			if (pioche[i]==null && listeCartes[i]!=null) {
				pioche[i]=listeCartes[i];
				listeCartes[i]=null;
			}
		}
	}
	
	public Carte[] getPioche() {
		return this.pioche;
	}
}