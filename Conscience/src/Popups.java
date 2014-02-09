import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/* Class Popups stores the parsed popups from popups.xml
 * in an ArrayList
 */

@XmlRootElement
public class Popups {
	private ArrayList<Popup> popups = null;

	public ArrayList<Popup> getPopups() {
		return popups;
	}

	@XmlElement(name = "popup")
	public void setPopups(ArrayList<Popup> popups) {
		this.popups = popups;
	}
}
