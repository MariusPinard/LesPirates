package carte;

public class Carte {
	
	protected String nom;
	protected String type;
	protected int popu;
	protected int pv;
	protected String description;
	
	public Carte (String nom, String type, int popu, int pv, String description) {
		this.nom=nom;
		this.type=type;
		this.popu=popu;
		this.pv=pv;
		this.description=description;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getType() {
		return this.type ;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public int getPopularite() {
		return this.popu;
	}
	
	public int getPV() {
		return this.popu;
	}
}
