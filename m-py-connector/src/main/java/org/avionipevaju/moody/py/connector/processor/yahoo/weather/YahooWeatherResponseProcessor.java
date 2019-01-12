package org.avionipevaju.moody.py.connector.processor.yahoo.weather;

import org.avionipevaju.moody.py.connector.dto.yahoo.weather.YahooWeatherResponse;
import org.avionipevaju.moody.py.connector.processor.GenericProcessor;

public class YahooWeatherResponseProcessor extends GenericProcessor<YahooWeatherResponse> {

    public YahooWeatherResponseProcessor() {
        super(YahooWeatherResponse.class);
    }
}
