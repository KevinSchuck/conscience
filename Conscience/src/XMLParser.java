import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/* This class will handle parsing and writing to the xml files */

public class XMLParser {
	private ArrayList<Popup> popups = new ArrayList<Popup>();
	private Configuration config = null;
	private int popupIndex = 0;

	public static void main(String[] args) {
		XMLParser xmlParser = new XMLParser();
		
		// Example of getting the ArrayList of popups
		for (Popup popup : xmlParser.getPopups()) {
			System.out.println(popup);
		}
		
		// Example of creating a new popup and writing to the xml file
		Popup popup = new Popup();
		MessageFormat format = new MessageFormat();
		AudioAlert audioAlert = new AudioAlert();
		
		popup.setID(xmlParser.getNextPopupID());
		popup.setText("Testing writing a message to popups.xml");
		
		format.setBgColor(Color.red);
		format.setFontFamily("Times New Roman");
		format.setMsgFontSize(12);
		format.setMsgPosition("bottom, left");
		format.setTextColor(Color.blue);
		format.setTitleFontSize(14);
		popup.setFormat(format);
		
		audioAlert.setAlertName("new alert");
		audioAlert.setAlertVolume(22);
		popup.setAlert(audioAlert);
		
		// write to ArrayList and XML file
		xmlParser.addPopup(popup);
	}
	
	public XMLParser() {
		parsePopups();
		parseConfiguration();
	}

	/* read list of popups from popups.xml */
	public void parsePopups() {
		try {
			File file = new File("model/popup.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Popups.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			this.popups = ( (Popups) jaxbUnmarshaller.unmarshal(file) ).getPopups();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	/* write the popups list to popup.xml */
	private void writePopupsToXML() {
		try {
			Popups popups = new Popups();
			popups.setPopups(this.popups);
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
		// TODO: add logic to parse config.xml
	}
	
	public int getNumPopups() {
		return popups.size();
	}
	
	/* Return the popup specified by index */
	public Popup getPopup(int index) {
		return popups.get(index);
	}
	
	/* Return the next popup
	 * Loop from beginning if the list is exhausted
	 * */
	public Popup getPopup() {
		if (popupIndex >= popups.size()) {
			popupIndex = 0;
		}
		
		return popups.get(popupIndex++);
	}
	
	/* return a list of popups */
	public ArrayList<Popup> getPopups() {
		return popups;
	}

	/* add a new popup to the ArrayList and Xml file */
	public void addPopup(Popup popup) {
		popups.add(popup);
		writePopupsToXML();
	}

	/* return next available ID */
	public int getNextPopupID() {
		return popups.get(popups.size() - 1).getID() + 1;
	}
}
