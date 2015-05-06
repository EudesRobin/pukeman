package Automate;

import Actions.Action;

/**
 * Représente un état
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */
public class Etat {
	private int id;
	private String nom;
	private Action action;

	public Etat(int id, String nom, Action ac) {
		this.id = id;
		this.nom = nom;
		this.action = ac;
	}

	public boolean equals(Etat e) {
		return this.id == e.getId();
	}

	public String get_Etat() {
		return "\nIdentifiant : " + id + " ; Nom : " + nom;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public Action getAction() {
		return action;
	}

}
