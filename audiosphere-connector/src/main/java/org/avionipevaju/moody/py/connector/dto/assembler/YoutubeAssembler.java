package org.avionipevaju.moody.py.connector.dto.assembler;

import org.avionipevaju.moody.py.connector.dto.discogs.DiscogsResponse;
import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeRequest;
import org.avionipevaju.moody.py.connector.vo.FeelingLucky;

public class YoutubeAssembler {

    public static YoutubeRequest createYoutubeRequest(DiscogsResponse discogsResponse, Boolean feelingLucky) {
        YoutubeRequest youtubeRequest = new YoutubeRequest();
        youtubeRequest.setSearchString(discogsResponse.getRandomTrack());
        if (feelingLucky) {
            youtubeRequest.setFeelingLucky(FeelingLucky.True);
        } else {
            youtubeRequest.setFeelingLucky(FeelingLucky.False);
        }
        return youtubeRequest;
    }

}
