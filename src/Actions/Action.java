package Actions;

import Monde.Perso.Perso;

/**
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

public abstract class Action {

	public abstract void run(Perso perso);

	public abstract String get_Action();
}
