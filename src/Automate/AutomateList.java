package Automate;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Liste des automates
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

@SuppressWarnings("serial")
public class AutomateList implements Serializable {

	private ArrayList<Automate> list;

	public AutomateList() {
		list = new ArrayList<Automate>();
	}

	public void add(Automate c) {
		list.add(c);
	}

	public Automate get(int index) {
		return list.get(index);
	}

	public void afficherAutomates() {
		System.out.println("Automates :");

		for (Automate c : list) {
			c.afficher_Automate();

			System.out.println("\n\n");
		}

	}

	public int size() {
		return list.size();
	}

}
