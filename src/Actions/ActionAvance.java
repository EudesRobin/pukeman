package Actions;

import Monde.Perso.*;

/**
 * Avance normale d'un personnage
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class ActionAvance extends Action {

	@Override
	public void run(Perso perso) {

		if (perso instanceof Fantome) {
			if (((Fantome) perso).nb_tour_vulnerable == 0) {
				perso.ChoixDir();
				perso.avancer_case();
			} else {
				if (((Fantome) perso).nb_tour_vulnerable % 2 == 0) {
					perso.ChoixDir();
					perso.avancer_demie_case();
					((Fantome) perso).nb_tour_vulnerable--;
				} else {
					perso.avancer_demie_case();
					((Fantome) perso).nb_tour_vulnerable--;
				}
			}
		} else {
			if (perso instanceof PacmanJoueur) {
				((PacmanJoueur) perso).ChangerDir();
			} else {
				((PacmanAuto) perso).ChoixDir();
			}
			perso.avancer_case();

		}

	}

	@Override
	public String get_Action() {
		return "Avance";
	}
}