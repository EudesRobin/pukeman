package Monde.Map;

import java.awt.Image;

import pacman.Global;

/**
 * Interrupteur ouvrant et fermant les portes
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Interrupteur extends Case {
	private Image inter;
	private Porte[] tabp;

	public Interrupteur(Porte[] p) {
		this.tabp = new Porte[p.length];
		int i;
		for (i = 0; i < p.length; i++) {
			this.tabp[i] = p[i];
		}

		this.inter = Global.iblanc.getImage();

	}

	public void run() {
		int i;
		for (i = 0; i < tabp.length; i++) {
			if (tabp[i].id == Global.id_int) {
				tabp[i].Ouvre();
			} else {
				tabp[i].Ferme();
			}
		}
		if (Global.id_int < 2) {
			Global.id_int++;
		} else {
			Global.id_int = 0;
		}
	}

	public Image getImageCase() {
		return inter;
	}

}
