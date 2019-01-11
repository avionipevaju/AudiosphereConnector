package org.avionipevaju.moody.py.connector.processor.twitter;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.dto.twitter.TwitterRequest;
import org.avionipevaju.moody.py.connector.processor.AbstractProcessor;
import org.avionipevaju.moody.py.connector.utils.SecurityUtils;

public class TwitterRequestProcessor extends AbstractProcessor {

    @Override
    public void process(Exchange exchange) throws Exception {
        TwitterRequest twitterRequest = exchange.getIn().getBody(TwitterRequest.class);
        String passkey = SecurityUtils.generatePasskey(exchange);
        SecurityUtils.addAuthenticationHeader(exchange, passkey);
        logAsJson(exchange.getOut().getHeaders(), twitterRequest);
        exchange.getOut().setBody(twitterRequest);
    }
}
