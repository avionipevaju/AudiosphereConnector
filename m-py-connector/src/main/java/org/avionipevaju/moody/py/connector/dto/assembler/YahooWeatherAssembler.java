package org.avionipevaju.moody.py.connector.dto.assembler;

import org.avionipevaju.moody.py.connector.dto.entry.EntryRequest;
import org.avionipevaju.moody.py.connector.dto.yahoo.weather.YahooWeatherRequest;

public class YahooWeatherAssembler {

    public static YahooWeatherRequest createYahooWeatherRequest(EntryRequest entryRequest) {
        YahooWeatherRequest yahooWeatherRequest = new YahooWeatherRequest();
        yahooWeatherRequest.setLocation(entryRequest.getInformation());
        return yahooWeatherRequest;
    }

}
