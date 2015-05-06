package Interface;

import pacman.Global;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * Affichage fenetre de fin de jeu avec rappel des scores et boutons
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class FinDuJeu extends JFrame {

	private static final long serialVersionUID = 1L;

	public FinDuJeu() {
		this.setTitle("Fin du jeu");
		this.setSize(Global.largeur_menu, 420);
		this.setResizable(false);
		this.setIconImage(Global.icon.getImage());
		this.setLayout(new GridLayout(7, 1));

		Dimension dim = new Dimension(Global.largeur_menu, this.getWidth() / 4);

		// VICTOIRE
		JLabel victory = new JLabel();
		if (Global.nb_pacgum == 0) {
			ImageIcon icon = new ImageIcon("./img/victoire.png");
			victory.setIcon(icon);
		} else {
			ImageIcon icon = new ImageIcon("./img/findugame.png");
			victory.setIcon(icon);
		}
		victory.setSize(dim);

		// Score global
		JLabel affichescore = new JLabel(new ImageIcon("./img/score.png"));
		affichescore.setSize(dim);
		affichescore.add(Global.stringscorecoop);

		// Joueur 1

		JLabel j1 = new JLabel(new ImageIcon("./img/joueur1.png"));
		j1.setSize(dim);
		j1.setLayout(new BorderLayout());

		// Joueur 2
		JLabel j2 = new JLabel(new ImageIcon("./img/joueur2.png"));
		j2.setSize(dim);
		j2.setLayout(new BorderLayout());

		// Joueur 3
		JLabel j3 = new JLabel(new ImageIcon("./img/joueur3.png"));
		j3.setSize(dim);
		j3.setLayout(new BorderLayout());

		// Joueur 4
		JLabel j4 = new JLabel(new ImageIcon("./img/joueur4.png"));
		j4.setSize(dim);
		j4.setLayout(new BorderLayout());

		// Boutons
		JPanel btn = new JPanel();
		btn.setLayout(new GridLayout(1, 2));

		j1.add(Global.stringscorej1);
		j2.add(Global.stringscorej2);
		j3.add(Global.stringscorej3);
		j4.add(Global.stringscorej4);

		Global.rejouer.addActionListener(new Fin_bouton());
		Global.exitfinjeu.addActionListener(new Fin_bouton());

		Global.rejouer.setFocusPainted(false);
		Global.rejouer.setMargin(null);
		Global.rejouer.setBorder(BorderFactory.createEmptyBorder());
		Global.rejouer.setContentAreaFilled(false);

		Global.exitfinjeu.setFocusPainted(false);
		Global.exitfinjeu.setMargin(null);
		Global.exitfinjeu.setBorder(BorderFactory.createEmptyBorder());
		Global.exitfinjeu.setContentAreaFilled(false);

		btn.add(Global.rejouer);
		btn.add(Global.exitfinjeu);

		this.getContentPane().add(victory);
		this.getContentPane().add(affichescore);
		this.getContentPane().add(j1);
		this.getContentPane().add(j2);
		this.getContentPane().add(j3);
		this.getContentPane().add(j4);
		this.getContentPane().add(btn);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Global.endgame.setVisible(false);
				Global.endgame.dispose();
			}
		});

		this.setVisible(true);
	}
}
