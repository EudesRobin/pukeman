package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ordonnanceur.Ordonnanceur;
import pacman.Global;
import Monde.Map.Matrice;

/**
 * Gestion évènementielle des boutons de la fenêtre de dialogue (choix en début
 * de partie)
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class dialog_bouton implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source == Global.okdiag) {
			Global.dInfo = new DialogInfo(Global.dia.getdiff(),
					Global.dia.getnbPM(), Global.dia.getnbFT());
			Global.dia.setVisible(false);
			Global.men.setVisible(false);
			Global.bool_game = true;
			if (Global.nbjoueurs == 2) {
				Global.nb_pacmen = 2;
			} else {
				Global.nb_pacmen = 3;
			}
			Global.map = new Matrice();
			if (!Global.rejoue) {
				Global.fen = new FenetreDeJeu();
			} else {
				Global.fen.setVisible(true);
			}
			Global.map.carte1();
			Global.ordo = new Ordonnanceur();
			Global.ordo.gameLoop();
		}
		if (source == Global.annulediag) {
			Global.dia.setVisible(false);

		}

	}

}
