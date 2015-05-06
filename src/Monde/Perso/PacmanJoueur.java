package Monde.Perso;

import Automate.*;

/**
 * Classe des Pacman joueurs
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class PacmanJoueur extends Pacman {

	public Direction attente;
	public boolean corner;

	// initialisation du pacman
	public PacmanJoueur(int x, int y, int num_joueur) {
		super(x, y, num_joueur);
		corner = false;
		this.attente = Direction.Null;
	}

	public void ChangerDir() {
		if ((attente != Direction.Null) && this.peut_tourner()) {

			if ((attente == Direction.Bas) && super.case_bas_valide()) {
				super.d = Direction.Bas;
				attente = Direction.Null;
			} else if ((attente == Direction.Haut) && super.case_haut_valide()) {
				super.d = Direction.Haut;
				attente = Direction.Null;
			} else if ((attente == Direction.Droite)
					&& super.case_droite_valide()) {
				super.d = Direction.Droite;
				attente = Direction.Null;
			} else if ((attente == Direction.Gauche)
					&& super.case_gauche_valide()) {
				super.d = Direction.Gauche;
				attente = Direction.Null;
			}
			corner = false;
		}
	}

	public boolean peut_tourner() {
		boolean peut = false;

		if ((this.attente == Direction.Haut) && (this.case_haut_valide())) {
			peut = true;
		} else if ((this.attente == Direction.Bas) && (this.case_bas_valide())) {
			peut = true;
		} else if ((this.attente == Direction.Droite)
				&& (this.case_droite_valide())) {
			peut = true;
		} else if ((this.attente == Direction.Gauche)
				&& (this.case_gauche_valide())) {
			peut = true;
		}

		return peut;
	}

	public void evoluer(Comportement cpt) {
		Automate autf = cpt.get_Automate();
		TransitionList tl = autf.getTransitions();
		EtatList el = autf.getEtats();
		String c;
		Etat etat;
		Transition t;
		etat = el.get_state(id_etat);
		c = etudieMap();
		t = tl.search_transition(etat, c);
		if (t != null) {
			t.runActions(this);
			etat = t.getArrivee();
			id_etat = etat.getId();
		} else {
			etat.getAction().run(this);
		}
	}

	public String etudieMap() {
		String cl = "";
		return cl;
	}
}