package Monde.Map;

import pacman.EnumDifficulte;
import pacman.Global;
import Monde.Items.*;
import Monde.Perso.*;

/**
 * Matrice représentant la carte et contenant les personnages et les objets
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Matrice {

	public Case[][] carte;
	public Pacman[] pacmen;
	public Fantome[] fantomes;;
	private init init1, init2, init3, init4;

	private class init {
		int x;
		int y;
		Direction d;

		public init(int x, int y, Direction d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	private int l, h;

	/**
	 * Initialise la carte en mettant chaque case soit à Vide sans bonus soit à Vide avec PacGum
	 * Initialise les persos
	 */
	public Matrice() {
		this.l = Global.lfenjeu / Global.taille_bloc;
		this.h = Global.hfenjeu / Global.taille_bloc;
		this.init_persos();

		this.carte = new Case[h][l];
		int i, j;
		for (i = 0; i < h; i++) {
			for (j = 0; j < l; j++) {
				this.carte[i][j] = new Vide();
			}
		}
		if (EnumDifficulte.diff == "Moyen"
				|| EnumDifficulte.diff == "Difficile") {
			for (i = 1; i < h - 1; i++) {
				for (j = 1; j < l - 1; j++) {
					((Vide) this.carte[i][j]).b = new PacGum();
				}
			}
			for (i = 6; i < 26; i++) {
				for (j = 21; j < 30; j++) {
					this.carte[i][j] = new Vide();
				}
			}
		} else {
			for (i = 6; i < 26; i++) {
				for (j = 16; j < 33; j++) {
					((Vide) this.carte[i][j]).b = new PacGum();
				}
			}
		}

	}

	/**
	 * Initialise et remplit les tableaux de persos à leurs positions initiales
	 */
	public void init_persos() {
		int i;
		pacmen = new Pacman[Global.nb_pacmen + Global.nbjoueurs];
		fantomes = new Fantome[Global.nb_fantomes];
		init_pacman();
		for (i = 0; i < Global.nb_fantomes; i++) {
			init_fantome(i);
		}
	}

	/**
	 * Initialise le pacman i à sa position initiale
	 * 
	 * @param i
	 *            Numéro de pacman
	 */
	public void init_pacman() {
		if (EnumDifficulte.diff == "Moyen"
				|| EnumDifficulte.diff == "Difficile") {
			init1 = new init(4 * Global.taille_bloc, (h / 4 - 1)
					* Global.taille_bloc, Direction.Droite);
			init2 = new init((l - 5) * Global.taille_bloc, (h / 4 - 1)
					* Global.taille_bloc, Direction.Gauche);
			init3 = new init(4 * Global.taille_bloc, (3 * h / 4 - 1)
					* Global.taille_bloc, Direction.Droite);
			//init4 = new init((l - 4) * Global.taille_bloc, (3 * h / 4 - 1)
			//		* Global.taille_bloc, Direction.Gauche);
			init4 = new init((l - 5) * Global.taille_bloc, (3 * h / 4 - 1)
					* Global.taille_bloc, Direction.Gauche);
		} else {
			init1 = new init(((l / 2) - 5) * Global.taille_bloc, (h / 4 - 1)
					* Global.taille_bloc, Direction.Gauche);
			init2 = new init(((l / 2) - 2 + 5) * Global.taille_bloc,
					(h / 4 - 1) * Global.taille_bloc, Direction.Droite);
			init3 = new init(((l / 2) - 5) * Global.taille_bloc,
					(3 * h / 4 - 1) * Global.taille_bloc, Direction.Gauche);
			init4 = new init(((l / 2) + 7) * Global.taille_bloc,
					(3 * h / 4 - 1) * Global.taille_bloc, Direction.Droite);

		}

		switch (Global.nbjoueurs) {
		case 2:
			pacmen[0] = new PacmanJoueur(init1.x, init1.y, 1);
			pacmen[0].d = init1.d;
			pacmen[1] = new PacmanJoueur(init2.x, init2.y, 2);
			pacmen[1].d = init2.d;
			pacmen[2] = new PacmanAuto(init3.x, init3.y, 3);
			pacmen[2].d = init3.d;
			pacmen[3] = new PacmanAuto(init3.x, init3.y, 4);
			pacmen[3].d = init4.d;
			break;
		case 1:
			pacmen[0] = new PacmanJoueur(init1.x, init1.y, 1);
			pacmen[0].d = init1.d;
			pacmen[1] = new PacmanAuto(init2.x, init2.y, 2);
			pacmen[1].d = init2.d;
			pacmen[2] = new PacmanAuto(init3.x, init3.y, 3);
			pacmen[2].d = init3.d;
			pacmen[3] = new PacmanAuto(init4.x, init4.y, 4);
			pacmen[3].d = init4.d;
			break;
		}
	}

	/**
	 * Place un nouveau fantôme à la position initiale
	 * 
	 * @param i
	 *            Numéro de fantome
	 */
	public void init_fantome(int i) {
		if (EnumDifficulte.diff == "Moyen"
				|| EnumDifficulte.diff == "Difficile") {
			switch (i) {
			case 0:
				fantomes[i] = new Fantome((25 - i) * Global.taille_bloc,
						3 * Global.taille_bloc, Direction.Droite, Couleur.Vert);
				break;
			case 1:
				fantomes[i] = new Fantome((25 - i) * Global.taille_bloc,
						3 * Global.taille_bloc, Direction.Droite, Couleur.Bleu);
				break;
			case 2:
				fantomes[i] = new Fantome((25 - i) * Global.taille_bloc,
						3 * Global.taille_bloc, Direction.Droite, Couleur.Rouge);
				break;
			case 3:
				fantomes[i] = new Fantome((25 - i) * Global.taille_bloc,
						3 * Global.taille_bloc, Direction.Droite, Couleur.Rose);
				//fantomes[i] = new Fantome((l - 4) * Global.taille_bloc, (3 * h / 4 - 3)
				//		* Global.taille_bloc, Direction.Gauche, Couleur.Rose);
				break;
			case 4:
				fantomes[i] = new Fantome((25 - i) * Global.taille_bloc,
						3 * Global.taille_bloc, Direction.Droite,
						Couleur.Orange);
				break;
			case 5:
				fantomes[i] = new Fantome((25 - i) * Global.taille_bloc,
						3 * Global.taille_bloc, Direction.Droite, Couleur.Cyan);
				break;
			case 6:
				fantomes[i] = new Fantome((25 - i) * Global.taille_bloc,
						3 * Global.taille_bloc, Direction.Droite, Couleur.Jaune);
				break;
			default:
				fantomes[i] = new Fantome((25 - i) * Global.taille_bloc,
						3 * Global.taille_bloc, Direction.Droite, Couleur.Blanc);
				break;
			}
		} else {
			switch (i) {
			case 0:
				fantomes[i] = new Fantome((25 - i) * Global.taille_bloc,
						13 * Global.taille_bloc, Direction.Droite, Couleur.Vert);
				break;
			case 1:
				fantomes[i] = new Fantome((25 - i) * Global.taille_bloc,
						13 * Global.taille_bloc, Direction.Droite, Couleur.Bleu);
				break;
			case 2:
				fantomes[i] = new Fantome((25 - i) * Global.taille_bloc,
						13 * Global.taille_bloc, Direction.Droite,
						Couleur.Rouge);
				break;
			case 3:
				fantomes[i] = new Fantome((25 - i) * Global.taille_bloc,
						13 * Global.taille_bloc, Direction.Droite, Couleur.Rose);
				break;
			case 4:
				fantomes[i] = new Fantome((29 - i) * Global.taille_bloc,
						17 * Global.taille_bloc, Direction.Droite,
						Couleur.Orange);
				break;
			case 5:
				fantomes[i] = new Fantome((29 - i) * Global.taille_bloc,
						17 * Global.taille_bloc, Direction.Droite, Couleur.Cyan);
				break;
			case 6:
				fantomes[i] = new Fantome((29 - i) * Global.taille_bloc,
						17 * Global.taille_bloc, Direction.Droite,
						Couleur.Jaune);
				break;
			default:
				fantomes[i] = new Fantome((29 - i) * Global.taille_bloc,
						17 * Global.taille_bloc, Direction.Droite,
						Couleur.Blanc);
				break;
			}
		}
	}

	/**
	 * Met à jour la case de coordonnées x,y par le pacman i
	 * 
	 * @param i
	 *            Numéro de pacman
	 * @param x
	 *            Abscisse de la case
	 * @param y
	 *            Ordonnée de la case
	 */
	private void maj_case_bonus(int i, int x, int y) {
		if (((Vide) carte[y][x]).danger) {
			if (!pacmen[i].containsBonus(new Flag())) {
				if (!pacmen[i].invincible) {
					pacmen[i].addScore(-100);
					pacmen[i].removeVie(10);
				}
			} else {
				pacmen[i].maj_flag(i);
			}
		}
		if (((Vide) carte[y][x]).b != null) {
			if (((Vide) carte[y][x]).b instanceof Accelerateur) {
				Global.fen.setBonusAfficher(i + 1, 1);
				pacmen[i].addBonus(new Accelerateur());
			}
			if (((Vide) carte[y][x]).b instanceof RamasseGum) {
				Global.fen.setBonusAfficher(i + 1, 4);
				pacmen[i].addScore(150);
				pacmen[i].addBonus(new RamasseGum());
			}
			if (((Vide) carte[y][x]).b instanceof Invisible) {
				Global.fen.setBonusAfficher(i + 1, 3);
				pacmen[i].addScore(150);
				pacmen[i].addBonus(new Invisible());
			}
			if (((Vide) carte[y][x]).b instanceof Invincible) {
				Global.fen.setBonusAfficher(i + 1, 2);
				pacmen[i].addScore(150);
				pacmen[i].addBonus(new Invincible());
			}
			if (((Vide) carte[y][x]).b instanceof PacGum) {
				Global.nb_pacgum = Global.nb_pacgum - 1;
				pacmen[i].addScore(10);
			}
			if (((Vide) carte[y][x]).b instanceof SuperPacGum) {
				active_SuperPacgum(i, x, y);
			}
			if (((Vide) carte[y][x]).b instanceof Flag) {
				int j;
				for (j = 0; j < pacmen.length; j++) {
					pacmen[j].nb_tour_flag = 20;
					pacmen[j].flag = true;
					pacmen[j].addBonus(new Flag());
				}
			}
			((Vide) carte[y][x]).removeBonus();
		}
	}
	
	/**
	 * @return Nombre de fantômes vulnérables
	 */
	public int nb_fantomes_vulnerables(){
		int i,res=0;
		for (i = 0; i < Global.nb_fantomes; i++) {
			if(fantomes[i].nb_tour_vulnerable>0){
				res++;
			}
		}
		return res;
	}

	/**
	 * Met à jour les cases de la carte et gère les collisions
	 */
	public void maj_matrice() {
		int i, j, vulne, x, y;
		// Gestion des bonus
		for (i = 0; i < Global.nb_pacmen + Global.nbjoueurs; i++) {
			x = pacmen[i].x / Global.taille_bloc;
			y = pacmen[i].y / Global.taille_bloc;
			if (carte[y][x] instanceof Interrupteur) {
				((Interrupteur) carte[y][x]).run();
			}
			if (carte[y][x] instanceof Vide) {
				maj_case_bonus(i, x, y);
			}
		}
		// Gestion des collisions entre personnages
		for (i = 0; i < Global.nb_fantomes; i++) {
			y = fantomes[i].contact_avec_pacman();
			if (y != -1) {
				//Cas où on mange un fantome
				if (fantomes[i].nb_tour_vulnerable != 0) {
					init_fantome(i);
					fantomes[i].nb_tour_vulnerable = 0;
					pacmen[y].addScore(100+100*pacmen[y].acc);
					vulne=this.nb_fantomes_vulnerables();
					//Gestion de l'accumulateur en fonction du nombre de pacmen restants
					for(j=0;j<Global.nb_pacmen + Global.nbjoueurs; j++){
						pacmen[j].acc=fantomes.length-vulne;
					}
					
				} else {
					if (!pacmen[y].invincible) {
						tp_pacman(y);
						pacmen[y].addScore(-200);
					}
				}
			}
		}

		// Téléportation des pacmen morts
		for (i = 0; i < Global.nb_pacmen + Global.nbjoueurs; i++) {
			if (pacmen[i].vie <= 0) {
				tp_pacman(i);
			}
		}
	}

	// Fonctions d'activation des bonus (lorsque les touches sont activées)
	public void active_Invisible(int i, int x) {
		pacmen[i].nb_tour_invisible = x;
		pacmen[i].invisible = true;
	}

	public void active_Invincible(int i, int x) {
		pacmen[i].nb_tour_invincible = x;
		pacmen[i].invincible = true;
	}

	/**
	 * Méthode d'activation du RamasseGum
	 * 
	 * @param i
	 *            numéro de pacman concerné
	 */
	public void active_RamasseGum(int i) {
		int x, y, a, b;
		x = pacmen[i].x / Global.taille_bloc;
		y = pacmen[i].y / Global.taille_bloc;
		for (a = -(10 / 2); a < (10 / 2); a++) {
			for (b = -(10 / 2); b < (10 / 2); b++) {
				if (y + a < h && y + a >= 0 && x + b < l && x + b >= 0) {
					if (carte[y + a][x + b] instanceof Vide) {
						maj_case_bonus(i, x + b, y + a);
					}
				}
			}
		}
	}
	
	/**
	 * Rend les fantômes vulnérables 80 ou 79 tours et augmente le score du pacman qui a ramassé le bonus
	 * @param i Numéro du pacman qui a ramassé le SuperPacGum
	 * @param x Abscisse de la case du SuperPacGum
	 * @param y Ordonnnée de la case du SuperPacGum
	 */
	public void active_SuperPacgum(int i, int x, int y) {
		Global.nb_pacgum = Global.nb_pacgum - 1;
		((Vide) carte[y][x]).removeBonus();
		pacmen[i].addScore(100);
		int j;
		for (j = 0; j < Global.nb_fantomes; j++) {
			if (fantomes[j].nb_tour_vulnerable % 2 == 0)
				fantomes[j].nb_tour_vulnerable = 80;
			else
				fantomes[j].nb_tour_vulnerable = 79;
		}
	}

	// Constructeur de mur: paramètres:
	// x,y initiaux, direction, paramètre à changer d'arrivée
	/**
	 * Méthode à appeler pour construire les éléments de décor
	 * 
	 * @param type
	 *            Type à insérer sur les cases: "Flag", "RamasseGum",
	 *            "Accelerateur", "PacGum", "SuperPacGum", "Mur", "Porte",
	 *            "Danger"
	 * @param x
	 *            String contenant l'entier associé à l'ordonnée initiale
	 * @param y
	 *            String contenant l'entier associé à l'abscisse initiale
	 * @param dir
	 *            Direction dans laquelle on veut placer les éléments de décor:
	 *            "Droite", etc..
	 * @param z
	 *            String contenant l'entier associé à la coordonnée d'arrivée (x
	 *            si dir est droite ou gauche, y sinon)
	 */
	public void build(String type, String x, String y, String dir, String z) {
		int x1 = Integer.valueOf(x);
		int y1 = Integer.valueOf(y);
		if (type.equals("Flag") || type.equals("RamasseGum")
				|| type.equals("Accelerateur") || type.equals("Danger")
				|| type.equals("Invisible") || type.equals("Invincible")) {
			int i;
			// z correspond à la longueur du mur
			int z1 = Integer.valueOf(z);
			if (dir.equals("Haut")) {
				for (i = y1; i >= z1; i--) {
					this.carte[i][x1] = new Vide(type);
				}
				return;
			}
			if (dir.equals("Bas")) {
				for (i = y1; i <= z1; i++) {
					this.carte[i][x1] = new Vide(type);
				}
				return;
			}
			if (dir.equals("Droite")) {
				for (i = x1; i <= z1; i++) {
					this.carte[y1][i] = new Vide(type);
				}
				return;
			}
			if (dir.equals("Gauche")) {
				for (i = x1; i >= z1; i--) {
					this.carte[y1][i] = new Vide(type);
				}
				return;
			}
			System.out.println("Direction invalide");
		}
		if (type.equals("SuperPacGum")) {
			int i;
			// z correspond à la longueur du mur
			int z1 = Integer.valueOf(z);
			if (dir.equals("Haut")) {
				for (i = y1; i >= z1; i--) {
					this.carte[i][x1] = new Vide(type);
				}
				return;
			}
			if (dir.equals("Bas")) {
				for (i = y1; i <= z1; i++) {
					this.carte[i][x1] = new Vide(type);
				}
				return;
			}
			if (dir.equals("Droite")) {
				for (i = x1; i <= z1; i++) {
					this.carte[y1][i] = new Vide(type);
				}
				return;
			}
			if (dir.equals("Gauche")) {
				for (i = x1; i >= z1; i--) {
					this.carte[y1][i] = new Vide(type);
				}
				return;
			}
			if (dir.equals("")) {
				this.carte[y1][x1] = new Vide(type);
				return;
			}
			System.out.println("Direction invalide");
		}
		if (type.equals("Mur")) {
			int i;
			// z correspond à la longueur du mur
			int z1 = Integer.valueOf(z);
			if (dir.equals("Haut")) {
				for (i = y1; i >= z1; i--) {
					this.carte[i][x1] = new Mur();
				}
				return;
			}
			if (dir.equals("Bas")) {
				for (i = y1; i <= z1; i++) {
					this.carte[i][x1] = new Mur();
				}
				return;
			}
			if (dir.equals("Droite")) {
				for (i = x1; i <= z1; i++) {
					this.carte[y1][i] = new Mur();
				}
				return;
			}
			if (dir.equals("Gauche")) {
				for (i = x1; i >= z1; i--) {
					this.carte[y1][i] = new Mur();
				}
				return;
			}
			System.out.println("Direction invalide");
		}
		if (type.equals("Porte")) {
			Boolean tomate = Boolean.valueOf(dir);
			int z1 = Integer.valueOf(z);
			this.carte[y1][x1] = new Porte(z1);
			((Porte) this.carte[y1][x1]).est_ouvert = tomate;
			return;
		}
		System.out.println("String type invalide");
	}

	/**
	 * Téléporte le pacman à sa casde initiale
	 * 
	 * @param id
	 *            Numéro de pacman
	 */
	public void tp_pacman(int id) {
		if (pacmen[id] instanceof PacmanJoueur) {
			((PacmanJoueur) pacmen[id]).corner = false;
		}
		switch (id) {
		case 0:
			pacmen[0].x=init1.x;
			pacmen[0].y=init1.y;
			pacmen[0].d=init1.d;
			pacmen[0].vie=100;
			active_Invisible(0,10);
			active_Invincible(0,10);
			break;
		case 1:
			pacmen[1].x=init2.x;
			pacmen[1].y=init2.y;
			pacmen[1].d=init2.d;
			pacmen[1].vie=100;
			active_Invisible(1,10);
			active_Invincible(1,10);
			break;
		case 2:
			pacmen[2].x=init3.x;
			pacmen[2].y=init3.y;
			pacmen[2].d=init3.d;
			pacmen[2].vie=100;
			active_Invisible(2,10);
			active_Invincible(2,10);
			break;
		case 3:
			pacmen[3].x=init4.x;
			pacmen[3].y=init4.y;
			pacmen[3].d=init4.d;
			pacmen[3].vie=100;
			active_Invisible(3,10);
			active_Invincible(3,10);
			break;
		}
	}

	/**
	 * Carte utilisée lors du jeu
	 */
	public void carte1() {
		int cpt, i, j;

		// BORD

		// BD - SUP
		build("Mur", "" + 0, "" + 0, "Droite", "" + 12);
		build("Mur", "" + 14, "" + 0, "Droite", "" + 36);
		build("Mur", "" + 38, "" + 0, "Droite", "" + (l - 1));

		// BD - INF
		build("Mur", "" + 0, "" + (h - 1), "Droite", "" + 12);
		build("Mur", "" + 14, "" + (h - 1), "Droite", "" + 36);
		build("Mur", "" + 38, "" + (h - 1), "Droite", "" + (l - 1));

		// BD - DROITE
		build("Mur", "" + (l - 1), "" + 0, "Bas", "" + 10);
		build("Mur", "" + (l - 1), "" + 12, "Bas", "" + 22);
		build("Mur", "" + (l - 1), "" + 24, "Bas", "" + (h - 1));

		// BD - GAUCHE
		build("Mur", "" + 0, "" + 0, "Bas", "" + 10);
		build("Mur", "" + 0, "" + 12, "Bas", "" + 22);
		build("Mur", "" + 0, "" + 24, "Bas", "" + (h - 1));

		if (EnumDifficulte.diff == "Moyen"
				|| EnumDifficulte.diff == "Difficile") {
			// ZONE HAUT

			build("Mur", "" + 2, "" + 2, "Droite", "" + 8);
			build("Mur", "" + 10, "" + 2, "Droite", "" + 18);
			build("Mur", "" + 20, "" + 2, "Droite", "" + 28);
			build("Mur", "" + 30, "" + 2, "Droite", "" + 38);
			build("Mur", "" + 40, "" + 2, "Droite", "" + (l - 3));

			build("Mur", "" + 2, "" + 4, "Droite", "" + 5);
			build("Mur", "" + 7, "" + 4, "Droite", "" + 10);
			build("Mur", "" + 12, "" + 4, "Droite", "" + 20);
			build("Mur", "" + 22, "" + 4, "Droite", "" + 23);
			build("Mur", "" + 25, "" + 4, "Droite", "" + 35);
			build("Mur", "" + 37, "" + 4, "Droite", "" + 40);
			build("Mur", "" + 42, "" + 4, "Droite", "" + 45);
			build("Mur", "" + 47, "" + 4, "Droite", "" + (l - 3));

			// ZONE BAS

			build("Mur", "" + 2, "" + (h - 7), "Droite", "" + 5);
			build("Mur", "" + 7, "" + (h - 7), "Droite", "" + 10);
			build("Mur", "" + 12, "" + (h - 7), "Droite", "" + 20);
			build("Mur", "" + 22, "" + (h - 7), "Droite", "" + 23);
			build("Mur", "" + 25, "" + (h - 7), "Droite", "" + 35);
			build("Mur", "" + 37, "" + (h - 7), "Droite", "" + 40);
			build("Mur", "" + 42, "" + (h - 7), "Droite", "" + 45);
			build("Mur", "" + 47, "" + (h - 7), "Droite", "" + (l - 3));

			build("Mur", "" + 2, "" + (h - 5), "Droite", "" + 8);
			build("Mur", "" + 10, "" + (h - 5), "Droite", "" + 18);
			build("Mur", "" + 20, "" + (h - 5), "Droite", "" + 28);
			build("Mur", "" + 30, "" + (h - 5), "Droite", "" + 38);
			build("Mur", "" + 40, "" + (h - 5), "Droite", "" + (l - 3));

			build("Mur", "" + 2, "" + (h - 3), "Droite", "" + 5);
			build("Mur", "" + 7, "" + (h - 3), "Droite", "" + 10);
			build("Mur", "" + 12, "" + (h - 3), "Droite", "" + 20);
			build("Mur", "" + 22, "" + (h - 3), "Droite", "" + 23);
			build("Mur", "" + 25, "" + (h - 3), "Droite", "" + 35);
			build("Mur", "" + 37, "" + (h - 3), "Droite", "" + 40);
			build("Mur", "" + 42, "" + (h - 3), "Droite", "" + 45);
			build("Mur", "" + 47, "" + (h - 3), "Droite", "" + (l - 3));

			// ZONE CENTRE
			build("Mur", "" + 21, "" + (6), "Droite", "" + 30);
			build("Mur", "" + 21, "" + (26), "Droite", "" + 30);

			// MAIN 1
			build("Mur", "" + (15 - 13), "" + (6), "Bas", "" + (15));
			build("Mur", "" + (15 - 13), "" + (16), "Bas", "" + (26));
			build("Mur", "" + (33 - 13), "" + (6), "Bas", "" + (15));
			build("Mur", "" + (33 - 13), "" + (16), "Bas", "" + (26));
			build("Mur", "" + (17 - 13), "" + (6), "Droite", "" + (24 - 13));
			build("Mur", "" + (25 - 13), "" + (6), "Droite", "" + (31 - 13));
			build("Mur", "" + (17 - 13), "" + (26), "Droite", "" + (24 - 13));
			build("Mur", "" + (25 - 13), "" + (26), "Droite", "" + (31 - 13));

			build("Mur", "" + (22 - 13), "" + (15), "Droite", "" + (22 - 13));
			build("Mur", "" + (26 - 13), "" + (15), "Droite", "" + (26 - 13));

			build("Mur", "" + (17 - 13), "" + (8), "Droite", "" + (18 - 13));
			build("Mur", "" + (20 - 13), "" + (8), "Droite", "" + (22 - 13));
			build("Mur", "" + (24 - 13), "" + (8), "Droite", "" + (24 - 13));
			build("Mur", "" + (26 - 13), "" + (8), "Droite", "" + (28 - 13));
			build("Mur", "" + (30 - 13), "" + (8), "Droite", "" + (31 - 13));

			build("Mur", "" + (17 - 13), "" + (10), "Droite", "" + (18 - 13));
			build("Mur", "" + (22 - 13), "" + (10), "Droite", "" + (26 - 13));
			build("Mur", "" + (30 - 13), "" + (10), "Droite", "" + (31 - 13));

			build("Mur", "" + (20 - 13), "" + (10), "Bas", "" + (14));
			build("Mur", "" + (28 - 13), "" + (10), "Bas", "" + (14));
			build("Mur", "" + (24 - 13), "" + (11), "Bas", "" + (12));

			build("Mur", "" + (21 - 13), "" + (12), "Droite", "" + (22 - 13));
			build("Mur", "" + (26 - 13), "" + (12), "Droite", "" + (27 - 13));

			build("Mur", "" + (16 - 13), "" + (12), "Droite", "" + (18 - 13));
			build("Mur", "" + (16 - 13), "" + (13), "Droite", "" + (18 - 13));
			build("Mur", "" + (16 - 13), "" + (14), "Droite", "" + (18 - 13));

			build("Mur", "" + (22 - 13), "" + (14), "Droite", "" + (23 - 13));
			build("Mur", "" + (25 - 13), "" + (14), "Droite", "" + (26 - 13));

			build("Mur", "" + (22 - 13), "" + (16), "Droite", "" + (26 - 13));

			build("Mur", "" + (20 - 13), "" + (16), "Bas", "" + (18));
			build("Mur", "" + (28 - 13), "" + (16), "Bas", "" + (18));

			build("Mur", "" + (30 - 13), "" + (12), "Droite", "" + (32 - 13));
			build("Mur", "" + (30 - 13), "" + (13), "Droite", "" + (32 - 13));
			build("Mur", "" + (30 - 13), "" + (14), "Droite", "" + (32 - 13));

			build("Mur", "" + (22 - 13), "" + (18), "Droite", "" + (26 - 13));

			build("Mur", "" + (24 - 13), "" + (18), "Bas", "" + (20));
			build("Mur", "" + (24 - 13), "" + (23), "Bas", "" + (24));

			build("Mur", "" + (17 - 13), "" + (20), "Droite", "" + (18 - 13));
			build("Mur", "" + (20 - 13), "" + (20), "Droite", "" + (22 - 13));
			build("Mur", "" + (26 - 13), "" + (20), "Droite", "" + (28 - 13));
			build("Mur", "" + (30 - 13), "" + (20), "Droite", "" + (31 - 13));

			build("Mur", "" + (22 - 13), "" + (22), "Droite", "" + (26 - 13));

			build("Mur", "" + (16 - 13), "" + (16), "Droite", "" + (18 - 13));
			build("Mur", "" + (16 - 13), "" + (17), "Droite", "" + (18 - 13));
			build("Mur", "" + (16 - 13), "" + (18), "Droite", "" + (18 - 13));

			build("Mur", "" + (30 - 13), "" + (16), "Droite", "" + (32 - 13));
			build("Mur", "" + (30 - 13), "" + (17), "Droite", "" + (32 - 13));
			build("Mur", "" + (30 - 13), "" + (18), "Droite", "" + (32 - 13));

			build("Mur", "" + (16 - 13), "" + (22), "Droite", "" + (16 - 13));
			build("Mur", "" + (32 - 13), "" + (22), "Droite", "" + (32 - 13));

			build("Mur", "" + (18 - 13), "" + (21), "Bas", "" + (22));
			build("Mur", "" + (30 - 13), "" + (21), "Bas", "" + (22));

			build("Mur", "" + (20 - 13), "" + (22), "Bas", "" + (23));
			build("Mur", "" + (28 - 13), "" + (22), "Bas", "" + (23));

			build("Mur", "" + (17 - 13), "" + (24), "Droite", "" + (22 - 13));
			build("Mur", "" + (26 - 13), "" + (24), "Droite", "" + (31 - 13));

			// MAIN 2
			build("Mur", "" + (15 + 15), "" + (6), "Bas", "" + (15));
			build("Mur", "" + (15 + 15), "" + (16), "Bas", "" + (26));
			build("Mur", "" + (33 + 15), "" + (6), "Bas", "" + (15));
			build("Mur", "" + (33 + 15), "" + (16), "Bas", "" + (26));
			build("Mur", "" + (17 + 15), "" + (6), "Droite", "" + (24 + 15));
			build("Mur", "" + (25 + 15), "" + (6), "Droite", "" + (31 + 15));
			build("Mur", "" + (17 + 15), "" + (26), "Droite", "" + (24 + 15));
			build("Mur", "" + (25 + 15), "" + (26), "Droite", "" + (31 + 15));

			build("Mur", "" + (22 + 15), "" + (15), "Droite", "" + (22 + 15));
			build("Mur", "" + (26 + 15), "" + (15), "Droite", "" + (26 + 15));

			build("Mur", "" + (17 + 15), "" + (8), "Droite", "" + (18 + 15));
			build("Mur", "" + (20 + 15), "" + (8), "Droite", "" + (22 + 15));
			build("Mur", "" + (24 + 15), "" + (8), "Droite", "" + (24 + 15));
			build("Mur", "" + (26 + 15), "" + (8), "Droite", "" + (28 + 15));
			build("Mur", "" + (30 + 15), "" + (8), "Droite", "" + (31 + 15));

			build("Mur", "" + (17 + 15), "" + (10), "Droite", "" + (18 + 15));
			build("Mur", "" + (22 + 15), "" + (10), "Droite", "" + (26 + 15));
			build("Mur", "" + (30 + 15), "" + (10), "Droite", "" + (31 + 15));

			build("Mur", "" + (20 + 15), "" + (10), "Bas", "" + (14));
			build("Mur", "" + (28 + 15), "" + (10), "Bas", "" + (14));
			build("Mur", "" + (24 + 15), "" + (11), "Bas", "" + (12));

			build("Mur", "" + (21 + 15), "" + (12), "Droite", "" + (22 + 15));
			build("Mur", "" + (26 + 15), "" + (12), "Droite", "" + (27 + 15));

			build("Mur", "" + (16 + 15), "" + (12), "Droite", "" + (18 + 15));
			build("Mur", "" + (16 + 15), "" + (13), "Droite", "" + (18 + 15));
			build("Mur", "" + (16 + 15), "" + (14), "Droite", "" + (18 + 15));

			build("Mur", "" + (22 + 15), "" + (14), "Droite", "" + (23 + 15));
			build("Mur", "" + (25 + 15), "" + (14), "Droite", "" + (26 + 15));

			build("Mur", "" + (22 + 15), "" + (16), "Droite", "" + (26 + 15));

			build("Mur", "" + (20 + 15), "" + (16), "Bas", "" + (18));
			build("Mur", "" + (28 + 15), "" + (16), "Bas", "" + (18));

			build("Mur", "" + (30 + 15), "" + (12), "Droite", "" + (32 + 15));
			build("Mur", "" + (30 + 15), "" + (13), "Droite", "" + (32 + 15));
			build("Mur", "" + (30 + 15), "" + (14), "Droite", "" + (32 + 15));

			build("Mur", "" + (22 + 15), "" + (18), "Droite", "" + (26 + 15));

			build("Mur", "" + (24 + 15), "" + (18), "Bas", "" + (20));
			build("Mur", "" + (24 + 15), "" + (23), "Bas", "" + (24));

			build("Mur", "" + (17 + 15), "" + (20), "Droite", "" + (18 + 15));
			build("Mur", "" + (20 + 15), "" + (20), "Droite", "" + (22 + 15));
			build("Mur", "" + (26 + 15), "" + (20), "Droite", "" + (28 + 15));
			build("Mur", "" + (30 + 15), "" + (20), "Droite", "" + (31 + 15));

			build("Mur", "" + (22 + 15), "" + (22), "Droite", "" + (26 + 15));

			build("Mur", "" + (16 + 15), "" + (16), "Droite", "" + (18 + 15));
			build("Mur", "" + (16 + 15), "" + (17), "Droite", "" + (18 + 15));
			build("Mur", "" + (16 + 15), "" + (18), "Droite", "" + (18 + 15));

			build("Mur", "" + (30 + 15), "" + (16), "Droite", "" + (32 + 15));
			build("Mur", "" + (30 + 15), "" + (17), "Droite", "" + (32 + 15));
			build("Mur", "" + (30 + 15), "" + (18), "Droite", "" + (32 + 15));

			build("Mur", "" + (16 + 15), "" + (22), "Droite", "" + (16 + 15));
			build("Mur", "" + (32 + 15), "" + (22), "Droite", "" + (32 + 15));

			build("Mur", "" + (18 + 15), "" + (21), "Bas", "" + (22));
			build("Mur", "" + (30 + 15), "" + (21), "Bas", "" + (22));

			build("Mur", "" + (20 + 15), "" + (22), "Bas", "" + (23));
			build("Mur", "" + (28 + 15), "" + (22), "Bas", "" + (23));

			build("Mur", "" + (17 + 15), "" + (24), "Droite", "" + (22 + 15));
			build("Mur", "" + (26 + 15), "" + (24), "Droite", "" + (31 + 15));

			// Zone à danger de gauche
			build("Danger", "" + 1, "" + 13, "Bas", "" + 21);
			build("Invisible", "" + 1, "" + 17, "Bas", "" + 17);
			build("Porte", "" + 1, "" + 12, "False", "" + 0);
			build("Porte", "" + 1, "" + 22, "False", "" + 0);

			// Zone à danger de droite
			build("Danger", "" + (l - 2), "" + 13, "Bas", "" + 21);
			build("Invincible", "" + (l - 2), "" + 17, "Bas", "" + 17);
			build("Porte", "" + (l - 2), "" + 12, "False", "" + 1);
			build("Porte", "" + (l - 2), "" + 22, "False", "" + 1);

			// Zone à danger du bas
			build("Danger", "" + (l / 2 - 4), "" + (h - 2), "Droite", ""
					+ (l / 2 + 4));
			build("Danger", "" + (l / 2 - 4), "" + (h - 3), "Droite", ""
					+ (l / 2 - 4));
			build("Danger", "" + (l / 2 - 1), "" + (h - 3), "Droite", ""
					+ (l / 2 - 1));
			build("Danger", "" + (l / 2 - 4), "" + (h - 4), "Droite", ""
					+ (l / 2 + 4));
			build("Danger", "" + (l / 2 + 4), "" + (h - 5), "Droite", ""
					+ (l / 2 + 4));
			build("Danger", "" + (l / 2 - 4), "" + (h - 6), "Droite", ""
					+ (l / 2 + 4));
			build("RamasseGum", "" + (l / 2), "" + (h - 4), "Droite", ""
					+ (l / 2));
			build("Porte", "" + (l / 2 - 5), "" + (h - 4), "False", "" + 2);
			build("Porte", "" + (l / 2 + 5), "" + (h - 4), "False", "" + 2);

			build("Flag", "" + (l / 2), "" + 3, "Droite", "" + (l / 2));

			// SuperPacGums
			build("SuperPacGum", "" + 6, "" + 3, "Droite", "" + 6);
			build("SuperPacGum", "" + 6, "" + (h - 4), "Droite", "" + 6);
			build("SuperPacGum", "" + (l - 5), "" + 3, "Droite", "" + (l - 5));
			build("SuperPacGum", "" + (l - 5), "" + (h - 4), "Droite", ""
					+ (l - 5));

			// Interrupteurs
			Porte[] tab = new Porte[6];
			tab[0] = (Porte) this.carte[12][1];
			tab[1] = (Porte) this.carte[22][1];
			tab[2] = (Porte) this.carte[12][l - 2];
			tab[3] = (Porte) this.carte[22][l - 2];
			tab[4] = (Porte) this.carte[h - 4][l / 2 - 5];
			tab[5] = (Porte) this.carte[h - 4][l / 2 + 5];
			this.carte[13][11] = new Interrupteur(tab);
			this.carte[13][l - 12] = new Interrupteur(tab);
		}
		if (EnumDifficulte.diff == "Facile") {
			build("Mur", "" + 15, "" + 6, "Bas", "15");
			build("Mur", "" + 15, "" + 16, "Bas", "26");
			build("Mur", "" + 33, "" + 6, "Bas", "15");
			build("Mur", "" + 33, "" + 16, "Bas", "26");
			build("Mur", "" + 16, "" + 6, "Droite", "24");
			build("Mur", "" + 25, "" + 6, "Droite", "32");
			build("Mur", "" + 16, "" + 26, "Droite", "24");
			build("Mur", "" + 25, "" + 26, "Droite", "32");

			build("Mur", "" + 22, "" + 15, "Droite", "22");
			build("Mur", "" + 26, "" + 15, "Droite", "26");

			build("Mur", "" + 17, "" + 8, "Droite", "18");
			build("Mur", "" + 20, "" + 8, "Droite", "22");
			build("Mur", "" + 24, "" + 8, "Droite", "24");
			build("Mur", "" + 26, "" + 8, "Droite", "28");
			build("Mur", "" + 30, "" + 8, "Droite", "31");

			build("Mur", "" + 17, "" + 10, "Droite", "18");
			build("Mur", "" + 22, "" + 10, "Droite", "26");
			build("Mur", "" + 30, "" + 10, "Droite", "31");

			build("Mur", "" + 20, "" + 10, "Bas", "14");
			build("Mur", "" + 28, "" + 10, "Bas", "14");
			build("Mur", "" + 24, "" + 11, "Bas", "12");

			build("Mur", "" + 21, "" + 12, "Droite", "22");
			build("Mur", "" + 26, "" + 12, "Droite", "27");

			build("Mur", "" + 15, "" + 12, "Droite", "18");
			build("Mur", "" + 15, "" + 13, "Droite", "18");
			build("Mur", "" + 15, "" + 14, "Droite", "18");

			build("Mur", "" + 22, "" + 14, "Droite", "23");
			build("Mur", "" + 25, "" + 14, "Droite", "26");

			build("Mur", "" + 22, "" + 16, "Droite", "26");

			build("Mur", "" + 20, "" + 16, "Bas", "18");
			build("Mur", "" + 28, "" + 16, "Bas", "18");

			build("Mur", "" + 30, "" + 12, "Droite", "32");
			build("Mur", "" + 30, "" + 13, "Droite", "32");
			build("Mur", "" + 30, "" + 14, "Droite", "32");

			build("Mur", "" + 22, "" + 18, "Droite", "26");

			build("Mur", "" + 24, "" + 18, "Bas", "20");
			build("Mur", "" + 24, "" + 23, "Bas", "24");

			build("Mur", "" + 17, "" + 20, "Droite", "18");
			build("Mur", "" + 20, "" + 20, "Droite", "22");
			build("Mur", "" + 26, "" + 20, "Droite", "28");
			build("Mur", "" + 30, "" + 20, "Droite", "31");

			build("Mur", "" + 22, "" + 22, "Droite", "26");

			build("Mur", "" + 15, "" + 16, "Droite", "18");
			build("Mur", "" + 15, "" + 17, "Droite", "18");
			build("Mur", "" + 15, "" + 18, "Droite", "18");

			build("Mur", "" + 30, "" + 16, "Droite", "32");
			build("Mur", "" + 30, "" + 17, "Droite", "32");
			build("Mur", "" + 30, "" + 18, "Droite", "32");

			build("Mur", "" + 15, "" + 22, "Droite", "16");
			build("Mur", "" + 32, "" + 22, "Droite", "32");

			build("Mur", "" + 18, "" + 21, "Bas", "22");
			build("Mur", "" + 30, "" + 21, "Bas", "22");

			build("Mur", "" + 20, "" + 22, "Bas", "23");
			build("Mur", "" + 28, "" + 22, "Bas", "23");

			build("Mur", "" + 17, "" + 24, "Droite", "22");
			build("Mur", "" + 26, "" + 24, "Droite", "31");
			build("SuperPacGum", "" + (l / 2 - 6), "" + (h / 2 - 2), "Droite",
					"" + (l / 2 - 6));
			build("SuperPacGum", "" + (l / 2 + 4), "" + (h / 2 - 2), "Droite",
					"" + (l / 2 + 4));

		}

		// Initialisation du nombre de pacgum et superpacgums
		cpt = 0;
		for (i = 0; i < h; i++) {
			for (j = 0; j < l; j++) {
				carte[i][j].x = j;
				carte[i][j].y = i;
				if (this.carte[i][j] instanceof Vide) {
					if (((Vide) this.carte[i][j]).b instanceof PacGum
							|| ((Vide) this.carte[i][j]).b instanceof SuperPacGum) {
						cpt++;
					}
				}

			}
		}
		Global.nb_pacgum = cpt;
	}
}