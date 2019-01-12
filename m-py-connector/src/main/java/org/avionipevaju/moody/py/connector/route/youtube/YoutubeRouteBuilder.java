package org.avionipevaju.moody.py.connector.route.youtube;

import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeResponse;
import org.avionipevaju.moody.py.connector.route.GenericRouteBuilder;

public class YoutubeRouteBuilder extends GenericRouteBuilder<YoutubeResponse> {

    public YoutubeRouteBuilder(String restPath, String routeStartPath) {
        super(YoutubeResponse.class, restPath, routeStartPath);
    }

}
