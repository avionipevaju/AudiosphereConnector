package org.avionipevaju.moody.py.connector.processor.content;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.dto.ExecutionResponse;
import org.avionipevaju.moody.py.connector.processor.AbstractProcessor;

public class ContentResponseProcessor extends AbstractProcessor {

    @Override
    public void process(Exchange exchange) throws Exception {
        ExecutionResponse executionResponse = exchange.getIn().getBody(ExecutionResponse.class);
        logAsJson(exchange.getIn().getHeaders(), executionResponse);
    }
}
