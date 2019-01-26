package org.avionipevaju.moody.py.connector.dto.discogs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscogsResponse {

    @JsonProperty("random_track")
    private String randomTrack;

    public String getRandomTrack() {
        return randomTrack;
    }

    public void setRandomTrack(String randomTrack) {
        this.randomTrack = randomTrack;
    }
}
