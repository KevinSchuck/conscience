import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/* This class will handle parsing and writing to the xml files */

public class XMLParser {
	private Popups popups;
	private Configuration config;
	private int popupIndex = 0;

	public XMLParser() {
		parsePopups();
		parseConfiguration();
	}

	public void parsePopups() {
		try {
			File file = new File("model/popup.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Popups.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			popups = (Popups) jaxbUnmarshaller.unmarshal(file);

			for (Popup popup : popups.getPopups())
				System.out.println(popup);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void parseConfiguration() {
		// TODO: add logic to parse config.xml
	}
	
	public int getNumPopups() {
		if (popups.getPopups() != null)
			return popups.getPopups().size();
		else
			return 0;
	}
	
	/* Return the popup specified by index */
	public Popup getPopup(int index) {
		return popups.getPopups().get(index);
	}
	
	/* Return the next popup
	 * Loop from beginning if the list is exhausted
	 * */
	public Popup getPopup() {
		if (popupIndex >= popups.getPopups().size()) {
			popupIndex = 0;
		}
		
		return popups.getPopups().get(popupIndex++);
	}

	public void addPopup(Popup popup) {
		popups.getPopups().add(popup);
		writePopupToXML(popup);
	}
	
	private void writePopupToXML(Popup popup) {
		// TODO: add logic to add new popup to popups.xml
	}
	
	public static void main(String[] args) {
		 new XMLParser();	 
	}
}
