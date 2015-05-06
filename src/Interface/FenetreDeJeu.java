package Interface;

import pacman.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Initialisation de la fenêtre de jeu
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

@SuppressWarnings("serial")
public class FenetreDeJeu extends JFrame {
	
	
    ImageIcon bonusj1 = new ImageIcon("./img/bonusj1.png");
    ImageIcon bonusj2 = new ImageIcon("./img/bonusj2.png");
    ImageIcon bonusj3 = new ImageIcon("./img/bonusj3.png");
    ImageIcon bonusj4 = new ImageIcon("./img/bonusj4.png");
    ImageIcon bonusinactif = new ImageIcon("./img/bonusinactif.png");
    Font font = new Font("Copperplate", Font.BOLD, 30);
    Font font2 = new Font("Copperplate", Font.BOLD, 20);
    JLabel affichescore= new JLabel(new ImageIcon("./img/score.png"));
  
	public FenetreDeJeu(){
		    this.setTitle("PacMan");
		    this.setSize(Global.largeurfen ,Global.hauteurfen);
		    this.setResizable(false);
		    this.setIconImage(Global.icon.getImage());
		    
		    Toolkit.getDefaultToolkit().addAWTEventListener(new key_event(),AWTEvent.KEY_EVENT_MASK);

		    JPanel backscore = new JPanel();
		    backscore.setPreferredSize(new Dimension(Global.largeur_menu,Global.hauteurfen));
		    
		    JPanel opt = new JPanel();
		    opt.setPreferredSize(new Dimension(Global.largeur_menu, 400));
		    
		    JPanel score = new JPanel();
		    score.setPreferredSize(new Dimension(Global.largeur_menu, 300));
		    
		    JPanel scorejoueurs = new JPanel();
		    scorejoueurs.setBackground(Color.BLACK);
		    
		    
		    affichescore.setSize(new Dimension(Global.largeur_menu, 60));
		    affichescore.setLayout(new BorderLayout());
		    

		    scorejoueurs.setPreferredSize(new Dimension(Global.largeur_menu, 240));
		    
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		    
		    //On définit le layout à utiliser sur le content pane
		    this.setLayout(new BorderLayout());
		   
		    Global.backjeu = new Map(Global.lfenjeu,Global.hfenjeu);
		    Global.backjeu.setSize(Global.lfenjeu,Global.hfenjeu);
		    Global.backjeu.setPreferredSize(new Dimension(Global.lfenjeu,Global.hfenjeu));
		    Global.backjeu.addMouseListener(new clic_objectif());
		    //Interface.MainWindow.
		    this.getContentPane().add(backscore,BorderLayout.EAST);
		    this.getContentPane().add(Global.backjeu, BorderLayout.WEST);
		    
		    
		    backscore.setLayout(new BorderLayout());
		    backscore.add(opt, BorderLayout.SOUTH);
		    backscore.add(score, BorderLayout.NORTH);
		   
		    
		    score.setLayout(new BorderLayout());
		    score.add(affichescore, BorderLayout.NORTH);
		    score.add(scorejoueurs, BorderLayout.SOUTH);
		    
			//Ajout score de la coop
		    Global.stringscorecoop = new JLabel(Integer.toString(Global.scorecoop),SwingConstants.CENTER);
		    Global.stringscorecoop.setFont(font2);
		    Global.stringscorecoop.setForeground(Color.orange);
		    affichescore.add(Global.stringscorecoop);
		   
		    
		    //BoxLayout de joueurs
		    
		    scorejoueurs.setLayout(new BoxLayout(scorejoueurs,BoxLayout.PAGE_AXIS));
		    
		    
		    Dimension dim = new Dimension(Global.largeur_menu, scorejoueurs.getWidth()/4);
		    		    
		   //Joueur 1
		    Global.j1.setSize(dim);
		    Global.j1.setLayout(new BorderLayout());

		    
		    Global.stringscorej1 = new JLabel(Integer.toString(Global.scorej1),SwingConstants.CENTER);
		    Global.stringscorej1.setFont(font);
		    Global.stringscorej1.setForeground(Global.colorj1);
		    
		  //Joueur 2
		    Global.j2.setSize(dim);
		    Global.j2.setLayout(new BorderLayout());
		    Global.j2.addMouseListener(new clic_objectif());
		    
		    Global.stringscorej2 = new JLabel(Integer.toString(Global.scorej1),SwingConstants.CENTER);
		    Global.stringscorej2.setFont(font);
		    Global.stringscorej2.setForeground(Global.colorj2);
		    
		  //Joueur 3
		    Global.j3.setSize(dim);
		    Global.j3.setLayout(new BorderLayout());
		    Global.j3.addMouseListener(new clic_objectif());
		    
		    Global.stringscorej3 = new JLabel(Integer.toString(Global.scorej1),SwingConstants.CENTER);
		    Global.stringscorej3.setFont(font);
		    Global.stringscorej3.setForeground(Global.colorj3);
		    
		  //Joueur 4
		    Global.j4.setSize(dim);
		    Global.j4.setLayout(new BorderLayout());
		    Global.j4.addMouseListener(new clic_objectif());
		    
		    Global.stringscorej4 = new JLabel(Integer.toString(Global.scorej1),SwingConstants.CENTER);
		    Global.stringscorej4.setFont(font);
		    Global.stringscorej4.setForeground(Global.colorj4);
		    
		    
		    scorejoueurs.add(Global.j1);
		    scorejoueurs.add(Global.j2);
		    scorejoueurs.add(Global.j3);
		    scorejoueurs.add(Global.j4);
		    

		    Global.pause_btn_game.setIcon(Global.pauseimg);
		    
		    Global.j1.add(Global.stringscorej1);
		    Global.j2.add(Global.stringscorej2);
		    Global.j3.add(Global.stringscorej3);
		    Global.j4.add(Global.stringscorej4);
			
			//Timer flag
		    JLabel affflagj1 = new JLabel(new ImageIcon("./img/bonusinactif.png"));
		    JLabel affflagj2 = new JLabel(new ImageIcon("./img/bonusinactif.png"));
		    JLabel affflagj3 = new JLabel(new ImageIcon("./img/bonusinactif.png"));
		    JLabel affflagj4 = new JLabel(new ImageIcon("./img/bonusinactif.png"));
		    
		    affflagj1.setLayout(new BorderLayout());
		    affflagj2.setLayout(new BorderLayout());
		    affflagj3.setLayout(new BorderLayout());
		    affflagj4.setLayout(new BorderLayout());
		    
		    Global.flag1 = new JLabel(Integer.toString(Global.map.pacmen[0].nb_tour_flag),SwingConstants.CENTER);
		    Global.flag1.setFont(font2);
		    Global.flag1.setForeground(Global.colorj1);
		    
		    Global.flag2 = new JLabel(Integer.toString(Global.map.pacmen[1].nb_tour_flag),SwingConstants.CENTER);
		    Global.flag2.setFont(font2);
		    Global.flag2.setForeground(Global.colorj2);
		    
		    Global.flag3 = new JLabel(Integer.toString(Global.map.pacmen[2].nb_tour_flag),SwingConstants.CENTER);
		    Global.flag3.setFont(font2);
		    Global.flag3.setForeground(Global.colorj3);
		    
		    Global.flag4 = new JLabel(Integer.toString(Global.map.pacmen[3].nb_tour_flag),SwingConstants.CENTER);
		    Global.flag4.setFont(font2);
		    Global.flag4.setForeground(Global.colorj4);

		    
		    // Bouton Menu
		    JPanel menu_bouttons = new JPanel();
		    menu_bouttons.setPreferredSize(new Dimension(Global.largeur_menu, 40));
		    
		    JPanel bonus = new JPanel();
		    bonus.setPreferredSize(new Dimension(Global.largeur_menu, 360));
		    
		    opt.setLayout(new BorderLayout());
		    opt.add(menu_bouttons, BorderLayout.SOUTH);
		    opt.add(bonus, BorderLayout.NORTH);

		    	
		    menu_bouttons.setLayout(new GridLayout(1, 2));
		    
		    // Bonton pause / quit !
		    //Global.pause_btn_game = new JButton("Pause");
		    Global.pause_btn_game.addActionListener(new Pause_button());
		    //Global.exit_btn_game = new JButton("Quitter");
		    Global.exit_btn_game.addActionListener(new Exit_button());
		    
		    Global.exit_btn_game.setFocusPainted(false);
		    Global.exit_btn_game.setMargin(null);  
		    Global.exit_btn_game.setBorder(BorderFactory.createEmptyBorder());
		    Global.exit_btn_game.setContentAreaFilled(false); 
		    
		    Global.pause_btn_game.setFocusPainted(false);
		    Global.pause_btn_game.setMargin(null);  
		    Global.pause_btn_game.setBorder(BorderFactory.createEmptyBorder());
		    Global.pause_btn_game.setContentAreaFilled(false); 
		    
		    menu_bouttons.add(Global.pause_btn_game);
		    menu_bouttons.add(Global.exit_btn_game);
		    
		    //GridLayout pour les bonus
		    bonus.setLayout(new GridLayout(2, 2));

		    //Chargement des images des icones et des boutons associés
		    JLabel but1 = new JLabel(new ImageIcon("./img/bonus1.png"));
		    JLabel but2 = new JLabel(new ImageIcon("./img/bonus2.png"));
		    JLabel but3 = new JLabel(new ImageIcon("./img/bonus3.png"));
		    JLabel but4 = new JLabel(new ImageIcon("./img/bonus4.png"));
		    
		    
		    int i;
		    for (i=0; i< 16; i++ ){
		    	Global.tabonus[i] = new JLabel();
		    	Global.tabonus[i].setIcon(bonusinactif);
		    }
	    
		    //Division du cadre de bonus en image de bonus et boutons des joueurs

		    JPanel b1 = new JPanel();
		    b1.setSize(140,180);
		    bonus.add(b1);
		    b1.setLayout(new BorderLayout());
		    JPanel leb1 = new JPanel();
		    leb1.setPreferredSize(new Dimension(140, 140));
		    leb1.add(but1);
		    b1.add(leb1, BorderLayout.NORTH);
		    JPanel bj1 = new JPanel();
		    bj1.setPreferredSize(new Dimension(140, 40));
		    b1.add(bj1, BorderLayout.SOUTH);
		    bj1.setLayout(new GridLayout(1, 4));
		    
		    affflagj1.add(Global.flag1);
		    affflagj2.add(Global.flag2);
		    affflagj3.add(Global.flag3);
		    affflagj4.add(Global.flag4);
		    
		    bj1.add(affflagj1);
		    bj1.add(affflagj2);
		    bj1.add(affflagj3);
		    bj1.add(affflagj4);

		    
		    
		  //Division du cadre de bonus en image de bonus et boutons des joueurs
		    JPanel b2 = new JPanel();
		    bonus.add(b2);
		    b2.setLayout(new BorderLayout());
		    JPanel leb2 = new JPanel();
		    leb2.setPreferredSize(new Dimension(140, 140));
		    leb2.add(but2);
		    b2.add(leb2, BorderLayout.NORTH);
		    JPanel bj2 = new JPanel();
		    bj2.setPreferredSize(new Dimension(140, 40));
		    b2.add(bj2, BorderLayout.SOUTH);
		    bj2.setLayout(new GridLayout(1, 4));
		    for(i=4;i<8;i++){
		    	bj2.add(Global.tabonus[i]);
		    }
		    
		  //Division du cadre de bonus en image de bonus et boutons des joueurs
		    JPanel b3 = new JPanel();
		    bonus.add(b3);
		    b3.setLayout(new BorderLayout());
		    JPanel leb3 = new JPanel();
		    leb3.setPreferredSize(new Dimension(140, 140));
		    leb3.add(but3);
		    b3.add(leb3, BorderLayout.NORTH);
		    JPanel bj3 = new JPanel();
		    bj3.setPreferredSize(new Dimension(140, 40));
		    b3.add(bj3, BorderLayout.SOUTH);
		    bj3.setLayout(new GridLayout(1, 4));
		    for(i=8;i<12;i++){
		    	bj3.add(Global.tabonus[i]);
		    }
		    
		    
		    JPanel b4 = new JPanel();
		    bonus.add(b4);
		    b4.setLayout(new BorderLayout());
		    JPanel leb4 = new JPanel();
		    leb4.setPreferredSize(new Dimension(140, 140));
		    leb4.add(but4);
		    b4.add(leb4, BorderLayout.NORTH);
		    JPanel bj4 = new JPanel();
		    bj4.setPreferredSize(new Dimension(140, 40));
		    b4.add(bj4, BorderLayout.SOUTH);
		    bj4.setLayout(new GridLayout(1, 4));
		    for(i=12;i<16;i++){
		    	bj4.add(Global.tabonus[i]);
		    }
		    
		    this.addWindowListener(new WindowAdapter(){
		        public void windowClosing(WindowEvent e) {
		            Global.fen.setVisible(false);
		            Global.fen.dispose();
		        }
		    });
		    
           
		    this.setVisible(true);
		    
		  } 
	  
	  public void setBonusAfficher(int indj, int indb){
			  switch(indj){
			  	case 1 :
				  Global.tabonus[(indb-1)*4+indj-1].setIcon(bonusj1);
				  break;
			  	case 2 :
			  	  Global.tabonus[(indb-1)*4+indj-1].setIcon(bonusj2);
			  	  break;
			  	case 3 :
			  	  Global.tabonus[(indb-1)*4+indj-1].setIcon(bonusj3);
			  	  break;
			  	case 4 :
			  	  Global.tabonus[(indb-1)*4+indj-1].setIcon(bonusj4);
			  	  break;
			  }		  
	  }
	  
	  public void setBonusInactif(int indj, int indb){
		  switch(indj){
		  	case 1 :
			  Global.tabonus[(indb-1)*4+indj-1].setIcon(bonusinactif);
			  break;
		  	case 2 :
		  	  Global.tabonus[(indb-1)*4+indj-1].setIcon(bonusinactif);
		  	  break;
		  	case 3 :
		  	  Global.tabonus[(indb-1)*4+indj-1].setIcon(bonusinactif);
		  	  break;
		case 4:
		  	  Global.tabonus[(indb-1)*4+indj-1].setIcon(bonusinactif);
		  	  break;
		  }
		  
	  }
		       
}
