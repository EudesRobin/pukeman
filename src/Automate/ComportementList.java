package Automate;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Liste de comportements
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

@SuppressWarnings("serial")
public class ComportementList implements Serializable {
	private ArrayList<Comportement> list;

	public ComportementList() {
		list = new ArrayList<Comportement>();
	}

	public void add(Comportement c) {
		list.add(c);
	}

	public Comportement get(int index) {
		return list.get(index);
	}

	public Comportement get(String nom) {
		int i = 0;
		boolean find = false;
		while ((i < list.size()) && !find) {
			if ((list.get(i)).nature.equals(nom)) {
				find = true;
			} else
				i++;
		}
		return list.get(i);
	}

	public int size() {
		return list.size();
	}

}
