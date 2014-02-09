import java.awt.Color;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="format")
public class MessageFormat {
	private String fontFamily;
	private int msgFontSize;
	private int titleFontSize;
	private Color bgColor;
	private Color textColor;
	private String msgPosition;
	
	public MessageFormat() {
		
	}
	
	public String getFontFamily() {
		return fontFamily;
	}
	
	@XmlElement(name="font-family")
	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	
	public int getMsgFontSize() {
		return msgFontSize;
	}
	
	@XmlElement(name="font-size-msg")
	public void setMsgFontSize(int msgFontSize) {
		this.msgFontSize = msgFontSize;
	}
	
	public int getTitleFontSize() {
		return titleFontSize;
	}
	
	@XmlElement(name="font-size-title-bar")
	public void setTitleFontSize(int titleFontSize) {
		this.titleFontSize = titleFontSize;
	}
	
	@XmlJavaTypeAdapter(ColorAdapter.class)
	public Color getBgColor() {
		return bgColor;
	}
	
	@XmlElement(name="color-background")
	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	@XmlJavaTypeAdapter(ColorAdapter.class)
	public Color getTextColor() {
		return textColor;
	}
	
	@XmlElement(name="color-text")
	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}
	
	public String getMsgPosition() {
		return msgPosition;
	}
	
	@XmlElement(name="position-msg")
	public void setMsgPosition(String msgPosition) {
		this.msgPosition = msgPosition;
	}
	
	@Override 
	public String toString() {
		return "\tFont Family: " + this.fontFamily +
			   "\n\tMsg Font Size: " + this.msgFontSize +
			   "\n\tTitle Font Size: " + this.titleFontSize +
			   "\n\tBG Color: " + this.bgColor.toString() +
			   "\n\tText Color: " + this.textColor.toString() +
			   "\n\tMsg Position: " + this.msgPosition;
	}
}
