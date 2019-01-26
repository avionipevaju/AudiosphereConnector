package org.avionipevaju.moody.py.connector.processor.yahoo.weather;

import org.avionipevaju.moody.py.connector.dto.yahoo.weather.YahooWeatherRequest;
import org.avionipevaju.moody.py.connector.processor.GenericProcessor;

public class YahooWeatherRequestProcessor extends GenericProcessor<YahooWeatherRequest> {

    public YahooWeatherRequestProcessor() {
        super(YahooWeatherRequest.class);
    }
}
