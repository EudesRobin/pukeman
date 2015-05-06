package Parser;

import java.io.Serializable;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import javax.swing.JOptionPane;

import Actions.*;
import Automate.*;

@SuppressWarnings("serial")
public class Parser implements Serializable {

	public Parser(String donneesInitiales) {
		try {
			parsing(donneesInitiales);
		} catch (Exception err) {
			System.out.print("Erreur\n");
		}
	}

	public Parser() {

	}

	public boolean IsValidCmptName(String name) {
		return (name.equalsIgnoreCase("PM") || name.equalsIgnoreCase("FTF")
				|| name.equalsIgnoreCase("PAF") || name.equalsIgnoreCase("FTM")
				|| name.equalsIgnoreCase("PAM") || name.equalsIgnoreCase("FTD") || name
					.equalsIgnoreCase("PAD"));
	}

	public boolean IsValidAut(String name) {
		return (name.equalsIgnoreCase("pm") || name.equalsIgnoreCase("fnf")
				|| name.equalsIgnoreCase("paf") || name.equalsIgnoreCase("fnm")
				|| name.equalsIgnoreCase("pam") || name.equalsIgnoreCase("fnd") || name
					.equalsIgnoreCase("pad"));
	}

	public boolean IsValidId(int id) {
		return (id >= 0 && id <= 3);
	}

	public boolean IsValidState(String state) {
		return (state.equals("Avance") || state.equals("Fuit")
				|| state.equals("Fuitniv2") || state.equals("Suit")
				|| state.equals("Rejoint") || state.equals("Vers PacGum"));
	}

	public boolean IsValidCondition(String cond) {
		return (cond.equalsIgnoreCase("Rien")
				|| cond.equalsIgnoreCase("Voit Pacman + Invulnerable")
				|| cond.equalsIgnoreCase("Voit Pacman + Vulnerable")
				|| cond.equalsIgnoreCase("Voit Fantome + Invulnerable")
				|| cond.equalsIgnoreCase("Voit Fantome + Vulnerable")
				|| cond.equalsIgnoreCase("A un objectif") || cond
					.equalsIgnoreCase("PM a points"));
	}

	@SuppressWarnings("rawtypes")
	public ListXMLContents parsing(String donneesInitiales) throws Exception {
		List cptlist;
		List transitlist;
		List etatlistauto;
		List etatlisttrans;
		List actionlisttrans;
		AutomateList sl = new AutomateList();
		TransitionList tl = null;
		ComportementList cl = new ComportementList();

		// attribut de comportement²
		String nature_c = null;

		// attribut d'automate
		String nom_a = null;

		// attribut d'etat
		String id = null;
		String nom_etatauto = null;
		String nom_etattrans = null;

		// attribut de condition
		String nature_cond = null;

		// attribut d'action
		String nature_action = null;

		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(donneesInitiales);
		Element racine = doc.getRootElement();

		Element thelisteCpt = racine.getChild("ListeComportements");
		cptlist = thelisteCpt.getChildren("Comportement");

		for (int x = 0; x < cptlist.size(); x++) {

			Element cpt = (Element) cptlist.get(x);
			nature_c = cpt.getAttributeValue("nature");

			if (!IsValidCmptName(nature_c)) {
				JOptionPane.showMessageDialog(null,
						"Error nature comportement = " + nature_c,
						"Error Parser XML", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}

			// Recupération de l'automate
			Element automate = cpt.getChild("Automate");
			nom_a = automate.getAttributeValue("nom");

			if (!IsValidAut(nom_a)) {
				JOptionPane.showMessageDialog(null, "Error nom automate = "
						+ nom_a, "Error Parser XML", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}

			transitlist = automate.getChildren("Transition");
			etatlistauto = automate.getChildren("etat");

			// constructeur Automate
			// constructeur Etats

			EtatList el_f = new EtatList();
			EtatList el = new EtatList();

			// Recuperation de l'etat initial et des etats finaux
			for (int v = 0; v < etatlistauto.size(); v++) {

				Element state = (Element) etatlistauto.get(v);
				id = state.getAttributeValue("id");
				nom_etatauto = state.getAttributeValue("nom");
				Action ac = null;
				if (nom_etatauto.equalsIgnoreCase("Avance"))
					ac = new ActionAvance();
				else if (nom_etatauto.equalsIgnoreCase("Rejoint"))
					ac = new ActionRejoint();
				else if (nom_etatauto.equalsIgnoreCase("Chasse"))
					ac = new ActionEmbuscade();
				else if (nom_etatauto.equalsIgnoreCase("Fuit"))
					ac = new ActionFuit();
				else if (nom_etatauto.equalsIgnoreCase("Fuitniv2"))
					ac = new ActionFuitniv2();
				else if (nom_etatauto.equalsIgnoreCase("Suit"))
					ac = new ActionSuit();
				else if (nom_etatauto.equalsIgnoreCase("Vers PacGum"))
					ac = new ActionVersPacgum();
				else {
					JOptionPane.showMessageDialog(null, "Error in action4 = "
							+ nom_etatauto, "Error Parser XML",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}

				if (!IsValidId(Integer.valueOf(id))) {
					JOptionPane.showMessageDialog(null,
							"Error ID number  in line id = " + id,
							"Error Parser XML", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}

				el_f.add(new Etat(Integer.valueOf(id), nom_etatauto, ac));

				el.add(new Etat(Integer.valueOf(id), nom_etatauto, ac));
			}

			Etat etat_depart = el_f.get_state(0); 
			EtatList test = new EtatList(el_f);
			test.remove_state(0);
			if (test.size() != 0) {
				el_f.remove_state(0);
			}
			
			tl = new TransitionList();

			for (int a = 0; a < transitlist.size(); a++) {
				Element state = (Element) transitlist.get(a);
				etatlisttrans = state.getChildren("etat");

				Element stat;

				// Recuperation etat de depart
				stat = (Element) etatlisttrans.get(0);
				id = stat.getAttributeValue("id");
				nom_etattrans = stat.getAttributeValue("nom");
				Action ac = null;
				if (nom_etattrans.equalsIgnoreCase("Avance"))
					ac = new ActionAvance();
				else if (nom_etattrans.equalsIgnoreCase("Rejoint"))
					ac = new ActionRejoint();
				else if (nom_etattrans.equalsIgnoreCase("Chasse"))
					ac = new ActionEmbuscade();
				else if (nom_etattrans.equalsIgnoreCase("Fuit"))
					ac = new ActionFuit();
				else if (nom_etattrans.equalsIgnoreCase("Fuitniv2"))
					ac = new ActionFuitniv2();
				else if (nom_etattrans.equalsIgnoreCase("Suit"))
					ac = new ActionSuit();
				else if (nom_etattrans.equalsIgnoreCase("Vers PacGum"))
					ac = new ActionVersPacgum();
				else {
					JOptionPane.showMessageDialog(null, "Error in action3 = "
							+ nom_etattrans, "Error Parser XML",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}

				if (!IsValidId(Integer.valueOf(id))) {
					JOptionPane.showMessageDialog(null,
							"Error ID number in line id = " + id,
							"Error Parser XML", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}

				Etat et_d = new Etat(Integer.valueOf(id), nom_etattrans, ac);
				el.add(et_d);

				// Recuperation etat arrivee
				stat = (Element) etatlisttrans.get(1);
				id = stat.getAttributeValue("id");
				nom_etattrans = stat.getAttributeValue("nom");
				if (nom_etattrans.equalsIgnoreCase("Avance"))
					ac = new ActionAvance();
				else if (nom_etattrans.equalsIgnoreCase("Rejoint"))
					ac = new ActionRejoint();
				else if (nom_etattrans.equalsIgnoreCase("Chasse"))
					ac = new ActionEmbuscade();
				else if (nom_etattrans.equalsIgnoreCase("Fuit"))
					ac = new ActionFuit();
				else if (nom_etattrans.equalsIgnoreCase("Fuitniv2"))
					ac = new ActionFuitniv2();
				else if (nom_etattrans.equalsIgnoreCase("Suit"))
					ac = new ActionSuit();
				else if (nom_etattrans.equalsIgnoreCase("Vers PacGum"))
					ac = new ActionVersPacgum();
				else {
					JOptionPane.showMessageDialog(null, "Error in action2 = "
							+ nom_etattrans, "Error Parser XML",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}

				if (!IsValidId(Integer.valueOf(id))) {
					JOptionPane.showMessageDialog(null,
							"Error ID number in line id = " + id,
							"Error Parser XML", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}

				Etat et_f = new Etat(Integer.valueOf(id), nom_etattrans, ac);
				el.add(et_f);

				// Recuperation de la condition
				Element cond = state.getChild("Condition");
				nature_cond = cond.getAttributeValue("nature");

				if (!IsValidCondition(nature_cond)) {
					JOptionPane.showMessageDialog(null, "Error in conditon = "
							+ nature_cond, "Error Parser XML",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}

				// Recuperation des actions
				ActionList al = new ActionList();
				actionlisttrans = state.getChildren("Action");

				for (int f = 0; f < actionlisttrans.size(); f++) {
					Element stat_ac = (Element) actionlisttrans.get(f);
					nature_action = stat_ac.getAttributeValue("nature");

					if (nature_action.equalsIgnoreCase("Avance"))
						ac = new ActionAvance();
					else if (nature_action.equalsIgnoreCase("Rejoint"))
						ac = new ActionRejoint();
					else if (nom_etattrans.equalsIgnoreCase("Chasse"))
						ac = new ActionEmbuscade();
					else if (nature_action.equalsIgnoreCase("Fuit"))
						ac = new ActionFuit();
					else if (nature_action.equalsIgnoreCase("Fuitniv2"))
						ac = new ActionFuitniv2();
					else if (nature_action.equalsIgnoreCase("Suit"))
						ac = new ActionSuit();
					else if (nature_action.equalsIgnoreCase("Vers PacGum"))
						ac = new ActionVersPacgum();
					else {
						JOptionPane.showMessageDialog(null,
								"Error in action1 = " + nature_action,
								"Error Parser XML", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					al.add(ac);
				}
				Transition t = new Transition(et_d, nature_cond, et_f, al);
				tl.add(t);

			}
			Automate a = new Automate(nom_a, el, tl, etat_depart, el_f);
			sl.add(a);
			Comportement c = new Comportement(nature_c, a);
			cl.add(c);
		}

		// sl.afficherAutomates();

		if (cl.size() == 0) {
			JOptionPane.showMessageDialog(null,
					"Error aucun comportement defini ", "Error Parser XML",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		ListXMLContents xml_contents = new ListXMLContents(cl);

		return xml_contents;
	}

}