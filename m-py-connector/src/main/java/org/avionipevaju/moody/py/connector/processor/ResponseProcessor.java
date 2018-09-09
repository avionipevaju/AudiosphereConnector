package org.avionipevaju.moody.py.connector.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody("Response");
        LOGGER.info("Exchange Body: {}", exchange.getIn().getBody());
        LOGGER.info("Exchange Headers: {}", exchange.getIn().getHeaders());
    }
}
