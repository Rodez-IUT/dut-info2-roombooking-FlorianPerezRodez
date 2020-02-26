package xmlws.roombooking.xmltools;

import java.io.InputStream;
import org.xml.sax.Attributes;

public class RoomBookingSaxParser implements RoomBookingParser {
    /**
     * Parse an xml file provided as an input stream
     *
     * @param inputStream the input stream corresponding to the xml file
     * @return the corresponding RoomBooking object
     */
    public RoomBooking parse(InputStream inputStream) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            SAXParser saxParser = spf.newSAXParser();
            saxParser.parse(inputStream, new RoomBookingBasicHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class RoomBookingBasicHandler extends DefaultHandler {
        public void startElement(String namespaceURI,
                                 String localName,
                                 String qName,
                                 Attributes atts) throws SAXException {
            System.out.println("In element: " + localName);
        }

        public void characters(char ch[], int start, int length) throws SAXException {
            System.out.println(new String(ch, start, length));
        }
    }
}



