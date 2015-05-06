package Interface;

import pacman.EnumDifficulte;
import pacman.Global;

/**
 * Contient les méthodes de récupération des informations de la fenetre de dialogue et une méthode d'affichage dans le terminal
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class DialogInfo { 

	  public DialogInfo(){}
	  public DialogInfo(String diff, int nbjoueurs, int nbfantomes){
		  Global.nbjoueurs = nbjoueurs;
		  Global.nb_fantomes = nbfantomes;
		  EnumDifficulte.diff = diff;
	  }

	  public String toString(){
	    String str;
	    if(Global.nbjoueurs != 0 && Global.nb_fantomes != 0){
	      str = "Description de l'objet InfoDialog";
	      str += "Nombre de joueurs : " + Integer.toString(Global.nbjoueurs) + "\n";
	      str += "Nombre de fantomes : " + Integer.toString(Global.nb_fantomes) + "\n";
	    }
	    else{
	      str = "Aucune information !";
	    }
	    System.out.println("Nombre de joueurs : " + Global.nbjoueurs);
	    System.out.println("Nombre de fantômes : " + Global.nb_fantomes);
	    System.out.println("Difficulte : " + EnumDifficulte.diff);
	    return str;
	    
	  }
	}
