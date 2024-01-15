package com.vincent.vast.parser.version_4_2;

import com.vincent.vast.version_4_2.VAST;

import java.util.Optional;

/**
 * A wrapper around the VAST object, providing convenience method
 */
public class CustomVast {

    private final VAST vast;

    public CustomVast(VAST vast) {
        this.vast = vast;
    }

    public VAST getVast() {
        return vast;
    }

    public Optional<CustomAd> getFirstAd() {

        if (vast.getAd().isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new CustomAd(vast.getAd().get(0)));
    }
}
