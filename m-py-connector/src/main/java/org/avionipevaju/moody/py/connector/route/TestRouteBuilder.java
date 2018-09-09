package org.avionipevaju.moody.py.connector.route;

public class TestRouteBuilder extends AbstractRouteBuilder {

    public void configure() throws Exception {

        from("timer:testTimer?period=5s").id("TestRoute")
                .description("Test Route to demonstrate Apache Camel Route Builder")
                .doTry()
                    .process(getRequestProcessor())
                    .log("Sending ${body} to Endpoint")
                    .to("mock:endpoint")
                    .process(getResponseProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());
    }
}
