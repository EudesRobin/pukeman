package Automate;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Liste des transitions d'un automate
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

@SuppressWarnings("rawtypes")
public class TransitionList implements Iterable {
	private ArrayList<Transition> list;

	public TransitionList() {
		list = new ArrayList<Transition>();
	}

	public void add(Transition t) {
		list.add(t);
	}

	public Transition search_transition(Etat ec, String c) {
		Iterator<Transition> i = list.iterator();
		boolean present = false;
		Transition t = null;

		while (i.hasNext() && (!present)) {
			t = i.next();

			if ((t.getDepart().equals(ec)) && (t.getCondition().equals(c)))
				present = true;
		}

		return t;
	}

	public void afficherTransitions() {
		System.out.println("Transitions :");

		for (Transition t : list) {
			t.afficherTransition();
			System.out.print("\n");
		}

	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
