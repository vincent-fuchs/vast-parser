package com.vincent.vast.parser.version_4_1;


import com.vincent.vast.parser.ElementNotFoundException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class VastParserTest {
    @Test
    void canParseXmlWithNoNamespace() throws IOException, ElementNotFoundException {

        Path path = Paths.get("src/test/resources/sample4_1_noNamespace.xml");
        String vastXmlContent = Files.lines(path).collect(Collectors.joining(System.lineSeparator()));

        CustomVast result = VastParser.parseXml(vastXmlContent);

        assertThat(result).isNotNull();
        assertThat(result.getFirstAd()).isNotEmpty();


    }

    @Test
    void canParseXml() throws IOException, ElementNotFoundException {

        Path path = Paths.get("src/test/resources/sample4_1.xml");
        String vastXmlContent = Files.lines(path).collect(Collectors.joining(System.lineSeparator()));

        CustomVast result = VastParser.parseXml(vastXmlContent);

        assertThat(result).isNotNull();
        assertThat(result.getFirstAd()).isNotEmpty();

    }

}