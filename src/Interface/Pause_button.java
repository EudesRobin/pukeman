package Interface;

import java.awt.event.*;
import pacman.Global;

/**
 * Gestion evenementielle du bouton play du menu et du bouton pause de la
 * fenetre de jeu
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Pause_button implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source == Global.pause_btn_game) {
			if (!Global.end_game) {
				Global.pause_btn_game.setIcon(Global.reprendreimg);
				Global.end_game = true;
			} else {
				Global.pause_btn_game.setIcon(Global.pauseimg);
				Global.end_game = false;
			}

		} else if (source == Global.pause_btn_menu) {
			if (!Global.dia_enable) {
				Global.dia_enable = true;
				Global.dia = new Dialog(null, "Choix du mode de jeu", true);
				Global.dInfo = Global.dia.showZDialog();
			} else {
				Global.dia.setVisible(true);
			}
		}
	}
}
