package org.avionipevaju.moody.py.connector.route;

import org.apache.camel.Exchange;

public class SchedulerRouteBuilder extends AbstractRouteBuilder {

    public void configure() throws Exception {

        from("timer:twitScheduler?period=12h").id("twitScheduler")
                .description("MoodyPy tweet scheduler. Initiates periodic content posting on Twitter")
                .doTry()
                    .process(getRequestProcessor())
                    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                    .to(getEndpoint())
                    .process(getResponseProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

        rest().get("/manual-initiate").id("manualInitiateRoute")
                .outType(String.class).produces("application/json")
                .description("Manually post content on Twitter with MoodyPy")
                .route()
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to(getEndpoint().concat("?bridgeEndpoint=true"));

    }
}
