package Monde.Items;

import java.awt.Image;

/**
 * 
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public abstract class Bonus {
	public Image i;

	@Override
	public boolean equals(Object o) {
		if (o instanceof Flag) {
			return true;
		} else {
			return false;
		}
	}

	public Image getImageBonus() {
		return null;
	}
}
