package org.avionipevaju.moody.py.connector.processor.exception;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.avionipevaju.moody.py.connector.dto.twitter.TwitterResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionHandlingProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlingProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        Exception exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        LOGGER.error("{} Body: {} and Headers: {}", exception.getMessage(), exchange.getIn().getBody(), exchange.getIn().getHeaders(), exception);
        TwitterResponse twitterResponse = new TwitterResponse();
        twitterResponse.setStatus("-1");
        twitterResponse.setDescription(exception.getMessage());
        exchange.getOut().setBody(twitterResponse);
    }
}
