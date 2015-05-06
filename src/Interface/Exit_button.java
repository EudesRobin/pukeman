package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pacman.Global;

/**
 * GEstion evenementielle des boutons de sortie du menu et de la fenetre de jeu
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Exit_button implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source == Global.exit_btn_game) {
			Global.bool_game = false;
			Global.fen.setVisible(false);
		} else if (source == Global.exit_btn_menu) {
			if (Global.bool_game) {
				Global.bool_game = false;
				Global.fen.dispose();
				Global.dia.dispose();
			}

			Global.men.setVisible(false);
			Global.men.dispose();

		}

	}

}
