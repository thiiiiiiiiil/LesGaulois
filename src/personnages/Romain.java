package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
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

		return "Le romain" + nom + " : ";
	}
	private void frapper(Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + "envoi un grand coup dans la mâchoire de" + nomRomain);
		int forceCoup = force / 3;
		romain.recevoirCoup(forceCoup);
	}
	public void recevoirCoup( int forceCoup) {
		force = force - forceCoup;
		if (force<1) {
			force=0;
					parler("J'abandonne !");
		}else {
			parler("Aie");
		}
		
	}
	
}
