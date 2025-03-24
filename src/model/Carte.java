package model;

public abstract class Carte {
	
	protected String nom;
	protected TypeCarte type;
	protected String description;
	
	public Carte (String nom, TypeCarte type, String description) {
		this.nom=nom;
		this.type=type;
		this.description=description;
	}
	
	public String getNom() {
		if (this==null) {
			return "";
		}
		return this.nom;
	}
	
	public TypeCarte getType() {
		return this.type ;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public abstract void appliquerEffet(Pirate joueurActuel, Pirate adversaire);

	public abstract Carte appliquerEffetSpecial(Pirate joueurActuel, Pirate adversaire, int choisirCarte);
	
}
