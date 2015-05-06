package Interface;

import javax.swing.JFrame;
import pacman.Global;

/**
 * Appel de la méthode d'initialisatin de la fenetre de dialogue et affichage
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

@SuppressWarnings("serial")
public class FenetreDialog extends JFrame {

	public FenetreDialog() {
		Global.dia = new Dialog(null, "Choix du mode de jeu", true);
		Global.dInfo = Global.dia.showZDialog();
	}

}
