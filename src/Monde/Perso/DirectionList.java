package Monde.Perso;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Liste de directions
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

@SuppressWarnings("serial")
public class DirectionList implements Serializable {
	private ArrayList<Direction> list;

	public DirectionList() {
		list = new ArrayList<Direction>();
	}

	public void add(Direction c) {
		list.add(c);
	}

	public void vide() {
		for (int i = 0; i < list.size(); i++) {
			list.remove(i);
		}
	}

	public Direction get(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {

		return list.isEmpty();
	}

	public void afficherDirList() {
		for (Direction c : list) {
			if (c == Direction.Haut)
				System.out.print("Haut ;");
			if (c == Direction.Bas)
				System.out.print("Bas ;");
			if (c == Direction.Droite)
				System.out.print("Droite ;");
			if (c == Direction.Gauche)
				System.out.print("Gauche ;");

			System.out.println("\n\n");
		}
	}
}
