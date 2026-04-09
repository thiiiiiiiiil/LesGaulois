package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified() : "Erreur!";
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println("Testez classique");
		minus.recevoirCoup(2);
		
		System.out.println("Testez avec Minus");
		minus.recevoirCoup(-2);
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");

	}

	private String prendreParole() {

		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0 : "Précondition";
		int forceAvantCoup = force;
		force = force - forceCoup;
		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aie");
		}
		assert force < forceAvantCoup : "Postcondition";
		assert isInvariantVerified() : "Erreur: la force est negative!";

	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

}
