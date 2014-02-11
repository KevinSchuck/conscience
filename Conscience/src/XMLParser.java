import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/* This class will handle parsing and writing to the xml files */

public class XMLParser {
	private Popups popups;
	private Themes themes;
	private Configuration config = null;
	private int popupIndex = 0;

	public static void main(String[] args) {
		XMLParser xmlParser = new XMLParser();
		
		// Example of getting the ArrayList of popups
//		for (Popup popup : xmlParser.getPopups()) {
//			
//			//System.out.println(popup);
//		}
		
		System.out.println("Popups size: " + xmlParser.getNumPopups());
		
		System.out.println("Config: "
				+ xmlParser.getConfiguration().getFrequency()
				+ "\n" + xmlParser.getConfiguration().getVersion()
				+ "\n" + xmlParser.getConfiguration().getAudioVolume());
		
		
		// Example of creating a new popup and writing to the xml file
		Popup popup = new Popup();
		
		popup.setText("Testing writing a message to popups.xml");
		popup.setThemeId(1);
		
		xmlParser.addPopup(popup); // write to ArrayList and XML file
		
		
		// Example of creating a new them and writing to the xml file
		MessageFormat format = new MessageFormat();
		Theme theme = new Theme();
		
		format.setBgColor(Color.red);
		format.setFontFamily("Times New Roman");
		format.setMsgFontSize(12);
		format.setMsgPosition("bottom, left");
		format.setTextColor(Color.blue);
		format.setTitleFontSize(14);
		
		theme.setFormat(format);
		theme.setName("new theme");
		theme.setAudioAlert("audio/ding.wav");;
	}

	public XMLParser() {
		parsePopups();
		parseThemes();
		parseConfiguration();
	}

	/* read list of popups from popups.xml */
	public void parsePopups() {
		try {
			File file = new File("model/popup.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Popups.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			this.popups = (Popups) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	/* write the popups list to popup.xml */
	private void writePopupsToXML() {
		try {
			File file = new File("model/popup.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Popups.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(popups, file);
			jaxbMarshaller.marshal(popups, System.out);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void parseConfiguration() {
		try {
			File file = new File("model/config.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Configuration.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			this.config = (Configuration) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	private void writeConfigurationToXML() {
		
	}
	
	private void parseThemes() {
		try {
			File file = new File("model/themes.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Themes.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			this.themes = (Themes) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	private void writeThemesToXML() {
		
	}
	
	public int getNumPopups() {
		return popups.getSize();
	}
	
	/* Return the popup specified by index */
	public Popup getPopup(int index) {
		return popups.getPopup(index);
	}
	
	/* Return the next popup
	 * Loop from beginning if the list is exhausted
	 * */
	public Popup getPopup() {
		if (popupIndex >= popups.getSize()) {
			popupIndex = 0;
		}
		
		return popups.getPopup(popupIndex++);
	}
	
	/* return a list of popups */
	public ArrayList<Popup> getPopups() {
		return popups.getPopups();
	}

	/* add a new popup to the ArrayList and Xml file */
	public void addPopup(Popup popup) {
		popups.addPopup(popup);
		writePopupsToXML();
	}

	public Configuration getConfiguration() {
		return config;
	}
}
