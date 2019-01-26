package org.avionipevaju.moody.py.connector.route.youtube;

import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeRequest;
import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeResponse;
import org.avionipevaju.moody.py.connector.route.GenericRouteBuilder;

public class YoutubeRouteBuilder extends GenericRouteBuilder<YoutubeRequest, YoutubeResponse> {

    public YoutubeRouteBuilder(String restPath, String routeStartPath) {
        super(YoutubeRequest.class, YoutubeResponse.class, restPath, routeStartPath);
    }

}
