import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Themes {
	private ArrayList<Theme> themes = null;

	public ArrayList<Theme> getThemes() {
		return themes;
	}

	@XmlElement(name = "theme")
	public void setThemes(ArrayList<Theme> themes) {
		this.themes = themes;
	}
	
	public void addTheme(Theme theme) {
		theme.setID(themes.size());
		themes.add(theme);
	}
	
	public int getSize() {
		return themes.size();
	}
	
	public Theme getTheme(int index) {
		return themes.get(index);
	}
}
