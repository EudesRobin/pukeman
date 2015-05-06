package Automate;

import java.io.Serializable;

/**
 * Automate et nom du comportement associé
 * 
 * @author Romain BADAMO-BARTHELEMY Christelle BODARD David BUI Alan DAMOTTE
 *         Robin EUDES Ombeline ROSSI
 * 
 */

@SuppressWarnings("serial")
public class Comportement implements Serializable {
	String nature;
	Automate aut;

	public Comportement(String nature, Automate aut) {
		this.nature = nature;
		this.aut = aut;
	}

	public void afficher_Comportement() {
		System.out.println("===================================");
		System.out.println("Comportement de Nature : " + nature);
		aut.afficher_Automate();
		System.out.println("===================================");
	}

	public Automate get_Automate() {
		return aut;
	}

	public boolean equals(String nat) {
		return nature.equalsIgnoreCase(nat);
	}
}
