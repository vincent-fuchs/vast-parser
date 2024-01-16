package com.vincent.vast.parser.version_4_2;

import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class VastParserTest {

    @Test
    void withNamespaceInXml() throws IOException, ParserConfigurationException {

        Path path = Paths.get("src/test/resources/sample4_2.xml");
        String vastXmlContent = Files.lines(path).collect(Collectors.joining(System.lineSeparator()));
        CustomVast result = VastParser.parseXml(vastXmlContent);

        assertThat(result.getVast()).isNotNull();
        assertThat(result.getVast().getAd()).isNotEmpty();

    }

    @Test
    void canParseAnXMlWithNoNamespace() throws IOException, ParserConfigurationException {

        Path path = Paths.get("src/test/resources/sample4_2_noNamespace.xml");
        String vastXmlContent = Files.lines(path).collect(Collectors.joining(System.lineSeparator()));

        CustomVast result = VastParser.parseXml(vastXmlContent);

        assertThat(result).isNotNull();
        assertThat(result.getFirstAd()).isNotEmpty();
    }

}