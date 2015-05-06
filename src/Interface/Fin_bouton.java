package Interface;

import java.awt.event.*;
import javax.swing.ImageIcon;
import pacman.Global;

/**
 * Gestion evenementielle des boutons de fin de jeu
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Fin_bouton implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source == Global.rejouer) {
			Global.fen.setVisible(false);
			Global.endgame.setVisible(false);
			Global.endgame.dispose();
			Global.men.dispose();
			Global.rejoue = true;

			int i;
			for (i = 0; i < 16; i++) {
				Global.tabonus[i].setIcon(Global.fen.bonusinactif);
			}
			for (i = 1; i < 4; i++) {
				Global.map.pacmen[i].clic = false;
			}
			Global.high.newhs();
			Global.stringHS.setText("<HTML>HighScore Facile : "
					+ Integer.toString(Global.hseasy)
					+ "<br>HighScore Moyen : "
					+ Integer.toString(Global.hsmedium)
					+ "<br>HighScore Difficile : "
					+ Integer.toString(Global.hshard));
			Global.j2.setIcon(new ImageIcon("./img/joueur2.png"));
			Global.j3.setIcon(new ImageIcon("./img/joueur3.png"));
			Global.j4.setIcon(new ImageIcon("./img/joueur4.png"));
			Global.j1.add(Global.stringscorej1);
			Global.j2.add(Global.stringscorej2);
			Global.j3.add(Global.stringscorej3);
			Global.j4.add(Global.stringscorej4);
			Global.fen.affichescore.add(Global.stringscorecoop);

			Global.pause_btn_game.setIcon(Global.pauseimg);
			Global.end_game = false;

			Global.bool_game = true;
			Global.dia_enable = true;
			Global.men.setVisible(true);

		} else if (source == Global.exitfinjeu) {
			Global.fen.setVisible(false);
			Global.endgame.setVisible(false);
			Global.endgame.dispose();
			Global.fen.dispose();
			Global.men.dispose();
			Global.dia.dispose();
		}
	}
}
