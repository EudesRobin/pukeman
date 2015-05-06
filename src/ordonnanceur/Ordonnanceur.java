package ordonnanceur;

import pacman.*;
import Interface.*;
import Monde.Perso.PacmanAuto;
import Parser.*;
import Automate.*;

/**
 * Ordonnanceur du jeu, gestion de la boucle du jeu, mise à jour des scores et
 * des timers du bonus flag
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Ordonnanceur {

	long time;
	long wait = 0;

	public boolean croisementsup = false;

	int i = 0;
	int indperdant;

	public static String fantomes;
	public static String pacauto;
	
	public static ComportementList cl;

	Thread updateThread = new Thread() {

		@Override
		public void run() {
			Parser p = new Parser();
			ListXMLContents xml_contents;
			if (EnumDifficulte.diff == "Facile") {
				fantomes = "FTF";
				pacauto = "PAF";
			} else if (EnumDifficulte.diff == "Moyen") {
				fantomes = "FTM";
				pacauto = "PAM";
			} else {
				fantomes = "FTD";
				pacauto = "PAD";
			}
			try {
				xml_contents = p.parsing("Parser.xml");
				cl = xml_contents.getComportementList();

				while ((Global.nb_pacgum != 0) && (Global.bool_game)) {

					if (!Global.end_game) {

						time = System.currentTimeMillis();

						/* Mise à jour de l'affichage [ONLY] */
						Global.backjeu.repaint();

						if (Global.refresh == 20) {
							/* Tout les 20 cycles, MAJ du moteur (matrice) */
							maj_game(cl);
							Global.map.maj_matrice();
							Global.refresh = 0;
						}
						if (Global.refresh == 19) {
							/*
							 * Compteur pour empecher un glich graphique (pacman
							 * d'un joueur "immobile" face à un mur )
							 */
							Global.backjeu.maj_corner();
						}
						Global.refresh++;

						/*
						 * Mise à jour du compteur relatif au flag [immunité
						 * zone de danger]
						 */
						majTimerFlag();

						/* MAJ score joueur, équipe. */
						for (int j = 0; j < Global.nb_pacmen + Global.nbjoueurs; j++) {
							if (Global.map.pacmen[j].vie != 0) {
								maj_score(j);
								majScoreCoop();
							}
						}

						/* Vérification condition de Victoire / Defaite */
						for (int j = 0; j < Global.nb_pacmen + Global.nbjoueurs; j++) {

							if (Global.map.pacmen[j].vie == 0) {
								indperdant = j;
								switch (indperdant) {
								case 0:
									Global.stringscorej1
											.setFont(Global.fontdefaite);
									Global.stringscorej1.setText("	Defeat : "
											+ Integer.toString(Global.scorej1)
											+ " pts");
									break;
								case 1:
									Global.stringscorej2
											.setFont(Global.fontdefaite);
									Global.stringscorej2.setText("	Defeat : "
											+ Integer.toString(Global.scorej2)
											+ " pts");
									break;
								case 2:
									Global.stringscorej3
											.setFont(Global.fontdefaite);
									Global.stringscorej3.setText("	Defeat : "
											+ Integer.toString(Global.scorej3)
											+ " pts");
									break;
								case 3:
									Global.stringscorej4
											.setFont(Global.fontdefaite);
									Global.stringscorej4.setText("	Defeat : "
											+ Integer.toString(Global.scorej4)
											+ " pts");
									break;
								}
							}
						}

						/* On esseye de garder un FPS constant */
						time = System.currentTimeMillis() - time;

						if (Global.fps - time < 0) {
							wait = 0;
						} else {
							wait = Global.fps - time;
						}
					}
					try {
						// Delay and give other thread a chance to run
						Thread.sleep(wait); // milliseconds
					} catch (InterruptedException ignore) {
					}

				}

				/* Mise à jour du boolean pour la boucle de jeu */
				Global.endgame = new FinDuJeu();
				Global.bool_game = false;
				Global.high.newhs();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	/**
	 * Boucle de jeu, on lance le thread.
	 */
	public void gameLoop() {
		updateThread.start(); // called back run()

	}

	/**
	 * Mise à jour des fantomes, des pacmans, des bonus en cours...
	 * 
	 * @param cl
	 *            Liste de comportements associes
	 */
	public void maj_game(ComportementList cl) {
		int j;

		for (j = 0; j < Global.nb_fantomes; j++) {
			Global.map.fantomes[j].majList();
		}

		for (j = Global.nbjoueurs; j < Global.nb_pacmen + Global.nbjoueurs; j++) {
			Global.map.pacmen[j].majList();
		}

		/* Mise à jour des fantomes */
		for (j = 0; j < Global.nb_fantomes; j++) {
			Global.map.fantomes[j].evoluer((cl.get(fantomes)));
		}

		System.out.println();

		/* Mise à jour des pacman controles par les joueurs */
		for (j = 0; j < Global.nbjoueurs; j++) {
			Global.map.pacmen[j].evoluer((cl.get("PM")));
		}

		/* Mise a jour des pacman automatiques */
		for (j = Global.nbjoueurs; j < Global.nb_pacmen + Global.nbjoueurs; j++) {
			Global.map.pacmen[j].evoluer((cl.get(pacauto)));
		}
		
		System.out.println();
		

		/* Mise à jour bonus invulnerabilite, invisibilite */
		for (j = 0; j < Global.nb_pacmen + Global.nbjoueurs; j++) {
			Global.map.pacmen[j].maj_invincible();
			Global.map.pacmen[j].maj_invisible();
		}
	}

	/**
	 * Mise à jour des scores
	 * 
	 * @param i
	 *            Identifiant du pacman
	 */
	void maj_score(int i) {
		switch (i) {
		case 0:
			Global.scorej1 = Global.map.pacmen[0].get_score();
			Global.stringscorej1.setText(Integer.toString(Global.scorej1));
			break;
		case 1:
			Global.scorej2 = Global.map.pacmen[1].get_score();
			if(Global.map.pacmen[1] instanceof PacmanAuto){
				if (((PacmanAuto) Global.map.pacmen[1]).clic) {
					Global.j2.setIcon(Global.joueur2obj);
					Global.stringscorej2.setText(Integer.toString(Global.scorej2));
					Global.j2.add(Global.stringscorej2);
				} else {
					Global.stringscorej2.setText(Integer.toString(Global.scorej2));
				}
			}
			else{
				Global.scorej2 = Global.map.pacmen[1].get_score();
				Global.stringscorej2.setText(Integer.toString(Global.scorej2));
			}
			break;
		case 2:
			Global.scorej3 = Global.map.pacmen[2].get_score();
			if (((PacmanAuto) Global.map.pacmen[2]).clic) {
				Global.j3.setIcon(Global.joueur3obj);
				Global.stringscorej3.setText(Integer.toString(Global.scorej3));
				Global.j3.add(Global.stringscorej3);
			} else {
				Global.stringscorej3.setText(Integer.toString(Global.scorej3));
			}
			break;
		case 3:
			Global.scorej4 = Global.map.pacmen[3].get_score();
			if (((PacmanAuto) Global.map.pacmen[3]).clic) {
				Global.j4.setIcon(Global.joueur4obj);
				Global.stringscorej4.setText(Integer.toString(Global.scorej4));
				Global.j4.add(Global.stringscorej4);
			} else {
				Global.stringscorej4.setText(Integer.toString(Global.scorej4));
			}
			break;
		}

	}

	/**
	 * Mise à jour du score de l'equipe
	 */
	void majScoreCoop() {
		Global.scorecoop = Global.scorej1 + Global.scorej2 + Global.scorej3
				+ Global.scorej4;
		Global.stringscorecoop.setText(Integer.toString(Global.scorecoop));
	}

	/**
	 * Mise à jour du compteur relatif au Flag ( duree restante...)
	 */
	void majTimerFlag() {
		Global.flag1.setText(Integer
				.toString(Global.map.pacmen[0].nb_tour_flag));
		Global.flag2.setText(Integer
				.toString(Global.map.pacmen[1].nb_tour_flag));
		Global.flag3.setText(Integer
				.toString(Global.map.pacmen[2].nb_tour_flag));
		Global.flag4.setText(Integer
				.toString(Global.map.pacmen[3].nb_tour_flag));
	}

}
