package Monde.Perso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import Monde.Map.Case;

/**
 * Liste de cases
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

@SuppressWarnings("serial")
public class CaseList implements Serializable {

	private ArrayList<Case> list;

	public CaseList() {
		list = new ArrayList<Case>();
	}

	public void add(Case c) {
		list.add(c);
	}

	public void vide() {
		for (int i = 0; i < list.size(); i++) {
			list.remove(i);
		}
	}

	public Case get(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public boolean Est_Present(Case c) {
		Iterator<Case> i = list.iterator();
		boolean present = false;
		Case cbis = null;

		while (i.hasNext() && !present) {
			cbis = i.next();

			if (cbis.equals(c))
				present = true;
		}

		return present;
	}
}
