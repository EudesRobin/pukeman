package Monde.Perso;

import javax.swing.ImageIcon;

import pacman.EnumDifficulte;
import pacman.Global;
import Automate.*;
import Monde.Items.PacGum;
import Monde.Map.*;

/**
 * Classe du Pacman Automatisé
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class PacmanAuto extends Pacman {

	public boolean vul_ft;

	// initialisation du pacman
	public PacmanAuto(int x, int y, int num_joueur) {
		super(x, y, num_joueur);
		vul_ft = false;
	}

	public boolean butvalide() {
		boolean but = false;
		if ((this.obj_x != 0) && (this.obj_y != 0)) {
			if (!(Global.map.carte[this.obj_y / 20][this.obj_x / 20] instanceof Mur)) {
				but = true;
			} else {
				this.obj_x = 0;
				this.obj_y = 0;
				this.clic = false;
				unsetCible(this.num_pacman);
			}
		}
		return but;

	}

	/**
	 * Fin du mode "vers un objectif" des pacman automatiques
	 * 
	 * @param i
	 *            identifiant du pacman
	 */
	public void unsetCible(int i) {
		switch (i) {
		case 2:
			Global.j2.setIcon(new ImageIcon("./img/joueur2.png"));
			break;
		case 3:

			Global.j3.setIcon(new ImageIcon("./img/joueur3.png"));
			break;
		case 4:
			Global.j4.setIcon(new ImageIcon("./img/joueur4.png"));
			break;
		}
	}

	public void evoluer(Comportement cpt) {
		Automate autf = cpt.get_Automate();
		TransitionList tl = autf.getTransitions();
		EtatList el = autf.getEtats();
		String c;
		Etat etat;
		Transition t;
		etat = el.get_state(this.id_etat);
		c = etudieMap();
		t = tl.search_transition(etat, c);
		// System.out.println("Pacman " + this.num_pacman + " " + c);
		if (t != null) {
			//t.afficherTransition();
			t.runActions(this);
			etat = t.getArrivee();
			this.id_etat = etat.getId();
		} else {
			etat.getAction().run(this);
		}
	}

	public String etudieMap() {
		String cl = "";
		if (this.vul_ft == false) {
			// Si on n'a aucun fantôme vulnérable en vue
			if (!(s_fuit.isEmpty())
					&& ((EnumDifficulte.diff == "Moyen") || (EnumDifficulte.diff == "Difficile"))) {
				cl = "Voit Fantome + Invulnerable";
			} else if ((EnumDifficulte.diff == "Difficile") && this.butvalide()) {
				cl = "A un objectif";
			} else {
				cl = "Rien";
			}
		} else {
			if ((EnumDifficulte.diff == "Difficile") && this.butvalide())
				// L'objectif est une priorité
				cl = "A un objectif";

			else if (!(s_fuit.isEmpty())
					&& ((EnumDifficulte.diff == "Moyen") || (EnumDifficulte.diff == "Difficile"))) {
				cl = "Voit Fantome + Vulnerable";
			}
		}
		return cl;
	}

	// renvoie la case du pacgum le plus proche
		public Case chercherPacgum() {
			Case c = null;
			int a = 0;
			int b = 0;
			int max = 2;
			int l = Global.lfenjeu / Global.taille_bloc;
			int h = Global.hfenjeu / Global.taille_bloc;
			while ((max < 102) && (c == null)) {
				a = 0;
				while ((a < max) && (c == null)) {
					b = 0;
					while ((b <= max) && (c == null)) {
						if (((this.y / 20) + (a / 2)) < h
								&& ((this.y / 20) + (a / 2)) >= 0
								&& ((this.x / 20) + (b / 2)) < l
								&& ((this.x / 20) + (b / 2)) >= 0) {
							if (Global.map.carte[(this.y / 20) + (a / 2)][(this.x / 20)
									+ (b / 2)] instanceof Vide) {
								if (((Vide) Global.map.carte[(this.y / 20)
										+ (a / 2)][(this.x / 20) + (b / 2)]).b instanceof PacGum) {
									c = Global.map.carte[(this.y / 20) + (a / 2)][(this.x / 20)
											+ (b / 2)];
								}
							}
						}

						if (((this.y / 20) - (a / 2)) < h
								&& ((this.y / 20) - (a / 2)) >= 0
								&& ((this.x / 20) + (b / 2)) < l
								&& ((this.x / 20) + (b / 2)) >= 0 && (c == null)) {
							if (Global.map.carte[(this.y / 20) - (a / 2)][(this.x / 20)
									+ (b / 2)] instanceof Vide) {
								if (((Vide) Global.map.carte[(this.y / 20)
										- (a / 2)][(this.x / 20) + (b / 2)]).b instanceof PacGum) {
									c = Global.map.carte[(this.y / 20) - (a / 2)][(this.x / 20)
											+ (b / 2)];
								}
							}
						}

						if (((this.y / 20) - (a / 2)) < h
								&& ((this.y / 20) - (a / 2)) >= 0
								&& ((this.x / 20) - (b / 2)) < l
								&& ((this.x / 20) - (b / 2)) >= 0 && (c == null)) {
							if (Global.map.carte[(this.y / 20) - (a / 2)][(this.x / 20)
									- (b / 2)] instanceof Vide) {
								if (((Vide) Global.map.carte[(this.y / 20)
										- (a / 2)][(this.x / 20) - (b / 2)]).b instanceof PacGum) {
									c = Global.map.carte[(this.y / 20) - (a / 2)][(this.x / 20)
											- (b / 2)];
								}
							}
						}
						if (((this.y / 20) + (a / 2)) < h
								&& ((this.y / 20) + (a / 2)) >= 0
								&& ((this.x / 20) - (b / 2)) < l
								&& ((this.x / 20) - (b / 2)) >= 0 && (c == null)) {
							if (Global.map.carte[(this.y / 20) + (a / 2)][(this.x / 20)
									- (b / 2)] instanceof Vide) {
								if (((Vide) Global.map.carte[(this.y / 20)
										+ (a / 2)][(this.x / 20) - (b / 2)]).b instanceof PacGum) {
									c = Global.map.carte[(this.y / 20) + (a / 2)][(this.x / 20)
											- (b / 2)];
								}
							}
						}
						if ((c != null) && (c.x == (this.x / 20))
								&& (c.y == (this.y / 20))) {
							c = null;
						}
						b++;
					}
					a++;
				}
				max++;
			}
			return c;
		}
		
		public void ChoixDirVersPacgum() {
			Case c = null;
			c = chercherPacgum();
			if (c == null) {
				System.out.println("Pas de pacgum ??!! :O \n");
			} else {
				this.ChoixDirVersCase(c);
			}
		}
	
	// Fonctions indiquant si les cases (dans chaque direction) sont valides ou
		// non (avec ou sans paramètres de position)
		public boolean case_haut_valide() {

			if (y / Global.taille_bloc <= 0) {
				return false;
			} else {
				Case a = Global.map.carte[((this.y) / Global.taille_bloc) - 1][this.x
						/ Global.taille_bloc];
				return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
						.etatporte()) || (((a) instanceof Vide) && ((Vide)a).danger));
			}
		}

		public boolean case_bas_valide() {

			if (y / Global.taille_bloc >= ((Global.hfenjeu / 20) - 1)) {
				return false;
			} else {
				Case a = Global.map.carte[(this.y / Global.taille_bloc) + 1][this.x
						/ Global.taille_bloc];
				return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
						.etatporte()) || (((a) instanceof Vide) && ((Vide)a).danger));
			}
		}

		public boolean case_droite_valide() {

			if (x / Global.taille_bloc >= ((Global.lfenjeu / 20) - 1)) {
				return false;
			} else {
				Case a = (Global.map.carte[this.y / Global.taille_bloc][((this.x) / Global.taille_bloc) + 1]);
				return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
						.etatporte()) || (((a) instanceof Vide) && ((Vide)a).danger));
			}
		}

		public boolean case_gauche_valide() {

			if (x / Global.taille_bloc <= 0) {
				return false;
			} else {
				Case a = Global.map.carte[this.y / Global.taille_bloc][(this.x)
						/ Global.taille_bloc - 1];
				return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
						.etatporte()) || (((a) instanceof Vide) && ((Vide)a).danger));
			}
		}

		public boolean case_haut_valide(int x, int y) {

			if (y / Global.taille_bloc <= 0) {
				return false;
			} else {
				Case a = Global.map.carte[((y) / Global.taille_bloc) - 1][x
						/ Global.taille_bloc];
				return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
						.etatporte()) || (((a) instanceof Vide) && ((Vide)a).danger));
			}
		}

		public boolean case_bas_valide(int x, int y) {

			if (y / Global.taille_bloc >= ((Global.hfenjeu / 20) - 1)) {
				return false;
			} else {
				Case a = Global.map.carte[(y / Global.taille_bloc) + 1][x
						/ Global.taille_bloc];
				return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
						.etatporte()) || (((a) instanceof Vide) && ((Vide)a).danger));
			}
		}

		public boolean case_droite_valide(int x, int y) {

			if (x / Global.taille_bloc >= ((Global.lfenjeu / 20) - 1)) {
				return false;
			} else {
				Case a = Global.map.carte[y / Global.taille_bloc][((x) / Global.taille_bloc) + 1];
				return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
						.etatporte()) || (((a) instanceof Vide) && ((Vide)a).danger));
			}
		}

		public boolean case_gauche_valide(int x, int y) {

			if (x / Global.taille_bloc <= 0) {
				return false;
			} else {
				Case a = Global.map.carte[y / Global.taille_bloc][(x)
						/ Global.taille_bloc - 1];
				return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
						.etatporte()) || (((a) instanceof Vide) && ((Vide)a).danger));
			}
		}
}
