package org.avionipevaju.moody.py.connector.processor.instagram;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.dto.instagram.ExecutionResponse;
import org.avionipevaju.moody.py.connector.dto.twitter.TwitterRequest;
import org.avionipevaju.moody.py.connector.processor.AbstractProcessor;
import org.avionipevaju.moody.py.connector.vo.Constants;

public class InstagramSchedulerRequestProcessor extends AbstractProcessor {

    private final String INSTAGRAM_POST_FORMAT = "User %s posted on Instagram %s";

    @Override
    public void process(Exchange exchange) throws Exception {
        ExecutionResponse instagramExecutionResponse = exchange.getIn().getBody(ExecutionResponse.class);
        logAsJson(instagramExecutionResponse);
        TwitterRequest twitterRequest = new TwitterRequest();
        String content = instagramExecutionResponse.getImageUrl() + " " + instagramExecutionResponse.getCaption();
        twitterRequest.setContent(String.format(INSTAGRAM_POST_FORMAT, instagramExecutionResponse.getUsername(), content));
        twitterRequest.setRequestedBy(exchange.getProperty(Constants.USERNAME_HEADER, String.class));
        exchange.getOut().setHeader(Constants.USERNAME_HEADER, exchange.getProperty(Constants.USERNAME_HEADER));
        exchange.getOut().setHeader(Constants.PASSWORD_HEADER, exchange.getProperty(Constants.PASSWORD_HEADER));
        logAsJson(twitterRequest);
        exchange.getOut().setBody(twitterRequest);
    }

}
