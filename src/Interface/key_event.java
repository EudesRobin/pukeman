package Interface;

import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;

import Monde.Items.Invincible;
import Monde.Items.Invisible;
import Monde.Items.RamasseGum;
import Monde.Perso.Direction;
import Monde.Perso.PacmanJoueur;
import pacman.Global;

/**
 * Gestion evenementielle des touches du clavier et gestion des bonus ou
 * déplacements associes
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class key_event implements AWTEventListener {

	@Override
	public void eventDispatched(AWTEvent event) {
		KeyEvent ke = (KeyEvent) event;

		if (ke.getID() == KeyEvent.KEY_PRESSED && !Global.end_game) {
			switch (Global.nbjoueurs) {
			case 1:
				if (ke.getKeyCode() == KeyEvent.VK_Z) {
					maj_dir(Direction.Haut, 0);
				} else if (ke.getKeyCode() == KeyEvent.VK_Q) {
					maj_dir(Direction.Gauche, 0);
				} else if (ke.getKeyCode() == KeyEvent.VK_S) {
					maj_dir(Direction.Bas, 0);
				} else if (ke.getKeyCode() == KeyEvent.VK_D) {
					maj_dir(Direction.Droite, 0);
				} else if (ke.getKeyCode() == KeyEvent.VK_V) {
					maj_bonus_ramassegum();
				} else if (ke.getKeyCode() == KeyEvent.VK_X) {
					maj_bonus_invulnerable();
				} else if (ke.getKeyCode() == KeyEvent.VK_C) {
					maj_bonus_invisible();
				}
				break;
			default:
				if (ke.getKeyCode() == KeyEvent.VK_Z) {
					maj_dir(Direction.Haut, 0);
				} else if (ke.getKeyCode() == KeyEvent.VK_Q) {
					maj_dir(Direction.Gauche, 0);
				} else if (ke.getKeyCode() == KeyEvent.VK_S) {
					maj_dir(Direction.Bas, 0);
				} else if (ke.getKeyCode() == KeyEvent.VK_D) {
					maj_dir(Direction.Droite, 0);
				} else if (ke.getKeyCode() == KeyEvent.VK_UP) {
					maj_dir(Direction.Haut, 1);
				} else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
					maj_dir(Direction.Bas, 1);
				} else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
					maj_dir(Direction.Gauche, 1);
				} else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
					maj_dir(Direction.Droite, 1);
				} else if (ke.getKeyCode() == KeyEvent.VK_V) {
					maj_bonus_ramassegum();
				} else if (ke.getKeyCode() == KeyEvent.VK_X) {
					maj_bonus_invulnerable();
				} else if (ke.getKeyCode() == KeyEvent.VK_C) {
					maj_bonus_invisible();
				}
				break;
			}

		}
	}

	public void maj_dir(Direction d, int player) {
		((PacmanJoueur) Global.map.pacmen[player]).attente = d;
	}


	public void maj_bonus_ramassegum() {
		int i,j;
		for (i = 0; i < Global.nb_pacmen + Global.nbjoueurs; i++) {
			if (Global.map.pacmen[i].containsBonus(new RamasseGum())) {
				for(j=0;j<Global.nb_pacmen+Global.nbjoueurs;j++){
					Global.map.active_RamasseGum(j);
				}
				Global.map.pacmen[i].removeBonus(new RamasseGum());
				Global.fen.setBonusInactif(i + 1, 4);
			}
		}
	}

	public void maj_bonus_invulnerable() {
		int i, j;
		for (i = 0; i < Global.nb_pacmen + Global.nbjoueurs; i++) {
			if (Global.map.pacmen[i].containsBonus(new Invincible())) {
				for (j = 0; j < Global.nb_pacmen + Global.nbjoueurs; j++) {
					Global.map.active_Invincible(j, 40);
				}
				Global.map.pacmen[i].removeBonus(new Invincible());
				Global.fen.setBonusInactif(i + 1, 2);
			}
		}
	}
	
	public void maj_bonus_invisible() {
		int i, j;
		for (i = 0; i < Global.nb_pacmen + Global.nbjoueurs; i++) {
			if (Global.map.pacmen[i].containsBonus(new Invisible())) {
				for (j = 0; j < Global.nb_pacmen + Global.nbjoueurs; j++) {
					Global.map.active_Invisible(j, 40);
				}
				Global.map.pacmen[i].removeBonus(new Invisible());
				Global.fen.setBonusInactif(i + 1, 3);
			}
		}
	}
}
