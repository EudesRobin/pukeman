package Monde.Items;

import java.awt.Image;

/**
* Drapeau rendant les Pacman invulnérables
* 
* @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
*         Robin EUDES Ombeline ROSSI
* 
*/


import pacman.Global;
import Interface.SpritesLoader;

public class Flag extends Bonus{
	
	private SpritesLoader drapeau;
	
	public Flag(){
		this.drapeau=new SpritesLoader(3,Global.flag.getImage(),(float)0.1);
	}
	
	public Image getImageBonus(){
		return drapeau.getImage();
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Flag){
			return true;
		}
		else{
			return false;
		}
	}
}
