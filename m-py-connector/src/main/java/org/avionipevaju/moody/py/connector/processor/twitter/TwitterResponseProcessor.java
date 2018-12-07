package org.avionipevaju.moody.py.connector.processor.twitter;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.dto.twitter.ExecutionResponse;
import org.avionipevaju.moody.py.connector.processor.AbstractProcessor;

public class TwitterResponseProcessor extends AbstractProcessor {

    @Override
    public void process(Exchange exchange) throws Exception {
        ExecutionResponse executionResponse = exchange.getIn().getBody(ExecutionResponse.class);
        logAsJson(exchange.getIn().getHeaders(), executionResponse);
    }
}
