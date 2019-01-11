package org.avionipevaju.moody.py.connector.processor.youtube;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeRequest;
import org.avionipevaju.moody.py.connector.processor.AbstractProcessor;

public class YoutubeRequestProcessor extends AbstractProcessor {

    @Override
    public void process(Exchange exchange) throws Exception {
        YoutubeRequest youtubeRequest = exchange.getIn().getBody(YoutubeRequest.class);
        logAsJson(youtubeRequest);
        exchange.getOut().setBody(youtubeRequest);
    }

}
