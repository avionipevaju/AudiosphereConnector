package org.avionipevaju.moody.py.connector.dto.twitter;

public class TwitterRequest {

    private String content;

    private String requestedBy;

    public TwitterRequest() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }
}
