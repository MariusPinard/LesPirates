package model;

import java.security.SecureRandom;

import java.util.Collections;
import java.util.Scanner;

import view.Affichage;

import java.util.Random;


public class Jeu {
	
	protected Pirate pirate1;
	protected Pirate pirate2;
	private Random random;
	protected int nbCartesPioche=40;
	protected int indexPioche=0;
	
	protected Carte [] pioche;
	protected int taillePioche=14;
	protected boolean fin;
	protected Pirate joueurActuel;
	protected Pirate adversaire;
	protected Carte zoneAttaque;
	
	public Jeu() {
		this.pirate1= new Pirate(1,5,0);
		this.pirate2= new Pirate(2,5,0);
		
		pirate1.adversaire=pirate2;
		pirate2.adversaire=pirate1;
		
		this.fin=false;
		
		try {
			random = SecureRandom.getInstanceStrong();
			} catch (Exception e) {
			e.printStackTrace();
			}
		
		this.joueurActuel=pirate1;
		
		
		pioche = new Carte[taillePioche];

		pioche[0] = new CarteAttaque("Attaque", 1, "Attaque du bateau ennemi, l'adversaire perd un point de vie.");
		pioche[1] = new CarteAttaque("Mutinerie", 1, "Une révolte éclate à bord du bateau ennemi, l'adversaire perd un point de vie.");
		pioche[2] = new CartePopularite("Défense", 2, 0, "Vous renforcez votre navire, vous remportez deux points de popularité");
		pioche[3] = new CartePopularite("Fête", 4, 1, "Les marins célèbrent une victoire, vous remportez 4 points de popularité "
				+ "mais perdez 1 point de vie dans l'ivresse.");
		pioche[4] = new CarteAttaque("Pillage", 2, "Vous pillez le navire ennemi, votre adversaire perd deux points de vie.");
		pioche[5] = new CarteAttaque("Tempête", 2, "Une énorme tempête frappe, votre adversaire perd deux points de vie");
		pioche[6] = new CartePopularite("Trésor", 5, 1, "Vous trouvez un trésor caché, vous gagnez 5 points de popularité "
				+ "mais perdez 1 point de vie lors de l'expédition");
		pioche[7] = new CarteAttaque("Sabotage", 1, "Un espion sabote le navire adverse, votre adversaire perd 1 point de vie.");
		pioche[8] = new CartePopularite("Renforts", 3, 0, "Des alliés viennent vous aider, vous gagnez trois points de popularité.");
		pioche[9] = new CartePopularite("Ravitaillement", 2, 0, "Vous recevez des provisions, vous gagnez deux points de popularité");
		pioche[10] = new CarteAttaque("Coup de Kuka", 2, "KUKA ! Le pirate adversaire perd 2 points de vie.");
		pioche[11] = new CartePopularite("Repère outil", 2, 0, " Le pirate repère son adversaire sans se faire repérer, il gagne 2 points de popularité");
		pioche[12] = new CartePopularite("Eclipse", 3, 0, "Après une brillante utilisation d'Eclipse, le pirate gagne 3 points de popularité");
		pioche[13] = new CarteEchange("Echange furtif", "Vous échangez l'une de vos cartes contre une de votre adversaire, prise au hasard");
	
		this.pioche=pioche;
		
	}
	
	public void initialiserJoueurs(String nomJoueur1, String nomJoueur2) {
		pirate1.nom=nomJoueur1;
		pirate2.nom=nomJoueur2;
	}
	
	public Pirate getJoueur1() {
		return pirate1;
	}
	
	public Pirate getJoueur2() {
		return pirate2;
	}
	
	public void distribuer(Pirate pirate) {
		if (indexPioche>=40) {
			System.out.println("Pioche vide !");
		} else {
			
			for (int i=0 ; i < 4 ; i++) {
				
				
				
				if (pirate.main[i]==null) {		
					
					int randomCarte = random.nextInt(taillePioche);
					Carte cartePiochee=pioche[randomCarte];
					
					while (cartePiochee==null) {
						randomCarte = random.nextInt(taillePioche);
						cartePiochee=pioche[randomCarte];
					}
					pirate.main[i]=cartePiochee;
					pirate.tailleMain++;
					pioche[randomCarte]=null;
					indexPioche+=1;
				}
			}
		}
	}
	
	public Carte piocher(Pirate pirate) {
		if (indexPioche>=12) {
			System.out.println("Pioche vide !");
		} else {
			for (int i=0 ; i < 5 ; i++) {
				
				if (pirate.getMain()[i]==null) {
					
					int randomCarte = random.nextInt(taillePioche);
					Carte cartePiochee=pioche[randomCarte];
					
					while (cartePiochee==null) {
						randomCarte = random.nextInt(taillePioche);
						cartePiochee=pioche[randomCarte];
					}
					pirate.main[i]=cartePiochee;
					pirate.tailleMain++;
					pioche[randomCarte]=null;
					indexPioche+=1;
					return cartePiochee;
				}
			}
		}
		return null;
	}
	
	public void jouerCarte(Pirate joueurActuel, int index, Carte carteJouee) {
		Carte playedCard = joueurActuel.supprimerCarteMain(index);
		if (playedCard.getType() == TypeCarte.POPULARITE) {
			carteJouee.appliquerEffet(joueurActuel, joueurActuel.getAdversaire());
			joueurActuel.ajouterZonePopularite(playedCard);
			zoneAttaque = null;

		} else if (carteJouee.getType() == TypeCarte.ATTAQUE) {
			carteJouee.appliquerEffet(joueurActuel, joueurActuel.getAdversaire());
			zoneAttaque = carteJouee;
		}
	}
	
	public boolean getFin() {
		if (pirate1.getVie()<=0 || pirate1.getPopularite()>9 || pirate2.getVie()<=0 || pirate2.getPopularite()>9) {
			return true;
		}
		return false;
	}
	
	public Pirate getJoueurActuel() {
		return this.joueurActuel;
	}
	
	public int getIndexPioche() {
		return indexPioche;
	}
	
	public Carte getZoneAttaque() {
		return zoneAttaque;
	}
	
	public String getVainqueur() {
		if (pirate1.getVie() <= 0 && pirate2.getVie() <= 0) {
			return "Pas de vainqueur !";
		} else if (pirate1.getPopularite()>=10) {
			return pirate1.getNom() + " a gagné !";
		} else if (pirate2.getPopularite()>=10) {
			return pirate2.getNom() + " a gagné !";
		} else if (pirate1.getVie()<=0) {
			return pirate2.getNom() + " a gagné !";
		} else {
			return pirate1.getNom() + " a gagné";
		}
	}
}