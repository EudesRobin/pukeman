package pacman;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import ordonnanceur.Ordonnanceur;
import Interface.*;
import Monde.Map.*;

/**
 * Diverses variables facilement acceccible, les illustrations du jeu, des
 * compteurs...
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */
public class Global {
	public enum Mode {
		VS, COOP
	}

	public static final int hauteurfen = 700;
	public static final int largeurfen = 1300;
	public static final int hauteurfenmenu = 700;
	public static final int largeurfenmenu = 500;
	public static final int hfenjeu = hauteurfen;
	public static final int largeur_menu = 280;
	public static final int lfenjeu = largeurfen - largeur_menu;
	public static final int taille_bloc = 20;
	public static int refresh = 1;
	public static int bonus_amount = 10;
	public static final long defaultspeed = 1;
	public static final int pas = 1;

	/* Vitesse de rafraichissement */
	public static final long fps = 20;

	/* Nombre de pacgum */
	public static int nb_pacgum;

	/* Nombre de fantomes */
	public static int nb_fantomes;

	/* Nombre de pacman automatiques */
	public static int nb_pacmen;

	/* Nombre de joueur (humains cette fois) */
	public static int nbjoueurs;

	/* Identifiant de l'interrupteur */
	public static int id_int = 0;

	// Tableau des bonus
	public static JLabel[] tabonus = new JLabel[16];

	// Couleur des joueurs
	public static final Color colorj1 = Color.yellow;
	public static final Color colorj2 = Color.red;
	public static final Color colorj3 = Color.blue;
	public static final Color colorj4 = Color.green;

	public static int scorej1 = 0;
	public static int scorej2 = 0;
	public static int scorej3 = 0;
	public static int scorej4 = 0;

	/* Score équipe */
	public static int scorecoop = 0;

	/* Version String (solo , equipe ) */
	public static JLabel stringscorej1;
	public static JLabel stringscorej2;
	public static JLabel stringscorej3;
	public static JLabel stringscorej4;
	public static JLabel stringscorecoop;

	public static JLabel stringscoreendgame;

	public static JLabel flag1;
	public static JLabel flag2;
	public static JLabel flag3;
	public static JLabel flag4;

	/* Declarations Globales */
	public static Ordonnanceur ordo;
	public static FenetreDeJeu fen;
	public static Menu men;

	public static Font fontdefaite = new Font("Copperplate", Font.BOLD, 12);

	/* Lancement / arrêt de la boucle de jeu */
	static public boolean bool_game = false;

	/* Play/pause / find du jeu */
	static public boolean end_game = false;

	public static boolean running = false;
	public static boolean xmlLoaded = false;
	public static String imagefondmd = "./img/fondjeupricman.png";
	public static String imagefondf = "./img/wallpaper.png";

	public static final ImageIcon icon = new ImageIcon("./img/icon.png");
	public static ImageIcon playimg = new ImageIcon("./img/play.png");
	public static ImageIcon helpimg = new ImageIcon("./img/help.png");
	public static ImageIcon quitimg = new ImageIcon("./img/quit.png");
	public static ImageIcon pacimg = new ImageIcon("./img/pac.png");

	// Pour la fenetre de jeu
	public static ImageIcon quitjeuimg = new ImageIcon("./img/quitter.png");
	public static ImageIcon pauseimg = new ImageIcon("./img/pause.png");
	public static ImageIcon reprendreimg = new ImageIcon("./img/reprendre.png");

	public static JLabel j4 = new JLabel(new ImageIcon("./img/joueur4.png"));
	public static JLabel j3 = new JLabel(new ImageIcon("./img/joueur3.png"));
	public static JLabel j2 = new JLabel(new ImageIcon("./img/joueur2.png"));
	public static JLabel j1 = new JLabel(new ImageIcon("./img/joueur1.png"));

	public static JLabel stringHS;

	public static final ImageIcon joueur2obj = new ImageIcon(
			"./img/joueur2versobj.png");
	public static final ImageIcon joueur3obj = new ImageIcon(
			"./img/joueur3versobj.png");
	public static final ImageIcon joueur4obj = new ImageIcon(
			"./img/joueur4versobj.png");

	public static final ImageIcon fondmenu = new ImageIcon("./img/fondmenu.png");

	public static final ImageIcon pacmanbj1 = new ImageIcon("./img/pacmanb.png");
	public static final ImageIcon pacmandj1 = new ImageIcon("./img/pacmand.png");
	public static final ImageIcon pacmangj1 = new ImageIcon("./img/pacmang.png");
	public static final ImageIcon pacmanhj1 = new ImageIcon("./img/pacmanh.png");

	public static final ImageIcon pacmancbj1 = new ImageIcon(
			"./img/pacmancbas.png");
	public static final ImageIcon pacmancdj1 = new ImageIcon(
			"./img/pacmancdroite.png");
	public static final ImageIcon pacmancgj1 = new ImageIcon(
			"./img/pacmancgauche.png");
	public static final ImageIcon pacmanchj1 = new ImageIcon(
			"./img/pacmanchaut.png");

	public static final ImageIcon pacmanibj1 = new ImageIcon(
			"./img/pacmaninvisj1b.png");
	public static final ImageIcon pacmanidj1 = new ImageIcon(
			"./img/pacmaninvisj1d.png");
	public static final ImageIcon pacmanigj1 = new ImageIcon(
			"./img/pacmaninvisj1g.png");
	public static final ImageIcon pacmanihj1 = new ImageIcon(
			"./img/pacmaninvisj1h.png");

	public static final ImageIcon pacmanbj2 = new ImageIcon(
			"./img/pacmanbas2.png");
	public static final ImageIcon pacmandj2 = new ImageIcon(
			"./img/pacmandroite2.png");
	public static final ImageIcon pacmangj2 = new ImageIcon(
			"./img/pacmangauche2.png");
	public static final ImageIcon pacmanhj2 = new ImageIcon(
			"./img/pacmanhaut2.png");

	public static final ImageIcon pacmancbj2 = new ImageIcon(
			"./img/pacmancbas2.png");
	public static final ImageIcon pacmancdj2 = new ImageIcon(
			"./img/pacmancdroite2.png");
	public static final ImageIcon pacmancgj2 = new ImageIcon(
			"./img/pacmancgauche2.png");
	public static final ImageIcon pacmanchj2 = new ImageIcon(
			"./img/pacmanchaut2.png");

	public static final ImageIcon pacmanibj2 = new ImageIcon(
			"./img/pacmaninvisj2b.png");
	public static final ImageIcon pacmanidj2 = new ImageIcon(
			"./img/pacmaninvisj2d.png");
	public static final ImageIcon pacmanigj2 = new ImageIcon(
			"./img/pacmaninvisj2g.png");
	public static final ImageIcon pacmanihj2 = new ImageIcon(
			"./img/pacmaninvisj2h.png");

	public static final ImageIcon pacmanbj3 = new ImageIcon(
			"./img/pacmanbas3.png");
	public static final ImageIcon pacmandj3 = new ImageIcon(
			"./img/pacmandroite3.png");
	public static final ImageIcon pacmangj3 = new ImageIcon(
			"./img/pacmangauche3.png");
	public static final ImageIcon pacmanhj3 = new ImageIcon(
			"./img/pacmanhaut3.png");

	public static final ImageIcon pacmancbj3 = new ImageIcon(
			"./img/pacmancbas3.png");
	public static final ImageIcon pacmancdj3 = new ImageIcon(
			"./img/pacmancdroite3.png");
	public static final ImageIcon pacmancgj3 = new ImageIcon(
			"./img/pacmancgauche3.png");
	public static final ImageIcon pacmanchj3 = new ImageIcon(
			"./img/pacmanchaut3.png");

	public static final ImageIcon pacmanibj3 = new ImageIcon(
			"./img/pacmaninvisj3b.png");
	public static final ImageIcon pacmanidj3 = new ImageIcon(
			"./img/pacmaninvisj3d.png");
	public static final ImageIcon pacmanigj3 = new ImageIcon(
			"./img/pacmaninvisj3g.png");
	public static final ImageIcon pacmanihj3 = new ImageIcon(
			"./img/pacmaninvisj3h.png");

	public static final ImageIcon pacmanbj4 = new ImageIcon(
			"./img/pacmanbas4.png");
	public static final ImageIcon pacmandj4 = new ImageIcon(
			"./img/pacmandroite4.png");
	public static final ImageIcon pacmangj4 = new ImageIcon(
			"./img/pacmangauche4.png");
	public static final ImageIcon pacmanhj4 = new ImageIcon(
			"./img/pacmanhaut4.png");

	public static final ImageIcon pacmancbj4 = new ImageIcon(
			"./img/pacmancbas4.png");
	public static final ImageIcon pacmancdj4 = new ImageIcon(
			"./img/pacmancdroite4.png");
	public static final ImageIcon pacmancgj4 = new ImageIcon(
			"./img/pacmancgauche4.png");
	public static final ImageIcon pacmanchj4 = new ImageIcon(
			"./img/pacmanchaut4.png");

	public static final ImageIcon pacmanibj4 = new ImageIcon(
			"./img/pacmaninvisj4b.png");
	public static final ImageIcon pacmanidj4 = new ImageIcon(
			"./img/pacmaninvisj4d.png");
	public static final ImageIcon pacmanigj4 = new ImageIcon(
			"./img/pacmaninvisj4g.png");
	public static final ImageIcon pacmanihj4 = new ImageIcon(
			"./img/pacmaninvisj4h.png");

	public static final ImageIcon portebo = new ImageIcon("./img/portevb.png");
	public static final ImageIcon portebf = new ImageIcon("./img/portehb.png");

	public static final ImageIcon fantomerouge = new ImageIcon(
			"./img/Sprite_fantome_rouge_transparent.png");
	public static final ImageIcon fantomerose = new ImageIcon(
			"./img/Sprite_fantome_rose_transparent.png");
	public static final ImageIcon fantomebleu = new ImageIcon(
			"./img/Sprite_fantome_bleu_transparent.png");
	public static final ImageIcon fantomevert = new ImageIcon(
			"./img/Sprite_fantome_vert_transparent.png");
	public static final ImageIcon fantomecyan = new ImageIcon(
			"./img/Sprite_fantome_cyan_transparent.png");
	public static final ImageIcon fantomeorange = new ImageIcon(
			"./img/Sprite_fantome_orange_transparent.png");
	public static final ImageIcon fantomeblanc = new ImageIcon(
			"./img/Sprite_fantome_blanc_transparent.png");
	public static final ImageIcon fantomejaune = new ImageIcon(
			"./img/Sprite_fantome_jaune_transparent.png");
	public static final ImageIcon fantomenoir = new ImageIcon(
			"./img/Sprite_fantome_noir_transparent.png");
	public static final ImageIcon fantomepeur = new ImageIcon(
			"./img/fantomepeur.png");

	public static final ImageIcon prougeo = new ImageIcon("./img/porterf.png");
	public static final ImageIcon prougef = new ImageIcon("./img/portero.png");
	public static final ImageIcon pblancf = new ImageIcon("./img/porteblf.png");
	public static final ImageIcon pblanco = new ImageIcon("./img/porteblo.png");
	public static final ImageIcon pbleuo = new ImageIcon("./img/portebf.png");
	public static final ImageIcon pbleuf = new ImageIcon("./img/portebo.png");
	public static final ImageIcon pjaunef = new ImageIcon("./img/portejf.png");
	public static final ImageIcon pjauneo = new ImageIcon("./img/portejo.png");
	public static final ImageIcon porangeo = new ImageIcon("./img/porteorf.png");
	public static final ImageIcon porangef = new ImageIcon("./img/porteoro.png");
	public static final ImageIcon prosef = new ImageIcon("./img/porterof.png");
	public static final ImageIcon proseo = new ImageIcon("./img/porteroo.png");
	public static final ImageIcon pverto = new ImageIcon("./img/portevef.png");
	public static final ImageIcon pvertf = new ImageIcon("./img/portevo.png");
	public static final ImageIcon pvioletf = new ImageIcon(
			"./img/porteviof.png");
	public static final ImageIcon pvioleto = new ImageIcon(
			"./img/portevioo.png");

	public static final ImageIcon iblanc = new ImageIcon("./img/interb.png");
	public static final ImageIcon irouge = new ImageIcon("./img/interrouge.png");
	public static final ImageIcon ibleu = new ImageIcon("./img/interbleu.png");
	public static final ImageIcon ijaune = new ImageIcon("./img/interjaune.png");
	public static final ImageIcon iorange = new ImageIcon(
			"./img/interorange.png");
	public static final ImageIcon irose = new ImageIcon("./img/interrose.png");
	public static final ImageIcon ivert = new ImageIcon("./img/intervert.png");
	public static final ImageIcon iviolet = new ImageIcon(
			"./img/interviolet.png");

	public static final ImageIcon ramassegum = new ImageIcon(
			"./img/ramassegum.png");
	public static final ImageIcon invincible = new ImageIcon(
			"./img/invincible.png");
	public static final ImageIcon invisible = new ImageIcon(
			"./img/invisible.png");
	public static final ImageIcon flag = new ImageIcon("./img/flag.png");
	public static final ImageIcon danger = new ImageIcon("./img/dangerr.png");
	public static final ImageIcon portef = new ImageIcon("./img/portehj.png");

	public static final ImageIcon ramassetout = new ImageIcon(
			"./img/ramassetout.png");

	public static final ImageIcon replay = new ImageIcon("./img/rejouer.png");
	public static final ImageIcon quitterfin = new ImageIcon(
			"./img/quitterfin.png");

	public static final ImageIcon accelerateurd = new ImageIcon(
			"./img/boosterd.png");

	public static final ImageIcon superpacgum = new ImageIcon(
			"./img/gumgum.png");
	public static final ImageIcon pacgum = new ImageIcon("./img/pacgum.png");
	public static final ImageIcon trash = new ImageIcon("./img/gum.png");

	public static final ImageIcon mur = new ImageIcon("./img/mur.png");

	static public JButton okdiag = new JButton("OK");
	static public JButton annulediag = new JButton("Annuler");
	static public JButton pause_btn_game = new JButton(pauseimg);
	static public JButton exit_btn_game = new JButton(quitjeuimg);
	static public JButton pause_btn_menu = new JButton(playimg);
	static public JButton exit_btn_menu = new JButton(quitimg);
	static public JButton exit_btn_help;
	public static JButton pac = new JButton(pacimg);
	public static JButton help = new JButton(helpimg);
	public static JButton retourMenu = new JButton("Retour au menu");

	public static JButton rejouer = new JButton(replay);
	public static JButton exitfinjeu = new JButton(quitterfin);

	static public Map backjeu;
	static public Matrice map;
	static public Dialog dia;
	static public FinDuJeu endgame;
	static public Highscore high;

	public static int hseasy, hsmedium, hshard;

	public static boolean rejoue = false;
	public static boolean dia_enable = false;
	static public DialogInfo dInfo;

}
