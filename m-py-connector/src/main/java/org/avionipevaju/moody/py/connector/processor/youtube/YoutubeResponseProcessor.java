package org.avionipevaju.moody.py.connector.processor.youtube;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeRequest;
import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeResponse;
import org.avionipevaju.moody.py.connector.processor.AbstractProcessor;

public class YoutubeResponseProcessor extends AbstractProcessor {

    @Override
    public void process(Exchange exchange) throws Exception {
        YoutubeResponse youtubeResponse = exchange.getIn().getBody(YoutubeResponse.class);
        logAsJson(youtubeResponse);
        exchange.getOut().setBody(youtubeResponse);
    }

}
