package org.avionipevaju.moody.py.connector.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionHandlingProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlingProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        LOGGER.error("Error occurred with Body: {} and Headers: {}", exchange.getIn().getBody(), exchange.getIn().getHeaders());
    }
}
