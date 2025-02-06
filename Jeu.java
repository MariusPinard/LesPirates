package joueur;

import carte.Carte;



public class Jeu {
	
	protected Carte [] pioche = new Carte [40];
	protected Pirate pirate1;
	protected Pirate pirate2;
	
	public Jeu() {
		this.pirate1= new Pirate(5,0);
		this.pirate2= new Pirate(5,0);
	}
	
	public void ajouterCarte (Carte carte) {
		
	}
}