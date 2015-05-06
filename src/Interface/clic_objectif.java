package Interface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import pacman.EnumDifficulte;
import pacman.Global;
import Monde.Perso.PacmanAuto;

/**
 * Gestion des clics souris sur objectif
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class clic_objectif implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		if (EnumDifficulte.diff == "Difficile") {
			Object o = e.getSource();

			if (o == Global.j2) {
				if (Global.nbjoueurs == 1) {
					((PacmanAuto) Global.map.pacmen[1]).clic = true;
				}
			} else if (o == Global.j3) {
				((PacmanAuto) Global.map.pacmen[2]).clic = true;
			} else if (o == Global.j4) {
				((PacmanAuto) Global.map.pacmen[3]).clic = true;
			}

			if (o == Global.backjeu) {
				// Vérifier si c'est un pacmanauto avant de caster
				if (((PacmanAuto) Global.map.pacmen[1]).clic) {
					((PacmanAuto) Global.map.pacmen[1]).obj_y = e.getY();
					((PacmanAuto) Global.map.pacmen[1]).obj_x = e.getX();
					System.out.println("Objectif du pacman 2 -> x:y "
							+ ((PacmanAuto) Global.map.pacmen[1]).obj_x/20 + ":"
							+ ((PacmanAuto) Global.map.pacmen[1]).obj_y/20);
				} else if (((PacmanAuto) Global.map.pacmen[2]).clic) {
					((PacmanAuto) Global.map.pacmen[2]).obj_y = e.getY();
					((PacmanAuto) Global.map.pacmen[2]).obj_x = e.getX();
					System.out.println("Objectif du pacman 3 -> x:y "
							+ ((PacmanAuto) Global.map.pacmen[2]).obj_x/20 + ":"
							+ ((PacmanAuto) Global.map.pacmen[2]).obj_y/20);
				} else if (((PacmanAuto) Global.map.pacmen[3]).clic) {
					((PacmanAuto) Global.map.pacmen[3]).obj_y = e.getY();
					((PacmanAuto) Global.map.pacmen[3]).obj_x = e.getX();
					System.out.println("Objectif du pacman 4 -> x:y "
							+ ((PacmanAuto) Global.map.pacmen[3]).obj_x/20 + ":"
							+ ((PacmanAuto) Global.map.pacmen[3]).obj_y/20);
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
