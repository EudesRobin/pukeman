package Interface;

import java.awt.*;

import javax.swing.*;

import pacman.Global;

/**
 * Initialisation de la fenetre de dialogue permettant le choix de la
 * difficulte, nombre de joueurs et nb de fantômes
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

@SuppressWarnings("serial")
public class Dialog extends JDialog {

	private JLabel diffLabel;
	private JRadioButton joueur1, joueur2, fantome4, fantome6, fantome8;
	@SuppressWarnings("rawtypes")
	private JComboBox difficulte;
	ImageIcon fondialog = new ImageIcon("./img/fondialog.png");

	public Dialog(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(500, 240);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();
	}

	public DialogInfo showZDialog() {
		this.setVisible(true);
		return Global.dInfo;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponent() {
		// Difficulte
		JPanel diff = new JPanel();
		diff.setBackground(Color.white);
		diff.setPreferredSize(new Dimension(400, 100));
		diff.setBorder(BorderFactory.createTitledBorder("Difficulte"));
		difficulte = new JComboBox();
		difficulte.setBackground(Color.white);
		difficulte.addItem("Facile");
		difficulte.addItem("Moyen");
		difficulte.addItem("Difficile");
		diffLabel = new JLabel("Difficulte : ");
		diff.add(diffLabel);
		diff.add(difficulte);

		// Le nombre de pacman
		JPanel nbPM = new JPanel();
		nbPM.setBackground(Color.white);
		nbPM.setBorder(BorderFactory.createTitledBorder("Nombre de Joueurs"));
		nbPM.setPreferredSize(new Dimension(200, 200));
		joueur1 = new JRadioButton("1");
		joueur1.setBackground(Color.white);
		joueur1.setSelected(true);
		joueur2 = new JRadioButton("2");
		joueur2.setBackground(Color.white);
		ButtonGroup bgp = new ButtonGroup();
		bgp.add(joueur1);
		bgp.add(joueur2);
		nbPM.add(joueur1);
		nbPM.add(joueur2);

		// Le nombre de fantomes
		JPanel nbFT = new JPanel();
		nbFT.setBackground(Color.white);
		nbFT.setBorder(BorderFactory.createTitledBorder("Nombre de Fantomes"));
		nbFT.setPreferredSize(new Dimension(200, 200));
		fantome4 = new JRadioButton("4");
		fantome4.setBackground(Color.white);
		fantome4.setSelected(true);
		fantome6 = new JRadioButton("6");
		fantome6.setBackground(Color.white);
		fantome8 = new JRadioButton("8");
		fantome8.setBackground(Color.white);
		ButtonGroup bgf = new ButtonGroup();
		bgf.add(fantome4);
		bgf.add(fantome6);
		bgf.add(fantome8);
		nbFT.add(fantome4);
		nbFT.add(fantome6);
		nbFT.add(fantome8);

		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(diff);
		content.add(nbPM);
		content.add(nbFT);

		JPanel control = new JPanel();
		control.setBackground(Color.white);
		Global.okdiag.addActionListener(new dialog_bouton());
		Global.annulediag.addActionListener(new dialog_bouton());

		control.add(Global.okdiag);
		control.add(Global.annulediag);

		Global.okdiag.setFocusPainted(false);
		Global.okdiag.setContentAreaFilled(false);

		Global.annulediag.setFocusPainted(false);
		Global.annulediag.setContentAreaFilled(false);

		this.getContentPane().add(content, BorderLayout.NORTH);
		this.getContentPane().add(control, BorderLayout.SOUTH);

	}

	public int getnbPM() {
		return (joueur1.isSelected()) ? Integer.valueOf(joueur1.getText())
				: (joueur2.isSelected()) ? Integer.valueOf(joueur2.getText())
						: Integer.valueOf(joueur1.getText());
	}

	public int getnbFT() {
		return (fantome4.isSelected()) ? Integer.valueOf(fantome4.getText())
				: (fantome6.isSelected()) ? Integer.valueOf(fantome6.getText())
						: (fantome8.isSelected()) ? Integer.valueOf(fantome8
								.getText()) : Integer.valueOf(fantome4
								.getText());
	}

	public String getdiff() {
		return (String) difficulte.getSelectedItem();
	}
}
