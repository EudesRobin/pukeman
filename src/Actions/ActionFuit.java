package Actions;

import Monde.Perso.Fantome;
import Monde.Perso.Perso;

/**
 * Fuite d'un Pacman ou d'un fantôme vulnérable
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class ActionFuit extends Action {
	public void run(Perso perso) {

		if (perso instanceof Fantome) {
			if (((Fantome) perso).nb_tour_vulnerable % 2 == 0) {
				perso.ChoixDirFuite();
				perso.avancer_demie_case();
				((Fantome) perso).nb_tour_vulnerable--;
			} else {
				perso.avancer_demie_case();
				((Fantome) perso).nb_tour_vulnerable--;
			}

		} else {
			perso.ChoixDirFuite();
			perso.avancer_case();
		}
	}

	@Override
	public String get_Action() {
		return "Fuit";
	}
}
