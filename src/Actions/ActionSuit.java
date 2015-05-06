package Actions;

import Monde.Map.Case;
import Monde.Perso.*;

/**
 * Un personnage suit un autre personnage qu'il voit
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class ActionSuit extends Action {
	public void run(Perso perso) {
		Direction d = Direction.Null;
		Case inter;
		DirectionList dlist;
		if ((perso instanceof Fantome) || (perso instanceof PacmanAuto)) {
			int cpp = 0;
			for (int i = 1; i < perso.s_fuit.size(); i++) {
				int dist = perso.dist_case(perso.s_fuit.get(cpp));
				int test = perso.dist_case(perso.s_fuit.get(i));
				if (test < dist)
					cpp = i;
			}
			if (!(perso.s_fuit.isEmpty())) {
				inter = perso.s_fuit.get(cpp);
				dlist = perso.get_dir(inter);

				if (!(dlist.isEmpty())) {
					d = perso.get_dir(inter).get(0);
				} else {
					//System.out.println("Orangeeeeeeeeeeeeeeee");
				}
			} /*else
				if (perso instanceof PacmanAuto)
					System.out.println("Micheline " + ((PacmanAuto)perso).num_pacman);
				else
					System.out.println("Micheline ");*/
		}
		perso.d = d;
		perso.avancer_case();
	}

	@Override
	public String get_Action() {
		return "Suit";
	}
}
