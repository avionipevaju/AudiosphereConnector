package org.avionipevaju.moody.py.connector.processor.exception;

import org.apache.camel.Exchange;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.avionipevaju.moody.py.connector.dto.ExecutionResponse;
import org.avionipevaju.moody.py.connector.processor.AbstractProcessor;

public class HttpOperationFailedExceptionProcessor extends AbstractProcessor {

    @Override
    public void process(Exchange exchange) throws Exception {
        HttpOperationFailedException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, HttpOperationFailedException.class);
        ExecutionResponse executionResponse = new ExecutionResponse();
        executionResponse.setStatus(String.valueOf(exception.getStatusCode()));
        executionResponse.setDescription(String.valueOf(exception.getStatusText()));
        logAsJson(exchange.getIn().getHeaders(), executionResponse);
        exchange.getOut().setBody(executionResponse);
    }
}
