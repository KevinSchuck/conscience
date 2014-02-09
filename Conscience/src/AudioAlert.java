import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="audio")
public class AudioAlert {
	private String alertName;
	private int alertVolume;
	
	public AudioAlert() {
		
	}
	
	public String getAlertName() {
		return alertName;
	}
	
	@XmlElement(name="audio-alert")
	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}
	
	public int getAlertVolume() {
		return alertVolume;
	}
	
	@XmlElement(name="audio-volume")
	public void setAlertVolume(int alertVolume) {
		this.alertVolume = alertVolume;
	}
	
	public void play() {
		// TODO: add logic to play alert message
	}
	
	@Override
	public String toString() {
		return "\tAlert Name: " + this.alertName +
			   "\n\tAlert Volume: " + this.alertVolume;
	}
}
