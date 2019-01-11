package org.avionipevaju.moody.py.connector.route;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.avionipevaju.moody.py.connector.processor.twitter.TwitterRequestProcessor;
import org.avionipevaju.moody.py.connector.processor.twitter.TwitterResponseProcessor;
import org.avionipevaju.moody.py.connector.route.twitter.TwitterRouteBuilder;

public class TwitterRouteBuilderTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        TwitterRouteBuilder twitterRouteBuilder = new TwitterRouteBuilder();
        twitterRouteBuilder.setRequestProcessor(new TwitterRequestProcessor());
        twitterRouteBuilder.setResponseProcessor(new TwitterResponseProcessor());
        twitterRouteBuilder.setEndpoint("http4://localhost:8887/moody/api/post");
        return twitterRouteBuilder;
    }
}
