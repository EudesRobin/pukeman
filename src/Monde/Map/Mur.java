package Monde.Map;

import java.awt.Image;
import pacman.Global;

/**
 * Case par laquelle il n'est pas possible de passer
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Mur extends Case {
	public Image i;

	public Mur() {
		this.i = Global.mur.getImage();
	}

	@Override
	public Image getImageCase() {
		return i;
	}

}
