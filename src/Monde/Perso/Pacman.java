package Monde.Perso;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import pacman.Global;
import Automate.Comportement;
import Interface.SpritesLoader;
import Monde.Items.*;

/**
 * Classe générale des Pacman
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Pacman extends Perso {

	public boolean clic;
	public int obj_x, obj_y;
	public int num_pacman;

	private int score;
	public int vie;
	public int acc;
	public boolean flag;
	public int nb_tour_flag;
	public boolean invincible;
	public int nb_tour_invincible;
	public boolean invisible;
	public int nb_tour_invisible;
	public SpritesLoader hinvisible, drinvisible, ginvisible, binvisible;
	public SpritesLoader hinvincible, drinvincible, ginvincible, binvincible;
	private List<Bonus> bonus;
	public SpritesLoader h, dr, g, b;

	// initialisation du pacman
	public Pacman(int x, int y, int num_joueur) {
		super(x, y, Direction.Droite);
		this.acc=0;
		this.score = 0;
		this.vie = 100;
		bonus = new LinkedList<Bonus>();
		clic = false;
		obj_x = 0;
		obj_y = 0;
		num_pacman = num_joueur;
		if (num_joueur == 1) {
			this.h = new SpritesLoader(10, Global.pacmanhj1.getImage(),
					(float) 1);
			this.dr = new SpritesLoader(10, Global.pacmandj1.getImage(),
					(float) 1);
			this.g = new SpritesLoader(10, Global.pacmangj1.getImage(),
					(float) 1);
			this.b = new SpritesLoader(10, Global.pacmanbj1.getImage(),
					(float) 1);

			this.hinvisible = new SpritesLoader(10,
					Global.pacmanihj1.getImage(), (float) 1);
			this.drinvisible = new SpritesLoader(10,
					Global.pacmanidj1.getImage(), (float) 1);
			this.ginvisible = new SpritesLoader(10,
					Global.pacmanigj1.getImage(), (float) 1);
			this.binvisible = new SpritesLoader(10,
					Global.pacmanibj1.getImage(), (float) 1);

			this.hinvincible = new SpritesLoader(10,
					Global.pacmanchj1.getImage(), (float) 1);
			this.drinvincible = new SpritesLoader(10,
					Global.pacmancdj1.getImage(), (float) 1);
			this.ginvincible = new SpritesLoader(10,
					Global.pacmancgj1.getImage(), (float) 1);
			this.binvincible = new SpritesLoader(10,
					Global.pacmancbj1.getImage(), (float) 1);
		}
		if (num_joueur == 2) {
			this.h = new SpritesLoader(10, Global.pacmanhj2.getImage(),
					(float) 1);
			this.dr = new SpritesLoader(10, Global.pacmandj2.getImage(),
					(float) 1);
			this.g = new SpritesLoader(10, Global.pacmangj2.getImage(),
					(float) 1);
			this.b = new SpritesLoader(10, Global.pacmanbj2.getImage(),
					(float) 1);

			this.hinvisible = new SpritesLoader(10,
					Global.pacmanihj2.getImage(), (float) 1);
			this.drinvisible = new SpritesLoader(10,
					Global.pacmanidj2.getImage(), (float) 1);
			this.ginvisible = new SpritesLoader(10,
					Global.pacmanigj2.getImage(), (float) 1);
			this.binvisible = new SpritesLoader(10,
					Global.pacmanibj2.getImage(), (float) 1);

			this.hinvincible = new SpritesLoader(10,
					Global.pacmanchj2.getImage(), (float) 1);
			this.drinvincible = new SpritesLoader(10,
					Global.pacmancdj2.getImage(), (float) 1);
			this.ginvincible = new SpritesLoader(10,
					Global.pacmancgj2.getImage(), (float) 1);
			this.binvincible = new SpritesLoader(10,
					Global.pacmancbj2.getImage(), (float) 1);
		}
		if (num_joueur == 3) {
			this.h = new SpritesLoader(10, Global.pacmanhj3.getImage(),
					(float) 1);
			this.dr = new SpritesLoader(10, Global.pacmandj3.getImage(),
					(float) 1);
			this.g = new SpritesLoader(10, Global.pacmangj3.getImage(),
					(float) 1);
			this.b = new SpritesLoader(10, Global.pacmanbj3.getImage(),
					(float) 1);

			this.hinvisible = new SpritesLoader(10,
					Global.pacmanihj3.getImage(), (float) 1);
			this.drinvisible = new SpritesLoader(10,
					Global.pacmanidj3.getImage(), (float) 1);
			this.ginvisible = new SpritesLoader(10,
					Global.pacmanigj3.getImage(), (float) 1);
			this.binvisible = new SpritesLoader(10,
					Global.pacmanibj3.getImage(), (float) 1);

			this.hinvincible = new SpritesLoader(10,
					Global.pacmanchj3.getImage(), (float) 1);
			this.drinvincible = new SpritesLoader(10,
					Global.pacmancdj3.getImage(), (float) 1);
			this.ginvincible = new SpritesLoader(10,
					Global.pacmancgj3.getImage(), (float) 1);
			this.binvincible = new SpritesLoader(10,
					Global.pacmancbj3.getImage(), (float) 1);
		}
		if (num_joueur == 4) {
			this.h = new SpritesLoader(10, Global.pacmanhj4.getImage(),
					(float) 1);
			this.dr = new SpritesLoader(10, Global.pacmandj4.getImage(),
					(float) 1);
			this.g = new SpritesLoader(10, Global.pacmangj4.getImage(),
					(float) 1);
			this.b = new SpritesLoader(10, Global.pacmanbj4.getImage(),
					(float) 1);

			this.hinvisible = new SpritesLoader(10,
					Global.pacmanihj4.getImage(), (float) 1);
			this.drinvisible = new SpritesLoader(10,
					Global.pacmanidj4.getImage(), (float) 1);
			this.ginvisible = new SpritesLoader(10,
					Global.pacmanigj4.getImage(), (float) 1);
			this.binvisible = new SpritesLoader(10,
					Global.pacmanibj4.getImage(), (float) 1);

			this.hinvincible = new SpritesLoader(10,
					Global.pacmanchj4.getImage(), (float) 1);
			this.drinvincible = new SpritesLoader(10,
					Global.pacmancdj4.getImage(), (float) 1);
			this.ginvincible = new SpritesLoader(10,
					Global.pacmancgj4.getImage(), (float) 1);
			this.binvincible = new SpritesLoader(10,
					Global.pacmancbj4.getImage(), (float) 1);
		}

		invisible = false;
		invincible = false;
		flag = false;
		nb_tour_flag = 0;

	}

	public Image getImagePacman() {
		if (super.d == Direction.Gauche) {
			if (this.invisible) {
				return this.ginvisible.getImage();
			}
			if (this.invincible) {
				return this.ginvincible.getImage();
			}
			return this.g.getImage();
		}
		if (super.d == Direction.Droite) {
			if (this.invisible) {
				return this.drinvisible.getImage();
			}
			if (this.invincible) {
				return this.drinvincible.getImage();
			}
			return this.dr.getImage();
		}
		if (super.d == Direction.Haut) {
			if (this.invisible) {
				return this.hinvisible.getImage();
			}
			if (this.invincible) {
				return this.hinvincible.getImage();
			}
			return this.h.getImage();
		}
		if (super.d == Direction.Bas) {
			if (this.invisible) {
				return this.binvisible.getImage();
			}
			if (this.invincible) {
				return this.binvincible.getImage();
			}
			return this.b.getImage();
		}
		return null;
	}

	public void addScore(int inc) {
		this.score = this.score + inc;
	}

	public void removeVie(int blessure) {
		this.vie = this.vie - blessure;
	}

	public boolean containsBonus(Bonus b) {
		return this.bonus.contains(b);
	}

	public void addBonus(Bonus b) {
		this.bonus.add(b);
	}

	public void removeBonus(Bonus b) {
		if (bonus.contains(b)) {
		}
		this.bonus.remove(b);
	}

	public int get_score() {
		return score;
	}

	public void evoluer(Comportement cpt) {

	}

	public void maj_invisible() {
		if (this.nb_tour_invisible > 0) {
			this.nb_tour_invisible--;
		} else {
			this.invisible = false;
		}
	}

	public void maj_invincible() {
		if (this.nb_tour_invincible > 0) {
			this.nb_tour_invincible--;
		} else {
			this.invincible = false;
		}
	}

	public void maj_flag(int i) {
		if (this.nb_tour_flag > 0) {
			this.nb_tour_flag--;
		} else {
			this.flag = false;
			this.bonus.remove(new Flag());
		}
	}
}
