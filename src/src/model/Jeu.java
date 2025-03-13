package model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import view.Affichage;

import java.util.Random;


public class Jeu {
	
	protected Pirate pirate1;
	protected Pirate pirate2;
	protected Affichage affichage = new Affichage();
	private Random random;
	protected int nbCartesPioche;
	
	protected Carte [] listeCartes;
	protected boolean fin;
	protected Pirate joueurActuel;
	
	public Jeu() {
		this.pirate1= new Pirate(1,5,0);
		this.pirate2= new Pirate(2,5,0);
		
		pirate1.adversaire=pirate2;
		pirate2.adversaire=pirate1;
		
		//this.pioche = new ArrayList(pioche);
		//Collections.shuffle(pioche);
		//this.index=0;
		
		this.fin=false;
		
		try {
			random = SecureRandom.getInstanceStrong();
			} catch (Exception e) {
			e.printStackTrace();
			}
		
		this.joueurActuel=pirate1;
		
		
		listeCartes = new Carte[13];
		this.nbCartesPioche=13;

		listeCartes[0] = new Carte("Attaque", "ATTAQUE", 2, -2, "Attaque du bateau ennemi");
		listeCartes[1] = new Carte("Mutinerie", "ATTAQUE", -3, -4, "Une révolte éclate à bord !");
		listeCartes[2] = new Carte("Défense", "POPULARITE", 1, 3, "Renforce le navire");
		listeCartes[3] = new Carte("Fête", "POPULARITE", 4, 2, "Les marins célèbrent une victoire");
		listeCartes[4] = new Carte("Pillage", "ATTAQUE", 5, -3, "Vol d'un navire ennemi");
		listeCartes[5] = new Carte("Tempête", "ATTAQUE", -3, -5, "Une énorme tempête frappe");
		listeCartes[6] = new Carte("Trésor", "POPULARITE", 6, 2, "Vous trouvez un trésor caché");
		listeCartes[7] = new Carte("Sabotage", "ATTAQUE", -4, -3, "Un espion sabote votre navire");
		listeCartes[8] = new Carte("Renforts", "POPULARITE", 3, 4, "Des alliés viennent vous aider");
		listeCartes[9] = new Carte("Ravitaillement", "POPULARITE", 2, 3, "Vous recevez des provisions");
		listeCartes[10] = new Carte("Coup de Kuka", "ATTAQUE", 0, -2, "Attaque ! Le pirate adversaire perd deux points de vie.");
		listeCartes[11] = new Carte("Repère outil", "POPULARITE", 2, 0, " Le pirate repère son adversaire sans se faire repérer, il gagne 2 points de popularité");
		listeCartes[12] = new Carte("Eclipse", "POPULARITE", 3, 0, "Après une brillante utilisation d'Eclipse, le pirate gagne 3 points de popularité");
	
		this.listeCartes=listeCartes;
		
	}
	
	public void initialiserJoueurs(String nomJoueur1, String nomJoueur2) {
		pirate1.nom=nomJoueur1;
		pirate2.nom=nomJoueur2;
	}
	

	
	public void distribuer(Pirate pirate) {
		
		if (nbCartesPioche==0) {
			
		} else {
			for (int i=0 ; i < 4 ; i++) {
				if (pirate.main[i]==null) {	
					int rd=random.nextInt(0,12);
					Carte cartePiochee=listeCartes[rd];
					while (cartePiochee==null) {
						rd=random.nextInt(0,12);
						cartePiochee=listeCartes[rd];
					}
					pirate.main[i]=cartePiochee;
					listeCartes[rd]=null;
				}
			}
		pirate.tailleMain=4;
		}
	}
	
	public Carte piocher(Pirate pirate) {
		
		Carte cartePiochee=null;
		
		if (pirate.getTailleMain()==5) {
			return null;
		}
		
		for (int i=0 ; i < 5 ; i++) {
			
			if (pirate.main[i]==null) {
				int rd=random.nextInt(0,12);
				cartePiochee=listeCartes[rd];
				
				while (cartePiochee==null) {
					rd=random.nextInt(0,12);
					cartePiochee=listeCartes[rd];
				}
				pirate.main[i]=cartePiochee;
				listeCartes[i]=null;
				pirate.tailleMain+=1;
			}
		}
		return cartePiochee;
	}
	
	public boolean getFin() {
		return this.fin;
	}
	
	public Pirate getJoueur1() {
		return this.pirate1;
	}
	
	public Pirate getJoueur2() {
		return this.pirate2;
	}
	
	public Pirate getJoueurActuel() {
		return this.joueurActuel;
	}
	
	public void tourSuivant() {
		this.joueurActuel=joueurActuel.adversaire;
	}
}
