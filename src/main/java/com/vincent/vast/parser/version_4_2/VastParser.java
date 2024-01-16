package com.vincent.vast.parser.version_4_2;

import com.vincent.vast.version_4_2.VAST;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class VastParser {

    public static CustomVast parseXml(String xmlString) throws ParserConfigurationException {

        try {

            JAXBContext jc = JAXBContext.newInstance(VAST.class);
            Unmarshaller u = jc.createUnmarshaller();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(new StringReader(xmlString)));
            JAXBElement<VAST> foo = u.unmarshal( doc, VAST.class);

            return new CustomVast(foo.getValue());

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

}
