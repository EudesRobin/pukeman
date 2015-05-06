package Automate;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Liste des états d'un automate
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class EtatList {
	private ArrayList<Etat> list;

	public EtatList() {
		list = new ArrayList<Etat>();
	}

	public EtatList(EtatList el) {
		list = new ArrayList<Etat>(el.getList());
	}

	public void add(Etat e) {
		if (!Est_Present(e))
			list.add(e);
	}

	public boolean Est_Present(Etat e) {
		Iterator<Etat> i = list.iterator();
		boolean present = false;
		Etat ebis = null;

		while (i.hasNext() && !present) {
			ebis = i.next();

			if (ebis.equals(e))
				present = true;
		}

		return present;
	}

	public void afficherEtats() {
		System.out.print("Etats :");

		for (Etat e : list)
			System.out.print(e.get_Etat() + " ; ");

		System.out.println("\n");
	}

	public void affichernomEtats() {

		for (Etat e : list)
			System.out.print(e.getNom() + " ");

		System.out.println("\n");
	}

	public int size() {
		return list.size();
	}

	public Etat get_state(int id) {
		Etat e1;
		Etat e2 = list.get(id);
		for (int i = 0; i < list.size(); i++) {
			e1 = list.get(i);
			if (id == e1.getId()) {
				e2 = e1;
			}
		}
		return e2;
	}

	public void remove_state(int id) {
		list.remove(id);
	}

	public ArrayList<Etat> getList() {
		return list;
	}

}
