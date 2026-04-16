package village_gaulois;

import personnages.Gaulois;
import personnages.Chef;
public class Village {

	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;

	public Village(String nom, int nbVillageoisMax, Chef chef) {
		this.nom = nom;
		assert chef != null : "Un village doit avoir un chef";
		this.chef = chef;
		this.chef.setVillage(this);
		this.villageois = new Gaulois[nbVillageoisMax];
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
			gaulois.setVillage(this);
		} else {
			System.out.println("Le village est plein, " + gaulois.getNom() + " ne peut pas s'installer !");
		}
	}

	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois < 1 || numVillageois > nbVillageois) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}

		return villageois[numVillageois - 1];
	}

	public void afficherVillageois() {
		
		System.out.println(
				"Dans le village \"" + nom + "\" du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}

	public static void main(String[] args) {
		Chef chef = new Chef("Abraracourcix", 6);

		Village village = new Village("Village des Irréductibles", 30, chef);
		village.trouverVillageois(30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		if (gaulois != null) {
		    System.out.println(gaulois);
		}
		gaulois = village.trouverVillageois(2);
		if (gaulois != null) {
			System.out.println(gaulois);
		}
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		gaulois = village.trouverVillageois(2);
		if (gaulois != null) {
			System.out.println(gaulois);
		}
		village.afficherVillageois();
		Gaulois doublePolemix = new Gaulois("Doublepolémix", 4);
		System.out.println("--- Présentations ---");
		chef.sePresenter();         
		asterix.sePresenter();      
		doublePolemix.sePresenter();
	}
}
