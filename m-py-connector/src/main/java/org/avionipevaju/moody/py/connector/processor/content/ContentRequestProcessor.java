package org.avionipevaju.moody.py.connector.processor.content;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.dto.ExecutionRequest;
import org.avionipevaju.moody.py.connector.processor.AbstractProcessor;

public class ContentRequestProcessor extends AbstractProcessor {

    @Override
    public void process(Exchange exchange) throws Exception {
        ExecutionRequest executionRequest = exchange.getIn().getBody(ExecutionRequest.class);
        logAsJson(executionRequest);
        exchange.getOut().setBody(executionRequest);
    }
}
