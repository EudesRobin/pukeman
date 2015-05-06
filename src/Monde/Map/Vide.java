package Monde.Map;

import java.awt.Image;

import Interface.SpritesLoader;
import Monde.Items.*;
import pacman.Global;

/**
 * Case sur laquelle il n'y a rien
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Vide extends Case {
	public Bonus b;
	public boolean danger = false;

	private SpritesLoader attention = new SpritesLoader(12,
			Global.danger.getImage(), (float) 0.09);

	public Vide() {
		b = null;
	}

	public Vide(String bonus) {
		if (bonus == "Accelerateur") {
			b = new Accelerateur();
			return;
		}
		if (bonus.equals("Flag")) {
			b = new Flag();
			return;
		}
		if (bonus.equals("PacGum")) {
			b = new PacGum();
			return;
		}
		if (bonus.equals("SuperPacGum")) {
			b = new SuperPacGum();
			return;
		}
		if (bonus.equals("RamasseGum")) {
			b = new RamasseGum();
			return;
		}
		if (bonus.equals("Invisible")) {
			b = new Invisible();
			return;
		}
		if (bonus.equals("Invincible")) {
			b = new Invincible();
			return;
		}
		if (bonus.equals("Danger")) {
			b = null;
			this.danger = true;
			return;
		}
		b = null;
	}

	public void addBonus(Bonus b) {
		this.b = b;
	}

	public void removeBonus() {
		this.b = null;
	}

	@Override
	public Image getImageCase() {
		if (danger) {
			return attention.getImage();
		}
		if (b == null) {
			return null;
		} else {
			return b.getImageBonus();
		}
	}
}
