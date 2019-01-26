package org.avionipevaju.moody.py.connector.route.discogs;

import org.avionipevaju.moody.py.connector.dto.discogs.DiscogsRequest;
import org.avionipevaju.moody.py.connector.dto.discogs.DiscogsResponse;
import org.avionipevaju.moody.py.connector.route.GenericRouteBuilder;

public class DiscogsRouteBuilder extends GenericRouteBuilder<DiscogsRequest, DiscogsResponse> {

    public DiscogsRouteBuilder(String restPath, String routeStartPath) {
        super(DiscogsRequest.class, DiscogsResponse.class, restPath, routeStartPath);
    }

}
