package Monde.Items;

import java.awt.Image;
import pacman.Global;

/**
* Objet classique de gain de points
* 
* @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
*         Robin EUDES Ombeline ROSSI
* 
*/

public class PacGum extends Bonus{

	private Image PG;
	
	public PacGum(){
		this.PG=Global.pacgum.getImage();
	}
	
	
	public Image getImageBonus(){
		return PG;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof PacGum){
			return true;
		}
		else{
			return false;
		}
	}
}
 	