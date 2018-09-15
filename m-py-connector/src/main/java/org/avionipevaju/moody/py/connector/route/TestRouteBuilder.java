package org.avionipevaju.moody.py.connector.route;

import org.apache.camel.Exchange;

public class TestRouteBuilder extends AbstractRouteBuilder {

    public void configure() throws Exception {

        from("timer:twitScheduler?period=12h").id("twitScheduler")
                .description("Initiates MoodyPy twit posting based on the current weather periodically")
                .doTry()
                    .process(getRequestProcessor())
                    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                    .to("http4://localhost:8887/execute")
                    .process(getResponseProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

        rest().get("/scheduler/twit").id("manualTwitScheduler").outType(String.class).produces("application/json")
                .description("")
                .route()
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to("http4://localhost:8887/execute");
    }
}
