package Monde.Items;

import java.awt.Image;
import pacman.Global;
import Interface.SpritesLoader;

/**
 * Bonus ralentissant les Fantômes /!\ PAS ENCORE TRAITE /!\
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Accelerateur extends Bonus {
	private SpritesLoader acc;

	public Accelerateur() {
		this.acc = new SpritesLoader(5, Global.accelerateurd.getImage(),
				(float) 0.05);
	}

	public Image getImageBonus() {
		return acc.getImage();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Accelerateur) {
			return true;
		} else {
			return false;
		}
	}
}
