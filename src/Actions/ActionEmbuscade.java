package Actions;

import Monde.Map.Case;
import Monde.Perso.Fantome;
import Monde.Perso.Perso;

/**
 * Action d'un Pacman qui chasse le fantôme vu avec le plus de points
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class ActionEmbuscade extends Action {

	public void run(Perso perso) {
		Case but = ((Fantome) perso).choixPMpoints();
		perso.ChoixDirChassePersoVu(but);
		perso.avancer_case();
	}

	@Override
	public String get_Action() {
		return "Embuscade";
	}
}
