package Actions;

import Monde.Perso.PacmanAuto;
import Monde.Perso.*;

/**
 * Le PacmanAuto cherche les PacGum
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class ActionVersPacgum extends Action {

	@Override
	public void run(Perso perso) {
		if (perso instanceof PacmanAuto) {
			((PacmanAuto)perso).ChoixDirVersPacgum();
			perso.avancer_case();
		}
	}

	@Override
	public String get_Action() {
		return "VersPacgum";
	}
}