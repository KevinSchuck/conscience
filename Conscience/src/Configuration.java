import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "config")
public class Configuration {
	private String version;
	private int frequency;
	private int audioVolume;
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public int getAudioVolume() {
		return audioVolume;
	}
	
	@XmlElement(name = "audio-volume")
	public void setAudioVolume(int audioVolume) {
		this.audioVolume = audioVolume;
	}
}
