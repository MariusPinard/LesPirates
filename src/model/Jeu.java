package model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import view.Affichage;

import java.util.Random;



public class Jeu {
	
	protected List<Carte> pioche; protected int index = 0;
	protected Pirate pirate1;
	protected Pirate pirate2;
	protected Affichage affichage = new Affichage();
	private Random random;
	protected int nbCartesPioche;
	
	protected Carte [] listeCartes;
	
	public Jeu() {
		this.pirate1= new Pirate(1,5,0);
		this.pirate2= new Pirate(2,5,0);
		
		pirate1.adversaire=pirate2;
		pirate2.adversaire=pirate1;
		
		//this.pioche = new ArrayList(pioche);
		//Collections.shuffle(pioche);
		//this.index=0;
		
		
		try {
			random = SecureRandom.getInstanceStrong();
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	public void distribuer (Carte [] listeCartes) {
		
		for (int i=0 ; i < 4 ; i++) {	
			pirate2.main[i]=this.pioche.get(index);
			index+=1;
		}
	}
	
	public void piocher(Pirate pirate) {
		
		if (nbCartesPioche==0) {
			
		} else {
			for (int i=0 ; i < 5 ; i++) {
				if (pirate.main[i]==null) {	
			//		pirate.main[i]=this.pioche.get(index);
					
					Carte cartePiochee=listeCartes[random.nextInt(0,40)];
					while (cartePiochee==null) {
						cartePiochee=listeCartes[random.nextInt(0,40)];
					}
					pirate.main[i]=listeCartes[random.nextInt(0,40)];
				}
			}
		}
	}
}