package org.avionipevaju.moody.py.connector.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody("Dummy Request");
        LOGGER.info("Request Body: {}", exchange.getIn().getBody());
        LOGGER.debug("Exchange Headers: {}", exchange.getIn().getHeaders());

    }
}
