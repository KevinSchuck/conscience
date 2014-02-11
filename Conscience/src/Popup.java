import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Popup {
	private int ID;
	private int themeId;
	private String text;
	
	public int getID() {
		return ID;
	} 
	
	@XmlAttribute
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getText() {
		return text;
	}
	
	@XmlElement
	public void setText(String text) {
		this.text = text;
	}
	
	public int getThemeId() {
		return themeId;
	}
	
	@XmlElement(name="theme-id")
	public void setThemeId(int id) {
		this.themeId = themeId;
	}

	public void show() {
		// TODO: add logic to show a popup
		/// i.e.
		// ...
		// alert.play();
		// ...
	}
	
	@Override
	public String toString() {
		return "ID: " + this.ID +
			   "\nText: " + this.text +
			   "\nTheme Id:\n" + this.themeId;
	}
}
