package org.avionipevaju.moody.py.connector.route.twitter;

import org.avionipevaju.moody.py.connector.dto.twitter.TwitterRequest;
import org.avionipevaju.moody.py.connector.dto.twitter.TwitterResponse;
import org.avionipevaju.moody.py.connector.route.GenericRouteBuilder;

public class TwitterRouteBuilder extends GenericRouteBuilder<TwitterRequest, TwitterResponse> {

    public TwitterRouteBuilder(String restPath, String routeStartPath) {
        super(TwitterRequest.class, TwitterResponse.class, restPath, routeStartPath);
    }

}
