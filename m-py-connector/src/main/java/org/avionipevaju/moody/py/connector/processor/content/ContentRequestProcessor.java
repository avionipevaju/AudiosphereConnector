package org.avionipevaju.moody.py.connector.processor.content;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.dto.twitter.ExecutionRequest;
import org.avionipevaju.moody.py.connector.processor.AbstractProcessor;
import org.avionipevaju.moody.py.connector.utils.SecurityUtils;

public class ContentRequestProcessor extends AbstractProcessor {

    @Override
    public void process(Exchange exchange) throws Exception {
        ExecutionRequest executionRequest = exchange.getIn().getBody(ExecutionRequest.class);
        String passkey = SecurityUtils.generatePasskey(exchange);
        SecurityUtils.addAuthenticationHeader(exchange, passkey);
        logAsJson(exchange.getOut().getHeaders(), executionRequest);
        exchange.getOut().setBody(executionRequest);
    }
}
