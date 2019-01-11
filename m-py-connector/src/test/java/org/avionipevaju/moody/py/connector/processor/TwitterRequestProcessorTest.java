package org.avionipevaju.moody.py.connector.processor;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.avionipevaju.moody.py.connector.dto.twitter.TwitterRequest;
import org.avionipevaju.moody.py.connector.processor.twitter.TwitterRequestProcessor;
import org.avionipevaju.moody.py.connector.vo.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwitterRequestProcessorTest {

    private Exchange exchange;

    private TwitterRequestProcessor twitterRequestProcessor;

    private TwitterRequest twitterRequest;

    @Before
    public void setUp() {
        twitterRequestProcessor = new TwitterRequestProcessor();
        exchange = new DefaultExchange(new DefaultCamelContext());
        exchange.getIn().setHeader(Constants.USERNAME_HEADER, "avionipevaju");
        exchange.getIn().setHeader(Constants.PASSWORD_HEADER, "m00dyp!e");
        twitterRequest = new TwitterRequest();
        twitterRequest.setRequestedBy("avionipevaju");
        twitterRequest.setContent("Mogwai");
        exchange.getIn().setBody(twitterRequest);
    }

    @Test
    public void processTest() throws Exception {
        String expectedHeader = "Basic YXZpb25pcGV2YWp1Om0wMGR5cCFl";
        twitterRequestProcessor.process(exchange);
        String header = exchange.getOut().getHeader(Constants.AUTHENTICATION_HEADER, String.class);
        Assert.assertEquals("Checking if authentication header is set correctly", expectedHeader, header);
        Assert.assertEquals("Checking if Body out is correct", twitterRequest, exchange.getOut().getBody(TwitterRequest.class));
    }

}
