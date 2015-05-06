package Parser;

import java.io.Serializable;
import Automate.ComportementList;

@SuppressWarnings("serial")
public class ListXMLContents implements Serializable {
	ComportementList cl;

	public ListXMLContents(ComportementList cl) {
		this.cl = cl;
	}

	public ComportementList getComportementList() {
		return cl;
	}

}
