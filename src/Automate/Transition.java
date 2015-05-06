package Automate;

import Actions.ActionList;
import Monde.Perso.Perso;

/**
 * Transition pour passer d'un état à l'autre
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Transition {
	private Etat depart;
	private Etat arrivee;
	private String conditions;
	private ActionList actions;

	public Transition(Etat depart, String condition, Etat arrivee, ActionList as) {
		this.depart = depart;
		this.arrivee = arrivee;
		this.conditions = condition;
		this.actions = as;
	}

	public void afficherTransition() {
		System.out.print("Depart : " + depart.getNom() + " ; Arrivee : "
				+ arrivee.getNom() + " ; ");
		System.out.print("Condition : " + conditions + " ; ");
		actions.afficherActions();
		System.out.println();
	}

	public Etat getDepart() {
		return depart;
	}

	public Etat getArrivee() {
		return arrivee;
	}

	public String getCondition() {
		return conditions;
	}

	public void runActions(Perso p) {
		actions.run(p);
	}

}
