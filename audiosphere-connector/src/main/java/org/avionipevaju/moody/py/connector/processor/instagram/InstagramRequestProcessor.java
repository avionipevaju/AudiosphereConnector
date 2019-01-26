package org.avionipevaju.moody.py.connector.processor.instagram;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.processor.AbstractProcessor;
import org.avionipevaju.moody.py.connector.vo.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstagramRequestProcessor extends AbstractProcessor {

    private String endpoint;

    private static final Logger LOGGER = LoggerFactory.getLogger(InstagramRequestProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        String username = exchange.getIn().getHeader("username", String.class);
        String formattedEndpoint = String.format(getEndpoint().concat("?bridgeEndpoint=true"), username);
        exchange.setProperty(Constants.INSTAGRAM_FORMATTED_URL, formattedEndpoint);
        LOGGER.info("GET ".concat(formattedEndpoint));
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
