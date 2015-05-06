package Actions;

import java.util.ArrayList;

import Monde.Perso.Perso;

/**
 * Liste d'actions associée à une transition
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class ActionList {
	private ArrayList<Action> list;

	public ActionList() {
		list = new ArrayList<Action>();
	}

	public void add(Action a) {
		list.add(a);
	}

	public void run(Perso p) {
		for (Action a : list)
			a.run(p);
	}

	public void afficherActions() {
		System.out.print("Actions : ");
		for (Action a : list)
			System.out.print(a.get_Action() + " ");

	}
}
