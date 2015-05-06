package Monde.Items;

import java.awt.Image;
import pacman.Global;
import Interface.SpritesLoader;

/**
 * Bonus ramassant les pacgum dans une zone déterminée
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class RamasseGum extends Bonus {
	private SpritesLoader rg;

	public RamasseGum() {
		this.rg = new SpritesLoader(7, Global.ramassegum.getImage(),
				(float) 0.05);

	}

	public Image getImageBonus() {
		return rg.getImage();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof RamasseGum) {
			return true;
		} else {
			return false;
		}
	}

}
