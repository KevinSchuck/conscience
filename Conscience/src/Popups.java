import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/* Class Popups stores the parsed popups from popups.xml
 * in an ArrayList
 */

@XmlRootElement
public class Popups {
	private ArrayList<Popup> popups = null;

	public Popups() {
	}

	public ArrayList<Popup> getPopups() {
		return popups;
	}

	@XmlElement(name = "popup")
	public void setPopups(ArrayList<Popup> popups) {
		this.popups = popups;
	}
	
	public void addPopup(Popup popup) {
		popup.setID(popups.get(popups.size() - 1).getID() + 1);
		popups.add(popup);
	}
	
	public int getSize() {
		return popups.size();
	}
	
	public Popup getPopup(int index) {
		return popups.get(index);
	}
}
