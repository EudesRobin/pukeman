package Automate;

/**
 * Classe représentant les automates des différents personnages selon la
 * difficulté
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Automate {

	private String nom;
	private EtatList etats;
	private TransitionList transitions;

	public Etat etat_depart;
	private EtatList etats_finaux;

	public Automate(String nom_a, EtatList el, TransitionList tl,
			Etat etat_depart2, EtatList el_f) {
		this.nom = nom_a;
		this.etat_depart = etat_depart2;
		this.transitions = tl;
		this.etats = el;
		this.etats_finaux = el_f;
	}

	public void afficher_Automate() {
		System.out.println("Automate " + nom);
		System.out.println("\nEtat de depart : " + etat_depart.getNom());
		System.out.print("Etats finaux : ");
		etats_finaux.affichernomEtats();

		etats.afficherEtats();
		transitions.afficherTransitions();
	}

	public TransitionList getTransitions() {
		return this.transitions;
	}

	public EtatList getEtats() {
		return this.etats;
	}

}
