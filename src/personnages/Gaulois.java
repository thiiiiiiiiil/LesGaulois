package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {

		return "Le gaulois " + nom + " : ";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);

	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoi un grand coup dans la mâchoire de " + romain.getNom());
		int forceCoup = force / 3;
		romain.recevoirCoup(forceCoup);
		effetPotion--;
		if (effetPotion<1) {
			effetPotion=1;
		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}
	
}
