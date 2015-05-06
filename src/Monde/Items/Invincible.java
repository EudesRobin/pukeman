package Monde.Items;

import java.awt.Image;
import pacman.Global;

/**
 * Bonus rendant les Pacman invulnérables contre les Fantômes et les zones à
 * danger
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Invincible extends Bonus {

	private Image inv;

	public Invincible() {
		this.inv = Global.invincible.getImage();
	}

	public Image getImageBonus() {
		return inv;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Invincible) {
			return true;
		} else {
			return false;
		}
	}
}
