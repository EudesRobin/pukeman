package Interface;

import java.awt.*;

import javax.swing.JPanel;

import Monde.Perso.Direction;
import Monde.Perso.PacmanJoueur;
import pacman.EnumDifficulte;
import pacman.Global;

/**
 * Affichage de la carte de jeu
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Map extends JPanel {

	private static final long serialVersionUID = -4548784815844972711L;
	// toolkit pour l'image de fond.

	java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
	Image wallpaperf = toolkit.getImage(Global.imagefondf);
	Image wallpapermd = toolkit.getImage(Global.imagefondmd);

	int width, height;

	public Map(int width, int height) {

		super(true); // double buffering
		this.width = width;
		this.height = height;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // paint parent's background

		Graphics2D graphics2D = (Graphics2D) g;

		// Set anti-alias!
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// Set anti-alias for text
		graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		draw_dec(g);
		draw_pacman(g);

	}

	public void draw_dec(Graphics g) {
		int i, j;
		if (EnumDifficulte.diff == "Moyen"
				|| EnumDifficulte.diff == "Difficile") {
			g.drawImage(wallpapermd, 0, 0, null);
		} else {
			g.drawImage(wallpaperf, 0, 0, null);
		}

		for (i = 0; i < Global.hfenjeu / Global.taille_bloc; i++) {
			for (j = 0; j < Global.lfenjeu / Global.taille_bloc; j++) {
				g.drawImage(Global.map.carte[i][j].getImageCase(), j
						* Global.taille_bloc, i * Global.taille_bloc, null);
			}
		}
	}

	public void draw_fantomes(Graphics g) {
		int j;

		for (j = 0; j < Global.nb_fantomes; j++) {
			if (Global.map.fantomes[j].d == Direction.Haut) {
				if (Global.map.fantomes[j].nb_tour_vulnerable == 0) { // = 0 ->
																		// 20 !=
																		// 10
					g.drawImage(Global.map.fantomes[j].getImageFantome(),
							Global.map.fantomes[j].x, Global.map.fantomes[j].y
									+ (Global.taille_bloc - Global.refresh),
							null);
				} else {
					g.drawImage(
							Global.map.fantomes[j].getImageFantome(),
							Global.map.fantomes[j].x,
							Global.map.fantomes[j].y
									+ (Global.taille_bloc / 2 - Global.refresh / 2),
							null);
				}
			} else if (Global.map.fantomes[j].d == Direction.Bas) {
				if (Global.map.fantomes[j].nb_tour_vulnerable == 0) {
					g.drawImage(Global.map.fantomes[j].getImageFantome(),
							Global.map.fantomes[j].x, Global.map.fantomes[j].y
									- (Global.taille_bloc - Global.refresh),
							null);
				} else {
					g.drawImage(
							Global.map.fantomes[j].getImageFantome(),
							Global.map.fantomes[j].x,
							Global.map.fantomes[j].y
									- (Global.taille_bloc / 2 - Global.refresh / 2),
							null);
				}
			} else if (Global.map.fantomes[j].d == Direction.Gauche) {
				if (Global.map.fantomes[j].nb_tour_vulnerable == 0) {
					g.drawImage(Global.map.fantomes[j].getImageFantome(),
							Global.map.fantomes[j].x
									+ (Global.taille_bloc - Global.refresh),
							Global.map.fantomes[j].y, null);
				} else {
					g.drawImage(
							Global.map.fantomes[j].getImageFantome(),
							Global.map.fantomes[j].x
									+ (Global.taille_bloc / 2 - Global.refresh / 2),
							Global.map.fantomes[j].y, null);
				}
			} else { /* DIRECTION = DROITE */
				if (Global.map.fantomes[j].nb_tour_vulnerable == 0) {
					g.drawImage(Global.map.fantomes[j].getImageFantome(),
							Global.map.fantomes[j].x
									- (Global.taille_bloc - Global.refresh),
							Global.map.fantomes[j].y, null);
				} else {
					g.drawImage(
							Global.map.fantomes[j].getImageFantome(),
							Global.map.fantomes[j].x
									- (Global.taille_bloc / 2 - Global.refresh / 2),
							Global.map.fantomes[j].y, null);
				}
			}
		}
	}

	public void maj_corner() {
		int j;
		for (j = 0; j < Global.nb_pacmen + Global.nbjoueurs; j++) {
			if (Global.map.pacmen[j].d == Direction.Haut) {
				if (!Global.map.pacmen[j].case_haut_valide()) {
					if (Global.map.pacmen[j] instanceof PacmanJoueur) {
						((PacmanJoueur) Global.map.pacmen[j]).corner = true;
					}
				}
			} else if (Global.map.pacmen[j].d == Direction.Bas) {
				if (!Global.map.pacmen[j].case_bas_valide()) {
					if (Global.map.pacmen[j] instanceof PacmanJoueur) {
						((PacmanJoueur) Global.map.pacmen[j]).corner = true;
					}
				}
			} else if (Global.map.pacmen[j].d == Direction.Gauche) {
				if (!Global.map.pacmen[j].case_gauche_valide()) {
					if (Global.map.pacmen[j] instanceof PacmanJoueur) {
						((PacmanJoueur) Global.map.pacmen[j]).corner = true;
					}
				}
			} else {/* DIRECTION = DROITE */
				if (!Global.map.pacmen[j].case_droite_valide()) {
					if (Global.map.pacmen[j] instanceof PacmanJoueur) {
						((PacmanJoueur) Global.map.pacmen[j]).corner = true;
					}
				}
			}

		}
	}

	public void draw_pacman(Graphics g) {

		int j;

		/* DECORS */
		draw_dec(g);
		/* DRAW FANTOMES */
		draw_fantomes(g);

		/* DRAW PACMAN */
		for (j = 0; j < Global.nb_pacmen + Global.nbjoueurs; j++) {

			if (Global.map.pacmen[j].d == Direction.Haut) {
				if ((Global.map.pacmen[j] instanceof PacmanJoueur)
						&& ((PacmanJoueur) Global.map.pacmen[j]).corner) {
					g.drawImage(Global.map.pacmen[j].getImagePacman(),
							Global.map.pacmen[j].x, Global.map.pacmen[j].y,
							null);

				} else {
					g.drawImage(Global.map.pacmen[j].getImagePacman(),
							Global.map.pacmen[j].x, Global.map.pacmen[j].y
									+ (Global.taille_bloc - Global.refresh),
							null);
				}
			} else if (Global.map.pacmen[j].d == Direction.Bas) {
				if ((Global.map.pacmen[j] instanceof PacmanJoueur)
						&& ((PacmanJoueur) Global.map.pacmen[j]).corner) {
					g.drawImage(Global.map.pacmen[j].getImagePacman(),
							Global.map.pacmen[j].x, Global.map.pacmen[j].y,
							null);

				} else {
					g.drawImage(Global.map.pacmen[j].getImagePacman(),
							Global.map.pacmen[j].x, Global.map.pacmen[j].y
									- (Global.taille_bloc - Global.refresh),
							null);
				}
			} else if (Global.map.pacmen[j].d == Direction.Gauche) {
				if ((Global.map.pacmen[j] instanceof PacmanJoueur)
						&& ((PacmanJoueur) Global.map.pacmen[j]).corner) {
					g.drawImage(Global.map.pacmen[j].getImagePacman(),
							Global.map.pacmen[j].x, Global.map.pacmen[j].y,
							null);
				} else {

					g.drawImage(Global.map.pacmen[j].getImagePacman(),
							Global.map.pacmen[j].x
									+ (Global.taille_bloc - Global.refresh),
							Global.map.pacmen[j].y, null);

				}

			} else { /* DIRECTION = DROITE */
				if ((Global.map.pacmen[j] instanceof PacmanJoueur)
						&& ((PacmanJoueur) Global.map.pacmen[j]).corner) {
					g.drawImage(Global.map.pacmen[j].getImagePacman(),
							Global.map.pacmen[j].x, Global.map.pacmen[j].y,
							null);
				} else {
					g.drawImage(Global.map.pacmen[j].getImagePacman(),
							Global.map.pacmen[j].x
									- (Global.taille_bloc - Global.refresh),
							Global.map.pacmen[j].y, null);
				}
			}
		}
		g.dispose();
		toolkit.sync();

	}

}