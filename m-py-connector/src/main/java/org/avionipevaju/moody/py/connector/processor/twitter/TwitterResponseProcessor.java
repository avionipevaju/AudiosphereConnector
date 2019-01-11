package org.avionipevaju.moody.py.connector.processor.twitter;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.dto.twitter.TwitterResponse;
import org.avionipevaju.moody.py.connector.processor.AbstractProcessor;

public class TwitterResponseProcessor extends AbstractProcessor {

    @Override
    public void process(Exchange exchange) throws Exception {
        TwitterResponse twitterResponse = exchange.getIn().getBody(TwitterResponse.class);
        logAsJson(exchange.getIn().getHeaders(), twitterResponse);
    }
}
