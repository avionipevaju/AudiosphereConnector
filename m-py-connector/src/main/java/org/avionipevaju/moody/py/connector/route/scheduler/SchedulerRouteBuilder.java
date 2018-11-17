package org.avionipevaju.moody.py.connector.route.scheduler;

import org.apache.camel.Exchange;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.avionipevaju.moody.py.connector.route.AbstractRouteBuilder;

public class SchedulerRouteBuilder extends AbstractRouteBuilder {

    public void configure() throws Exception {

        from("timer:twitScheduler?period=12h").id("twitScheduler")
                .description("MoodyPy tweet scheduler. Initiates periodic content posting on Twitter")
                .doTry()
                    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                    .to(getEndpoint())
                .doCatch(HttpOperationFailedException.class)
                    .process(getHttpOperationFailedExceptionProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

        rest().get("/manual-initiate").id("manualInitiateRoute")
                .outType(String.class).produces("application/json")
                .description("Manually post content on Twitter with MoodyPy")
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
