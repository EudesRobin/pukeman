package Actions;


/** Fuite d'un Pacman ou fantôme intelligent qui privilégie le changement de direction
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 *
 */

import Monde.Perso.Fantome;
import Monde.Perso.Perso;

public class ActionFuitniv2 extends Action {
	public void run(Perso perso) {

		if (perso instanceof Fantome) {
			if (((Fantome) perso).nb_tour_vulnerable % 2 == 0) {
				perso.ChoixDirFuite_niv2();
				perso.avancer_demie_case();
				((Fantome) perso).nb_tour_vulnerable--;
			} else {
				perso.avancer_demie_case();
				((Fantome) perso).nb_tour_vulnerable--;
			}

		} else {
			perso.ChoixDirFuite_niv2();
			perso.avancer_case();
		}
	}

	@Override
	public String get_Action() {
		return "Fuitniv2";
	}
}
