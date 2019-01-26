package org.avionipevaju.moody.py.connector.dto.twitter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitterResponse {

    private String content;

    private String description;

    @JsonProperty("post_id")
    private String postId;

    private String status;

    private String timestamp;

    private String genre;

    public TwitterResponse() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
