import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Popup {
	private int ID;
	private String text;
	private MessageFormat format;
	private AudioAlert alert;
	
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
	
	public MessageFormat getFormat() {
		return format;
	}
	
	@XmlElement
	public void setFormat(MessageFormat format) {
		this.format = format;
	}
	
	public AudioAlert getAlert() {
		return alert;
	}
	
	@XmlElement(name="audio")
	public void setAlert(AudioAlert alert) {
		this.alert = alert;
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
			   "\nMessage Format:\n" + this.format +
			   "\nAudio Alert: \n" + this.alert;
	}
}
