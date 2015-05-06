package Interface;

import pacman.Global;
import Interface.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Gestion evenementielle du bouton d'aide du menu
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class help_button implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == Global.help) {
			Menu.gestionnaireDeFenetre.show(Menu.jeuCartes, "help");
		} else if (source == Global.retourMenu) {
			Menu.gestionnaireDeFenetre.show(Menu.jeuCartes, "backmenu");

		}
	}

}
