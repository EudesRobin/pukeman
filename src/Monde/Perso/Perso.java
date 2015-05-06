package Monde.Perso;

import java.util.ArrayList;
import java.util.Random;

import Monde.Map.*;
import pacman.*;

public abstract class Perso {
	public int x;
	public int y;
	public Direction d;
	public int id_etat;
	public CaseList s_fuit;
	public Direction dir_perso_vu;

	public Perso(int x, int y, Direction d) {
		this.x = x;
		this.y = y;
		this.d = d;
		/*if (this instanceof PacmanJoueur)
			id_etat = Ordonnanceur.cl.get("PM").get_Automate().etat_depart
					.getId();
		else if (this instanceof PacmanAuto)
			id_etat = Ordonnanceur.cl.get(Ordonnanceur.pacauto).get_Automate().etat_depart
					.getId();
		else
			id_etat = Ordonnanceur.cl.get(Ordonnanceur.fantomes).get_Automate().etat_depart
					.getId();*/
		id_etat = 0;
		s_fuit = new CaseList();
		this.dir_perso_vu = Direction.Null;
	}

	// Teleporte a le meme role que init_pos
	public void teleporte(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void DemiTour() {
		if (d == Direction.Haut) {
			d = Direction.Bas;
		} else if (d == Direction.Bas) {
			d = Direction.Haut;
		} else if (d == Direction.Droite) {
			d = Direction.Gauche;
		} else if (d == Direction.Gauche) {
			d = Direction.Droite;
		}
	}

	public void ChoixDir() {
		ArrayList<Direction> list;
		list = new ArrayList<Direction>();
		if (d != Direction.Bas & case_haut_valide()) {
			list.add(Direction.Haut);
		}
		if (d != Direction.Haut & case_bas_valide()) {
			list.add(Direction.Bas);
		}
		if (d != Direction.Gauche & case_droite_valide()) {
			list.add(Direction.Droite);
		}
		if (d != Direction.Droite & case_gauche_valide()) {
			list.add(Direction.Gauche);
		}

		if (list.isEmpty()) {
			this.DemiTour();
		} else {
			Random rand = new Random();
			int nb = rand.nextInt(list.size());
			d = list.get(nb);
		}

	}

	public void chercher_echappatoire() {

	}

	/*
	 * renvoie le nombre de case entre le personnage et l'échappatoire en haut
	 * si il y en a une , sinon renvoie un chiffre negatif
	 */
	public int echappatoire_haut() {
		int p = -1;
		int persotrouve = 0;
		int i;
		i = 0;
		while (case_haut_valide(this.x, (this.y) - (i * 20))
				&& (persotrouve == 0) && (p == -1)) {
			if (this instanceof Pacman) {
				if (contact_avec_fantome(this.x, (this.y) - (i * 20) - 1)) {
					persotrouve = 1;
				}
			} else {
				if (contact_avec_pacman(this.x, (this.y) - (i * 20) - 1)) {
					persotrouve = 1;
				}
			}
			if (persotrouve != 1) {
				if ((case_gauche_valide(this.x, (this.y) - (i * 20)))
						|| (case_droite_valide(this.x, (this.y) - (i * 20)))) {
					p = i;
				}
				i++;
			}
		}
		return p;
	}

	/*
	 * renvoie le nombre de case entre le personnage et l'échappatoire en bas si
	 * il y en a une , sinon renvoie un chiffre negatif
	 */
	public int echappatoire_bas() {
		int p = -1;
		int i;
		int persotrouve = 0;
		i = 0;
		while (case_bas_valide(this.x, (this.y) + (i * 20))
				&& (persotrouve == 0) && (p == -1)) {

			if (this instanceof Pacman) {
				if (contact_avec_fantome(this.x, (this.y) + (i * 20) + 1)) {
					persotrouve = 1;
				}
			} else {
				if (contact_avec_pacman(this.x, (this.y) + (i * 20) + 1)) {
					persotrouve = 1;
				}
			}
			if (persotrouve != 1) {
				if (case_gauche_valide(this.x, (this.y) + (i * 20))
						|| case_droite_valide(this.x, (this.y) + (i * 20))) {
					p = i;
				}
				i++;
			}
		}
		return p;
	}

	/*
	 * renvoie le nombre de case entre le personnage et l'échappatoire en gauche
	 * si il y en a une , sinon renvoie un chiffre negatif
	 */
	public int echappatoire_gauche() {
		int p = -1;
		int i;
		int persotrouve = 0;
		i = 0;
		while (case_gauche_valide((this.x) - (i * 20), this.y)
				&& (persotrouve == 0) && (p == -1)) {
			if (this instanceof Pacman) {
				if (contact_avec_fantome((this.x) - (i * 20) - 1, this.y)) {
					persotrouve = 1;
				}
			} else {
				if (contact_avec_pacman((this.x) - (i * 20) - 1, this.y)) {
					persotrouve = 1;
				}
			}
			if (persotrouve != 1) {
				if (case_haut_valide((this.x) - (i * 20), this.y)
						|| case_bas_valide((this.x) - (i * 20), this.y)) {
					p = i;
				}
				i++;
			}
		}
		return p;
	}

	/*
	 * renvoie le nombre de case entre le personnage et l'échappatoire en droite
	 * si il y en a une , sinon renvoie un chiffre negatif
	 */
	public int echappatoire_droite() {
		int p = -1;
		int i;
		int persotrouve = 0;
		i = 0;
		while (case_droite_valide((this.x) + (i * 20), this.y)
				&& (persotrouve == 0) && (p == -1)) {
			if (this instanceof Pacman) {
				if (contact_avec_fantome((this.x) + (i * 20) + 1, this.y)) {
					persotrouve = 1;
				}
			} else {
				if (contact_avec_pacman((this.x) + (i * 20) + 1, this.y)) {
					persotrouve = 1;
				}
			}
			if (persotrouve != 1) {
				if (case_haut_valide((this.x) + (i * 20), this.y)
						|| case_bas_valide((this.x) + (i * 20), this.y)) {
					p = i;
				}
				i++;

			}
		}
		return p;
	}

	public void ChoixDirFuite_niv2() {
		int a, b;
		ArrayList<Direction> list;
		list = new ArrayList<Direction>();
		Case casetest;
		DirectionList bla;
		if ((this instanceof Fantome) || (this instanceof PacmanAuto)) {
			int cpp = 0;
			for (int i = 1; i < this.s_fuit.size(); i++) {
				int dist = this.dist_case(this.s_fuit.get(cpp));
				int test = this.dist_case(this.s_fuit.get(i));
				if (test < dist)
					cpp = i;
			}
			if (!this.s_fuit.isEmpty()) {
				casetest = this.s_fuit.get(cpp);
				bla = this.get_dir(casetest);
				if (!bla.isEmpty()) {
					this.dir_perso_vu = bla.get(0);
				} else
					System.out.println("Bla de ChoixDirFuite2 est vide");
			} else
				System.out.println("s_fuit de ChoixDirFuite2 est vide");

		}
		if ((dir_perso_vu == Direction.Haut) || (dir_perso_vu == Direction.Bas)) {
			a = echappatoire_haut();
			b = echappatoire_bas();
			if ((a == -1) && (b == -1)) {
				this.DemiTour();
			} else {
				if ((b == 0) || (a == 0)) {
					if (d != Direction.Gauche & (case_droite_valide())
							&& (dir_perso_vu != Direction.Droite)) {
						list.add(Direction.Droite);
					}
					if (d != Direction.Droite & (case_gauche_valide())
							&& (dir_perso_vu != Direction.Gauche)) {
						list.add(Direction.Gauche);
					}
					if (list.isEmpty()) {
						this.DemiTour();
					} else {
						Random rand = new Random();
						int nb = rand.nextInt(list.size());
						d = list.get(nb);
					}
				} else {
					if ((a==-1) || ((b!=-1)&&(b<a))) {
						d = Direction.Bas;
					} else if ((b == -1) || (a <= b)) {
						d = Direction.Haut;
					}
				}
			}
		} else if ((dir_perso_vu == Direction.Gauche)
				|| (dir_perso_vu == Direction.Droite)) {
			a = echappatoire_gauche();
			b = echappatoire_droite();
			if ((a == -1) && (b == -1)) {
				this.DemiTour();
			} else {
				if ((b == 0) || (a == 0)) {
					if (d != Direction.Haut & (case_bas_valide())
							&& (dir_perso_vu != Direction.Bas)) {
						list.add(Direction.Bas);
					}
					if (d != Direction.Bas & (case_haut_valide())
							&& (dir_perso_vu != Direction.Haut)) {
						list.add(Direction.Haut);
					}
					if (list.isEmpty()) {
						this.DemiTour();
					} else {
						Random rand = new Random();
						int nb = rand.nextInt(list.size());
						d = list.get(nb);
					}
				} else {
					if ((a==-1) || ((b!=-1)&&(b<a))) {
						d = Direction.Droite;
					} else if ((b == -1) || (a <= b)) {
						d = Direction.Gauche;
					}
				}
			}
		}
	}

	public void ChoixDirFuite() {
		ArrayList<Direction> list;
		list = new ArrayList<Direction>();
		Case casetest;
		DirectionList bla;
		if ((this instanceof Fantome) || (this instanceof PacmanAuto)) {
			int cpp = 0;
			for (int i = 1; i < this.s_fuit.size(); i++) {
				int dist = this.dist_case(this.s_fuit.get(cpp));
				int test = this.dist_case(this.s_fuit.get(i));
				if (test < dist)
					cpp = i;
			}
			if (!this.s_fuit.isEmpty()) {
				casetest = this.s_fuit.get(cpp);
				bla = this.get_dir(casetest);
				if (!bla.isEmpty()) {
					this.dir_perso_vu = bla.get(0);
				} else
					System.out.println("Bla dans Fuiteniv1 est vide");
			} else
				System.out.println("s_fuit dans Fuiteniv1 est vide");
		}
		if (d != Direction.Bas & (case_haut_valide())
				&& (dir_perso_vu != Direction.Haut)) {
			list.add(Direction.Haut);

		}
		if (d != Direction.Haut & (case_bas_valide())
				&& (dir_perso_vu != Direction.Bas)) {
			list.add(Direction.Bas);

		}
		if (d != Direction.Gauche & (case_droite_valide())
				&& (dir_perso_vu != Direction.Droite)) {
			list.add(Direction.Droite);

		}
		if (d != Direction.Droite & (case_gauche_valide())
				&& (dir_perso_vu != Direction.Gauche)) {
			list.add(Direction.Gauche);

		}

		if (list.isEmpty()) {
			if (((dir_perso_vu == Direction.Haut) && (dir_perso_vu == Direction.Bas))
					|| ((dir_perso_vu == Direction.Gauche) && (dir_perso_vu == Direction.Droite))) {
				chercher_echappatoire();
			} else {
				this.DemiTour();
			}
		} else {
			Random rand = new Random();
			int nb = rand.nextInt(list.size());
			d = list.get(nb);
		}
	}

	public boolean perso_vu_haut() {
		boolean p = false;
		int i, j;
		i = 0;
		while ((case_haut_valide(this.x, (this.y) - (i * 20))) && (p == false)) {
			if (this instanceof Fantome) {
				for (j = 0; j < Global.nb_pacmen + Global.nbjoueurs; j++) {
					if (((this.x) / 20 == (Global.map.pacmen[j].x) / 20)
							&& ((((this.y) / 20) - i - 1) == (Global.map.pacmen[j].y) / 20)
							&& !Global.map.pacmen[j].invisible) {
						p = true;
						s_fuit.add(Global.map.carte[(y / 20) - i - 1][x / 20]);
						// System.out.println("PM vu haut");
					}
				}
			} else {
				for (j = 0; j < Global.nb_fantomes; j++) {
					if (((this.x) / 20 == (Global.map.fantomes[j].x) / 20)
							&& ((((this.y) / 20) - i - 1) == (Global.map.fantomes[j].y) / 20)) {
						p = true;
						s_fuit.add(Global.map.carte[(y / 20) - i - 1][x / 20]);
						if (Global.map.fantomes[j].nb_tour_vulnerable != 0) {
							((PacmanAuto) this).vul_ft = true;
						}
						// System.out.println("FT vu haut");
					}
				}
			}

			i++;
		}
		return p;
	}

	public boolean perso_vu_bas() {
		boolean p = false;
		int i, j;
		i = 0;
		while ((case_bas_valide(this.x, (this.y) + (i * 20))) && (p == false)) {
			if (this instanceof Fantome) {
				for (j = 0; j < Global.nb_pacmen + Global.nbjoueurs; j++) {
					if (((this.x) / 20 == (Global.map.pacmen[j].x) / 20)
							&& ((((this.y) / 20) + i + 1) == (Global.map.pacmen[j].y) / 20)
							&& !Global.map.pacmen[j].invisible) {
						p = true;
						s_fuit.add(Global.map.carte[(y / 20) + 1 + i][x / 20]);
						// System.out.println("PM vu bas");
					}
				}
			} else {
				for (j = 0; j < Global.nb_fantomes; j++) {
					if (((this.x) / 20 == (Global.map.fantomes[j].x) / 20)
							&& ((((this.y) / 20) + i + 1) == (Global.map.fantomes[j].y) / 20)) {
						p = true;
						s_fuit.add(Global.map.carte[(y / 20) + i + 1][x / 20]);
						if (Global.map.fantomes[j].nb_tour_vulnerable != 0) {
							((PacmanAuto) this).vul_ft = true;
						}
						// System.out.println("FT vu bas");
					}
				}
			}

			i++;
		}
		return p;
	}

	public boolean perso_vu_gauche() {
		boolean p = false;
		int i, j;
		i = 0;
		while ((case_gauche_valide((this.x) - (i * 20), this.y))
				&& (p == false)) {
			if (this instanceof Fantome) {
				for (j = 0; j < Global.nb_pacmen + Global.nbjoueurs; j++) {
					if (((((this.x) / 20) - i - 1) == (Global.map.pacmen[j].x) / 20)
							&& ((this.y) / 20 == (Global.map.pacmen[j].y) / 20)
							&& !Global.map.pacmen[j].invisible) {
						p = true;
						s_fuit.add(Global.map.carte[y / 20][(x / 20) - 1 - i]);
						// System.out.println("PM vu g");
					}
				}
			} else {
				for (j = 0; j < Global.nb_fantomes; j++) {
					if (((((this.x) / 20) - i - 1) == (Global.map.fantomes[j].x) / 20)
							&& ((this.y) / 20 == (Global.map.fantomes[j].y) / 20)) {
						p = true;
						s_fuit.add(Global.map.carte[y / 20][(x / 20) - 1 - i]);
						if (Global.map.fantomes[j].nb_tour_vulnerable != 0) {
							((PacmanAuto) this).vul_ft = true;
						}
						// System.out.println("FT vu g");
					}
				}
			}

			i++;
		}
		return p;
	}

	public boolean perso_vu_droite() {
		boolean p = false;
		int i, j;
		i = 0;
		while ((case_droite_valide((this.x) + (i * 20), this.y))
				&& (p == false)) {
			if (this instanceof Fantome) {
				for (j = 0; j < Global.nb_pacmen + Global.nbjoueurs; j++) {
					if ((((this.x / 20) + i + 1) == (Global.map.pacmen[j].x) / 20)
							&& ((this.y) / 20 == (Global.map.pacmen[j].y) / 20)
							&& !Global.map.pacmen[j].invisible) {
						p = true;
						s_fuit.add(Global.map.carte[y / 20][(x / 20) + i + 1]);
						// System.out.println("PM vu d");
					}
				}
			} else {
				for (j = 0; j < Global.nb_fantomes; j++) {
					if ((((this.x / 20) + i + 1) == (Global.map.fantomes[j].x) / 20)
							&& ((this.y) / 20 == (Global.map.fantomes[j].y) / 20)) {
						p = true;
						s_fuit.add(Global.map.carte[y / 20][(x / 20) + i + 1]);
						if (Global.map.fantomes[j].nb_tour_vulnerable != 0) {
							((PacmanAuto) this).vul_ft = true;
						}
						// System.out.println("FT vu d");
					}
				}
			}
			i++;
		}
		return p;
	}

	/**
	 * Permet de faire avancer le personnage en fonction de sa direction si
	 * c'est possible et de gérer le tore dans le cas où c'est nécessaire
	 */
	public void avancer_case() {
		int newx = this.x;
		int newy = this.y;
		if (d == Direction.Haut && this.case_haut_valide()) {
			newy = (this.y - Global.pas * Global.taille_bloc);
			if (newy <= 0) {
				this.y = Global.hfenjeu - 2 * Global.taille_bloc;
				return;
			}

			this.y = newy;

		} else if (d == Direction.Bas && this.case_bas_valide()) {
			newy = (this.y + Global.pas * Global.taille_bloc);
			if (newy >= (Global.hfenjeu - Global.taille_bloc)) {
				this.y = Global.taille_bloc;
				return;
			}

			this.y = newy;

		} else if (d == Direction.Droite && this.case_droite_valide()) {
			newx = (this.x + Global.pas * Global.taille_bloc);
			if (newx >= (Global.lfenjeu - Global.taille_bloc)) {
				this.x = Global.taille_bloc;
				return;
			}

			this.x = newx;

		} else if (d == Direction.Gauche && this.case_gauche_valide()) {
			newx = (this.x - Global.pas * Global.taille_bloc);
			if (newx <= 0) {
				this.x = Global.lfenjeu - 2 * Global.taille_bloc;
				return;
			}
			this.x = newx;
		}
	}

	/**
	 * Meme role que avancer, mais d'une demi case seulement
	 */
	public void avancer_demie_case() {
		int newx = this.x;
		int newy = this.y;
		if (d == Direction.Haut) {
			newy = (this.y - Global.pas * Global.taille_bloc / 2);
			if (newy <= 0) {
				this.y = Global.hfenjeu - 2 * Global.taille_bloc;
				return;
			}
			this.y = newy;

		} else if (d == Direction.Bas) {
			newy = (this.y + Global.pas * Global.taille_bloc / 2);
			if (newy >= (Global.hfenjeu - Global.taille_bloc)) {
				this.y = Global.taille_bloc;
				return;
			}

			this.y = newy;

		} else if (d == Direction.Droite) {
			newx = (this.x + Global.pas * Global.taille_bloc / 2);
			if (newx >= (Global.lfenjeu - Global.taille_bloc)) {
				this.x = Global.taille_bloc;
				return;
			}

			this.x = newx;

		} else if (d == Direction.Gauche) {
			newx = (this.x - Global.pas * Global.taille_bloc / 2);
			if (newx <= 0) {
				this.x = Global.lfenjeu - 2 * Global.taille_bloc;
				return;
			}
			this.x = newx;
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
					.etatporte()));
		}
	}

	public boolean case_bas_valide() {

		if (y / Global.taille_bloc >= ((Global.hfenjeu / 20) - 1)) {
			return false;
		} else {
			Case a = Global.map.carte[(this.y / Global.taille_bloc) + 1][this.x
					/ Global.taille_bloc];
			return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
					.etatporte()));
		}
	}

	public boolean case_droite_valide() {

		if (x / Global.taille_bloc >= ((Global.lfenjeu / 20) - 1)) {
			return false;
		} else {
			Case a = (Global.map.carte[this.y / Global.taille_bloc][((this.x) / Global.taille_bloc) + 1]);
			return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
					.etatporte()));
		}
	}

	public boolean case_gauche_valide() {

		if (x / Global.taille_bloc <= 0) {
			return false;
		} else {
			Case a = Global.map.carte[this.y / Global.taille_bloc][(this.x)
					/ Global.taille_bloc - 1];
			return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
					.etatporte()));
		}
	}

	public boolean case_haut_valide(int x, int y) {

		if (y / Global.taille_bloc <= 0) {
			return false;
		} else {
			Case a = Global.map.carte[((y) / Global.taille_bloc) - 1][x
					/ Global.taille_bloc];
			return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
					.etatporte()));
		}
	}

	public boolean case_bas_valide(int x, int y) {

		if (y / Global.taille_bloc >= ((Global.hfenjeu / 20) - 1)) {
			return false;
		} else {
			Case a = Global.map.carte[(y / Global.taille_bloc) + 1][x
					/ Global.taille_bloc];
			return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
					.etatporte()));
		}
	}

	public boolean case_droite_valide(int x, int y) {

		if (x / Global.taille_bloc >= ((Global.lfenjeu / 20) - 1)) {
			return false;
		} else {
			Case a = Global.map.carte[y / Global.taille_bloc][((x) / Global.taille_bloc) + 1];
			return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
					.etatporte()));
		}
	}

	public boolean case_gauche_valide(int x, int y) {

		if (x / Global.taille_bloc <= 0) {
			return false;
		} else {
			Case a = Global.map.carte[y / Global.taille_bloc][(x)
					/ Global.taille_bloc - 1];
			return !((a instanceof Mur) || (((a) instanceof Porte) && !((Porte) a)
					.etatporte()));
		}
	}

	/**
	 * Indique si le perso actuel a croisé le pacman i
	 * 
	 * @param i
	 *            Numéro de pacman dont le croisement est à tester
	 * @param x
	 *            Abscisse du perso actuel
	 * @param y
	 *            Ordonnée du perso actuel
	 * @return true si le pacman i a échangé ses positions avec le perso actuel,
	 *         false sinon
	 */
	private boolean Croisement_pacman(int i, int x, int y) {
		if (d == Direction.Haut) {
			return Global.map.pacmen[i].x / 20 == x / 20
					&& Global.map.pacmen[i].y / 20 == y / 20 + 1
					&& Global.map.pacmen[i].d == Direction.Bas;
		}
		if (d == Direction.Bas) {
			return Global.map.pacmen[i].x / 20 == x / 20
					&& Global.map.pacmen[i].y / 20 == y / 20 - 1
					&& Global.map.pacmen[i].d == Direction.Haut;
		}
		if (d == Direction.Droite) {
			return Global.map.pacmen[i].x / 20 == x / 20 - 1
					&& Global.map.pacmen[i].y / 20 == y / 20
					&& Global.map.pacmen[i].d == Direction.Gauche;
		}
		if (d == Direction.Gauche) {
			return Global.map.pacmen[i].x / 20 == x / 20 + 1
					&& Global.map.pacmen[i].y / 20 == y / 20
					&& Global.map.pacmen[i].d == Direction.Droite;
		}
		return true;
	}

	public boolean contact_avec_fantome(int x, int y) {
		int i;
		boolean p = false;
		for (i = 0; i < Global.map.fantomes.length; i++) {
			if ((((Global.map.fantomes[i].x) / 20) == (x / 20))
					&& (((Global.map.fantomes[i].y) / 20) == (y / 20))) {
				p = true;
			}
		}
		return p;
	}

	/**
	 * @return res=numéro du premier pacman avec lequel il y a eu contact, -1
	 *         sinon
	 */
	public int contact_avec_pacman() {
		int i, res = -1;
		for (i = 0; i < Global.map.pacmen.length; i++) {
			if (((((Global.map.pacmen[i].x) / 20) == (x / 20)) && (((Global.map.pacmen[i].y) / 20) == (y / 20)))
					|| Croisement_pacman(i, x, y)) {
				res = i;
			}
		}
		return res;
	}

	public boolean contact_avec_pacman(int x, int y) {
		int i;
		boolean p = false;
		for (i = 0; i < Global.map.pacmen.length; i++) {
			if ((((Global.map.pacmen[i].x) / 20) == (x / 20))
					&& (((Global.map.pacmen[i].y) / 20) == (y / 20))) {
				p = true;
			}
		}
		return p;
	}

	public void ChoixDirChassePersoVu(Case c) {
		DirectionList list;
		list = this.get_dir(c);
		if (list.isEmpty()) {
			ChoixDir();
		} else {
			Random rand = new Random();
			int nb = rand.nextInt(list.size());
			d = list.get(nb);
		}
	}

	public int dist_case(Case c) {
		int difx = this.x - c.x;
		if (difx < 0)
			difx = difx * -1;
		int dify = this.y - c.y;
		if (dify < 0)
			dify = dify * -1;
		return difx + dify;
	}

	public DirectionList get_dir(Case c) {
		DirectionList list = new DirectionList();

		if ((((this.x) / 20) < c.x) && case_droite_valide()) {
			list.add(Direction.Droite);
		}
		if ((((this.x) / 20) > c.x) && case_gauche_valide()) {
			list.add(Direction.Gauche);
		}
		if ((((this.y) / 20) < c.y) && case_bas_valide()) {
			list.add(Direction.Bas);
		}
		if ((((this.y) / 20) > c.y) && case_haut_valide()) {
			list.add(Direction.Haut);
		}

		return list;
	}

	public DirectionList get_dir(int x, int y) {
		DirectionList list = new DirectionList();
		if ((((this.x) / 20) < x / 20) && case_droite_valide()) {
			list.add(Direction.Droite);
		}
		if ((((this.x) / 20) > x / 20) && case_gauche_valide()) {
			list.add(Direction.Gauche);
		}
		if ((((this.y) / 20) < y / 20) && case_bas_valide()) {
			list.add(Direction.Bas);
		}
		if ((((this.y) / 20) > y / 20) && (case_haut_valide())) {
			System.out.println("Ici");
			list.add(Direction.Haut);
		}

		return list;
	}

	public void majList() {
		if (this instanceof PacmanAuto)
			((PacmanAuto) this).vul_ft = false;
		this.s_fuit.vide();
		this.perso_vu_haut();
		this.perso_vu_bas();
		this.perso_vu_gauche();
		this.perso_vu_droite();
	}

	

	public void ChoixDirVersCase(Case c) {
		ArrayList<Direction> list;
		list = new ArrayList<Direction>();
		if ((((this.x) / 20) < (c.x)) && d != Direction.Gauche
				&& case_droite_valide()) {
			list.add(Direction.Droite);
		}
		if ((((this.x) / 20) >= (c.x)) && d != Direction.Droite
				&& case_gauche_valide()) {
			list.add(Direction.Gauche);
		}
		if ((((this.y) / 20) < (c.y)) && d != Direction.Haut
				&& case_bas_valide()) {
			list.add(Direction.Bas);
		}
		if ((((this.y) / 20) >= (c.y)) && d != Direction.Bas
				&& case_haut_valide()) {
			list.add(Direction.Haut);
		}
		if (list.isEmpty()) {
			ChoixDir();
		} else {
			Random rand = new Random();
			int nb = rand.nextInt(list.size());
			d = list.get(nb);
		}
	}

	
}
