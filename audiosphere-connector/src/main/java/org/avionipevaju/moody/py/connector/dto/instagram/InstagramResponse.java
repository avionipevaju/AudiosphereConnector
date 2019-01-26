package org.avionipevaju.moody.py.connector.dto.instagram;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InstagramResponse {

    private String username;

    @JsonProperty("image_url")
    private String imageUrl;

    private String caption;


    public InstagramResponse() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
