package org.avionipevaju.moody.py.connector.dto.youtube;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.avionipevaju.moody.py.connector.vo.FeelingLucky;

public class YoutubeRequest {

    @JsonProperty("search_string")
    private String searchString;

    @JsonProperty("feeling_lucky")
    private FeelingLucky feelingLucky;

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public FeelingLucky getFeelingLucky() {
        return feelingLucky;
    }

    public void setFeelingLucky(FeelingLucky feelingLucky) {
        this.feelingLucky = feelingLucky;
    }
}
