package org.avionipevaju.moody.py.connector.processor.content;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.avionipevaju.moody.py.connector.dto.ExecutionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContentResponseProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentResponseProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        ExecutionResponse executionResponse = exchange.getIn().getBody(ExecutionResponse.class);
        LOGGER.info(executionResponse.toString());
    }
}
