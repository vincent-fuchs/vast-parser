package com.vincent.vast.parser.version_4_1;

import com.vincent.vast.version_4_1.VAST;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class VastParser {

    public static CustomVast parseXml(String xmlString) {

        try {

            JAXBContext jc = JAXBContext.newInstance(VAST.class);
            Unmarshaller u = jc.createUnmarshaller();
            VAST result = u.unmarshal(new StreamSource(new StringReader(xmlString)), VAST.class).getValue();

            return new CustomVast(result);


        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}
