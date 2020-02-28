package Handler;

import Model.CD;
import Model.Catalog;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CatalogHandler extends DefaultHandler {
//    private static final String CATALOG = "catalog";
//    private static final String CD = "cd";
//    private static final String TITLE = "title";
//    private static final String ARTIST = "artist";
//    private static final String COUNTRY = "country";
//    private static final String COMPANY = "company";
//    private static final String PRICE = "price";
//    private static final String YEAR = "year";

    private Catalog catalog;
    private String elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue = new String(ch, start, length);
    }

    @Override
    public void startDocument() throws SAXException {
        catalog = new Catalog();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "catalog":
                catalog.setCdList(new ArrayList<>());
                break;
            case "cd":
                catalog.getCdList().add(new CD());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "title":
                latestCD().setTitle(elementValue);
            case "artist":
                latestCD().setArtist(elementValue);
            case "country":
                latestCD().setCountry(elementValue);
            case "company":
                latestCD().setCompany(elementValue);
            case "price":
                latestCD().setPrice(elementValue);
            case "year":
                latestCD().setYear(elementValue);
        }
    }

    public CD latestCD() {
        List<CD> cdList = catalog.getCdList();
        return cdList.get(cdList.size() - 1);
    }

    public String getResult(){
        return catalog.toString();
    }
}
