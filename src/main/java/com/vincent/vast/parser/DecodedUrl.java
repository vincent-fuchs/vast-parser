package com.vincent.vast.parser;

import java.nio.charset.StandardCharsets;

import static java.net.URLDecoder.decode;

public class DecodedUrl {

    private final String url;

    public DecodedUrl(String url) {
        this.url = decode(url, StandardCharsets.UTF_8).trim();
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "DecodedUrl{" +
                "url='" + url + '\'' +
                '}';
    }
}
