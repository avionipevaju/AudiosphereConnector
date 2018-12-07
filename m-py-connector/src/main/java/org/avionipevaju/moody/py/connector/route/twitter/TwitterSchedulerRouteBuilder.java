package org.avionipevaju.moody.py.connector.route.twitter;

import org.apache.camel.Exchange;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.avionipevaju.moody.py.connector.route.AbstractRouteBuilder;

public class TwitterSchedulerRouteBuilder extends AbstractRouteBuilder {

    public void configure() throws Exception {

        from("timer:twitScheduler?period=12h").id("twitterScheduler")
                .description("MoodyPy tweet scheduler. Initiates periodic content posting to Twitter based on the weather")
                .doTry()
                    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                    .to(getEndpoint())
                .doCatch(HttpOperationFailedException.class)
                    .process(getHttpOperationFailedExceptionProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

        rest().get("/twitter/manual-initiate").id("twitterManualInitiateRoute")
                .outType(String.class).produces("application/json")
                .description("Manually post content based on weather data to Twitter with MoodyPy")
                .route()
                .doTry()
                    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                    .to(getEndpoint().concat("?bridgeEndpoint=true"))
                .doCatch(HttpOperationFailedException.class)
                    .process(getHttpOperationFailedExceptionProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

    }
}
