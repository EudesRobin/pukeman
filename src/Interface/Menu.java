package Interface;

import java.awt.*;
import java.awt.event.*;
           
import javax.swing.*;

import pacman.Global;

/**
 * Initialisation du menu
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

@SuppressWarnings("serial")
public class Menu extends JFrame {

	public static JPanel jeuCartes;
	public static CardLayout gestionnaireDeFenetre;
	Font font = new Font("Copperplate", Font.BOLD, 16);

	public Menu() {

		this.setTitle("PacMan Menu");
		this.setSize(Global.largeurfenmenu, Global.hauteurfenmenu);
		this.setResizable(false);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Global.men.setVisible(false);
				Global.men.dispose();
			}
		});
		this.setIconImage(Global.icon.getImage());

		JPanel backmenu = new JPanel();
		backmenu.setPreferredSize(new Dimension(250, 500));

		JLabel caleg = new JLabel(new ImageIcon("./img/fondmenug.png"));
		caleg.setBackground(Color.black);
		caleg.setPreferredSize(new Dimension(125, 400));

		JLabel caled = new JLabel(new ImageIcon("./img/fondmenud.png"));
		caled.setBackground(Color.black);
		caled.setPreferredSize(new Dimension(125, 400));

		JLabel caleh = new JLabel(new ImageIcon("./img/fondmenuh.png"));
		caleh.setBackground(Color.black);
		caleh.setPreferredSize(new Dimension(500, 100));

		JLabel caleb = new JLabel(new ImageIcon("./img/fondmenub.png"));
		caleb.setBackground(Color.black);
		caleb.setPreferredSize(new Dimension(500, 100));

		this.setLayout(new BorderLayout());
		this.getContentPane().add(caleh, BorderLayout.NORTH);
		this.getContentPane().add(caleg, BorderLayout.WEST);
		this.getContentPane().add(backmenu, BorderLayout.CENTER);
		this.getContentPane().add(caled, BorderLayout.EAST);
		this.getContentPane().add(caleb, BorderLayout.SOUTH);

		Global.pause_btn_menu.setFocusPainted(false);
		Global.pause_btn_menu.setMargin(null);
		Global.pause_btn_menu.setBorder(BorderFactory.createEmptyBorder());
		Global.pause_btn_menu.setContentAreaFilled(false);

		Global.help.setFocusPainted(false);
		Global.help.setMargin(null);
		Global.help.setBorder(BorderFactory.createEmptyBorder());
		Global.help.setContentAreaFilled(false);

		Global.stringHS = new JLabel("<HTML>HighScore Facile : "
				+ Integer.toString(Global.hseasy) + "<br>HighScore Moyen : "
				+ Integer.toString(Global.hsmedium)
				+ "<br>HighScore Difficile : "
				+ Integer.toString(Global.hshard), SwingConstants.CENTER);
		Global.stringHS.setFont(font);
		Global.stringHS.setForeground(Color.yellow);
		Global.pac.setLayout(new BorderLayout());
		Global.pac.add(Global.stringHS);

		Global.pac.setFocusPainted(false);
		Global.pac.setMargin(null);
		Global.pac.setBorder(BorderFactory.createEmptyBorder());
		Global.pac.setContentAreaFilled(false);

		Global.exit_btn_menu.setFocusPainted(false);
		Global.exit_btn_menu.setMargin(null);
		Global.exit_btn_menu.setBorder(BorderFactory.createEmptyBorder());
		Global.exit_btn_menu.setContentAreaFilled(false);

		backmenu.setLayout(new GridLayout(4, 1));
		backmenu.add(Global.pause_btn_menu);
		backmenu.add(Global.help);
		backmenu.add(Global.exit_btn_menu);
		backmenu.add(Global.pac);

		backmenu.requestFocus();

		// Activation des boutons
		Global.pause_btn_menu.addActionListener(new Pause_button());
		Global.exit_btn_menu.addActionListener(new Exit_button());
		Global.help.addActionListener(new help_button());

		JTextArea helpText = new JTextArea();
		helpText.setLineWrap(true);
		helpText.setWrapStyleWord(true);
		helpText.setEditable(false);
		helpText.setSize(Global.largeurfenmenu, Global.hauteurfenmenu - 100);
		Font fonthelp = new Font("Copperplate", Font.BOLD, 12);
		helpText.setFont(fonthelp);
		helpText.setText("Mode 1 joueur:\n \nDéplacez-vous à l'aide de Z,Q,S,D. "
				+ "\nTrois pacmans automatisés sont là pour vous aider !\n"
				+ "\nMode 2 joueurs:\n \nLe joueur 1 dirige son pacman"
				+ "avec Z,Q,S,D, le second joueur avec les flèches directionnelles."
				+ "\nDeux pacmans automatisés vous assistent.\n \n"
				+ "Déplacez-vous dans le labyrinthe tout en évitant les fantômes, et ramasez tous les pacgums.\n"
				+ "\nDes bonus sont disponibles :\n\n-> Invulnerabilité face aux fantomes (activez-le avec X)\n-> Invisibilité ( activez-le avec C)\n-> Récupération"
				+ "des pacgums dans une zone (activez-le avec V)\n-> Invulnérabilité aux zones de danger (récupérez le flag et vous serez immunisé"
				+ " pendant 20 tours lorsque vous traverserez une zone de danger).");
		JLabel helpT = new JLabel();
		Global.retourMenu.addActionListener(new help_button());
		helpT.setLayout(new BorderLayout());
		helpT.add(helpText, BorderLayout.NORTH);
		helpT.add(Global.retourMenu, BorderLayout.SOUTH);

		jeuCartes = new JPanel();
		gestionnaireDeFenetre = new CardLayout();
		jeuCartes.setLayout(gestionnaireDeFenetre);
		jeuCartes.add(backmenu, "backmenu");
		jeuCartes.add(helpT, "help");

		add(jeuCartes, BorderLayout.CENTER);

		this.setVisible(true);

	}

}
