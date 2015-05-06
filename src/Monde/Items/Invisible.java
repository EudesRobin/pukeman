package Monde.Items;

import java.awt.Image;
import pacman.Global;

/**
 * Bnus rendant les Pacman invisibles aux yeux des fantomes
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Invisible extends Bonus {

	private Image inv;

	public Invisible() {
		this.inv = Global.invisible.getImage();
	}

	public Image getImageBonus() {
		return inv;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Invisible) {
			return true;
		} else {
			return false;
		}
	}
}
