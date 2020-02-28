package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
Working only with tags and content on different lines. E.g.:
<tag>
    content
</tag>

Not seeing content if:
<tag>content</tag>
 */
public class MySAXHandler extends DefaultHandler {

    private StringBuilder result;

    public MySAXHandler() {
        this.result = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        result.append("Element name = '").append(qName).append("'\n");

        for (int i = 0; i < attributes.getLength(); i++) {
            result.append("Attribute name = '").append(attributes.getQName(i))
                    .append("'; Attribute value = '").append(attributes.getValue(i)).append("'\n");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = "";

        for (int i = start; i < length; i++)
            value += ch[i];

        if (value.length() != 0)
            result.append("Element content = '").append(value.trim()).append("'\n");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        result.append("Element closed, name = '").append(qName).append("'\n");
    }

    public String getResult() {
        return result.toString();
    }
}
