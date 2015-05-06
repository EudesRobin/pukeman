package Monde.Map;

import java.awt.Image;
import pacman.Global;

/**
 * Case soit ouverte, soit fermée
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Porte extends Case {

	public boolean est_ouvert;
	private Image porteo, portef;
	public int id;

	public Porte(int id) {
		this.est_ouvert = false;
		this.id = id;

		this.porteo = Global.pblanco.getImage();
		this.portef = Global.pblancf.getImage();

	}

	public boolean etatporte() {
		return est_ouvert;
	}

	public void Ouvre() {
		this.est_ouvert = true;
	}

	public void Ferme() {
		this.est_ouvert = false;
	}

	@Override
	public Image getImageCase() {
		if (est_ouvert)
			return porteo;
		else
			return portef;

	}

}
