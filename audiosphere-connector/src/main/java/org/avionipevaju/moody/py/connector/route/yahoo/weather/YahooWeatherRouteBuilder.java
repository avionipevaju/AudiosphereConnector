package org.avionipevaju.moody.py.connector.route.yahoo.weather;

import org.avionipevaju.moody.py.connector.dto.yahoo.weather.YahooWeatherRequest;
import org.avionipevaju.moody.py.connector.dto.yahoo.weather.YahooWeatherResponse;
import org.avionipevaju.moody.py.connector.route.GenericRouteBuilder;

public class YahooWeatherRouteBuilder extends GenericRouteBuilder<YahooWeatherRequest, YahooWeatherResponse> {

    public YahooWeatherRouteBuilder(String restPath, String routeStartPath) {
        super(YahooWeatherRequest.class, YahooWeatherResponse.class, restPath, routeStartPath);
    }
}
