import Handler.CatalogHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {

    private static final String PATH = "resources/cd_catalog.xml";

    public static void main(String[] args) {
        File testFile = new File(PATH);
        doSAXParse(testFile);
    }

    public static void doSAXParse(File file) {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            CatalogHandler handler = new CatalogHandler();
            parser.parse(file, handler);
            System.out.println("SAX Parser result:\n" + handler.getResult());
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}
