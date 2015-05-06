package Actions;

import java.util.Random;

import Monde.Perso.*;

/**
 * Rejoint un objectif imposé : clic pour PacmanAuto
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class ActionRejoint extends Action {
	public void run(Perso perso) {
		DirectionList dl;
		if (perso instanceof PacmanAuto) {
			// Si le Pacman a atteint l'objectif
			if ((((PacmanAuto) perso).obj_x / 20 == ((PacmanAuto) perso).x / 20)
					&& (((PacmanAuto) perso).obj_y / 20 == ((PacmanAuto) perso).y / 20)) {
				((PacmanAuto) perso).obj_x = 0;
				((PacmanAuto) perso).obj_y = 0;
				((PacmanAuto) perso).clic = false;
				((PacmanAuto) perso)
						.unsetCible(((PacmanAuto) perso).num_pacman);

			} else {
				// Sinon, trouver le meilleur chemin
				dl = perso.get_dir(((PacmanAuto) perso).obj_x,
						((PacmanAuto) perso).obj_y);
				//dl.afficherDirList();
				Random rand = new Random();
				if (!dl.isEmpty()) {
					int nb = rand.nextInt(dl.size());
					perso.d = dl.get(nb);
				} else {
					//System.out.println("Peuplier");
				}
			}
		}
		perso.avancer_case();

	}

	@Override
	public String get_Action() {
		return "Rejoint";
	}
}
