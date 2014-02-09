import java.awt.Color;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/* Allows the XML parser to convert between java.awt.Color
 * and a hex string
 */
public class ColorAdapter extends XmlAdapter<String, Color> {
    public Color unmarshal(String s) {
        return Color.decode(s);
    }

    public String marshal(Color color) {
        return '#' + Integer.toHexString(color.getRGB());
    }
}
