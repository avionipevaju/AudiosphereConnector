package org.avionipevaju.moody.py.connector.processor.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.avionipevaju.moody.py.connector.dto.twitter.TwitterResponse;
import org.avionipevaju.moody.py.connector.processor.AbstractProcessor;

public class HttpOperationFailedExceptionProcessor extends AbstractProcessor {

    private ObjectMapper objectMapper;

    @Override
    public void process(Exchange exchange) throws Exception {
        HttpOperationFailedException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, HttpOperationFailedException.class);
        TwitterResponse twitterResponse = getObjectMapper().readValue(exception.getResponseBody(), TwitterResponse.class);
        logAsJson(exchange.getIn().getHeaders(), twitterResponse);
        exchange.getOut().setBody(twitterResponse);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
