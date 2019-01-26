package org.avionipevaju.moody.py.connector.dto.youtube;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YoutubeResponse {

    @JsonProperty("youtube_video")
    private String youtubeVideo;

    public String getYoutubeVideo() {
        return youtubeVideo;
    }

    public void setYoutubeVideo(String youtubeVideo) {
        this.youtubeVideo = youtubeVideo;
    }
}
