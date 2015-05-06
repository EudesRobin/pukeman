package Interface;

import java.awt.Image;
import sun.awt.image.ToolkitImage;
import java.awt.image.*;
import pacman.Global;

/**
 * Gestion et chargement des sprites
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public class SpritesLoader {
	BufferedImage[] buf;
	BufferedImage spriteSheet;
	private double x;
	private double y;
	private int lg_max;

	/**
	 * @param longueur_sprite_sheet
	 *            longueur de la sprite
	 * @param img
	 *            Image à découper
	 * @param x
	 *            Entier indiquant le rythme de changement de sprite
	 */
	public SpritesLoader(int longueur_sprite_sheet, Image img, double x) {
		spriteSheet = ((ToolkitImage) img).getBufferedImage();
		buf = new BufferedImage[longueur_sprite_sheet];
		for (int i = 0; i < longueur_sprite_sheet; i++) {
			buf[i] = spriteSheet.getSubimage(i * Global.taille_bloc, 0,
					Global.taille_bloc, Global.taille_bloc);
		}
		this.y = 0;
		this.x = x;
		lg_max = longueur_sprite_sheet;
	}

	/**
	 * @return Image associée au sprite en cours, puis passe au sprite suivant
	 */
	public Image getImage() {
		Image res = (Image) buf[(int) y];
		if (y < lg_max - 1) {
			// Float modifiable pour changer la vitesse de changement du sprite
			y = y + x;
		} else {
			y = 0;
		}
		return res;
	}

	public void cacher_image() {
		int i;
		for (i = 0; i < buf.length; i++) {
			buf[i] = null;
		}
	}

}
