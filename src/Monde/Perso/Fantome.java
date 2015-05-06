package Monde.Perso;

import java.awt.Image;

import pacman.EnumDifficulte;
import pacman.Global;
import Interface.SpritesLoader;
import Monde.Map.Case;
import Automate.*;

/**
 * Classe du personnage "Fantôme"
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class Fantome extends Perso {
	public int nb_tour_vulnerable;

	private SpritesLoader i, k;

	public Fantome(int x, int y, Direction d, Couleur couleur) {
		super(x, y, d);
		this.nb_tour_vulnerable = 0;
		choixSprite(couleur);
		this.k = new SpritesLoader(10, Global.fantomepeur.getImage(), (float) 1);
	}

	public void choixSprite(Couleur couleur) {

		if (couleur == Couleur.Rouge) {
			this.i = new SpritesLoader(10, Global.fantomerouge.getImage(),
					(float) 0.4);
		} else if (couleur == Couleur.Vert) {
			this.i = new SpritesLoader(10, Global.fantomevert.getImage(),
					(float) 0.2);
		} else if (couleur == Couleur.Jaune) {
			this.i = new SpritesLoader(10, Global.fantomejaune.getImage(),
					(float) 0.25);
		} else if (couleur == Couleur.Bleu) {
			this.i = new SpritesLoader(10, Global.fantomebleu.getImage(),
					(float) 0.35);
		} else if (couleur == Couleur.Blanc) {
			this.i = new SpritesLoader(10, Global.fantomeblanc.getImage(),
					(float) 0.20);
		} else if (couleur == Couleur.Cyan) {
			this.i = new SpritesLoader(10, Global.fantomecyan.getImage(),
					(float) 0.30);
		} else if (couleur == Couleur.Orange) {
			this.i = new SpritesLoader(10, Global.fantomeorange.getImage(),
					(float) 0.26);
		} else if (couleur == Couleur.Rose) {
			this.i = new SpritesLoader(10, Global.fantomerose.getImage(),
					(float) 0.23);
		} else if (couleur == Couleur.Noir) {
			this.i = new SpritesLoader(10, Global.fantomenoir.getImage(),
					(float) 0.4);
		}
	}

	public Image getImageFantome() {
		if (nb_tour_vulnerable > 0) {
			return k.getImage();
		} else
			return i.getImage();
	}

	public Case choixPMpoints() {
		CaseList tousPM = new CaseList();
		int i;
		for (int j = 0; j < Global.nb_fantomes; j++) {
			for (i = 0; i < Global.map.fantomes[j].s_fuit.size(); i++) {
				if (!(tousPM.Est_Present(Global.map.fantomes[j].s_fuit.get(i)))) {
					tousPM.add(Global.map.fantomes[j].s_fuit.get(i));
				}
			}

		}
		int PMpluspt = 0;
		for (i = 1; i < tousPM.size(); i++) {
			int score = scoreasso(tousPM.get(PMpluspt));
			if (scoreasso(tousPM.get(i)) > score) {
				PMpluspt = i;
			}
		}
		return tousPM.get(PMpluspt);
	}

	public int scoreasso(Case c) {
		for (int i = 0; i < 4; i++) {
			if ((c.x == Global.map.pacmen[i].x)
					&& (c.y == Global.map.pacmen[i].y)) {
				return Global.map.pacmen[i].get_score();
			}
		}
		return 0;
	}

	public void evoluer(Comportement cpt) {
		Automate autf = cpt.get_Automate();
		TransitionList tl = autf.getTransitions();
		EtatList el = autf.getEtats();
		String c = etudieMap();
		Etat etat = el.get_state(this.id_etat);
		Transition t = tl.search_transition(etat, c);
		//System.out.println("FT " + c);
		if (t != null) {
			//t.afficherTransition();
			t.runActions(this);
			etat = t.getArrivee();
			this.id_etat = etat.getId();

		} else {
			etat.getAction().run(this);
		}
	}

	public boolean pacmanvus() {
		boolean estvu = false;
		for (int i = 0; i < 4; i++) {
			if (!(Global.map.fantomes[i].s_fuit.isEmpty())) {
				estvu = true;
			}
		}
		return estvu;
	}

	public String etudieMap() {
		String cl = "";
		if (this.nb_tour_vulnerable == 0) {
			if (!(s_fuit.isEmpty())
					&& (EnumDifficulte.diff == "Difficile" || EnumDifficulte.diff == "Moyen")) {
				cl = "Voit Pacman + Invulnerable";
			} else if ((pacmanvus()) && EnumDifficulte.diff == "Difficile") {
				cl = "PM a points";
			} else {
				cl = "Rien";
			}
		} else if (!(s_fuit.isEmpty())) {
			cl = "Voit Pacman + Vulnerable";
		} else {
			cl = "Rien";
		}
		return cl;
	}
}