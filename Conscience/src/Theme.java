import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Theme {
	private int ID;
	private String name;
	private String audioAlert;
	private MessageFormat format;
	
	public int getID() {
		return ID;
	}
	
	@XmlAttribute
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public MessageFormat getFormat() {
		return format;
	}
	
	@XmlElement(name="format")
	public void setFormat(MessageFormat format) {
		this.format = format;
	}
	
	public String getAudioAlert() {
		return audioAlert;
	}
	
	@XmlElement(name="audio-alert")
	public void setAudioAlert(String audioAlert) {
		this.audioAlert = audioAlert;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.ID +
			   "\nName: " + this.name +
			   "\nAudio Alert: " + this.audioAlert +
			   "\nMessage Format: " + this.format;
	}
}
