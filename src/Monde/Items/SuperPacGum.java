package Monde.Items;

import java.awt.Image;
import Interface.SpritesLoader;
import pacman.Global;

/**
 * Bonus rendant les fantômes vulnérables aux Pacman
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class SuperPacGum extends Bonus {

	private SpritesLoader super_pacgum;

	public SuperPacGum() {
		this.super_pacgum = new SpritesLoader(8, Global.superpacgum.getImage(),
				(float) 0.1);
	}

	public Image getImageBonus() {
		return super_pacgum.getImage();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof SuperPacGum) {
			return true;
		} else {
			return false;
		}
	}
}
