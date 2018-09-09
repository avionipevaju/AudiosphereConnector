package org.avionipevaju.moody.py.connector.route;

import org.apache.camel.Exchange;

public class TestRouteBuilder extends AbstractRouteBuilder {

    public void configure() throws Exception {

        from("timer:testTimer?period=30s").id("restRoute")
                .description("Test Route to demonstrate Apache Camel Route Builder")
                .doTry()
                    .process(getRequestProcessor())
                    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                    .to("http4://localhost:8888/m-py/api/hello/Sonja")
                    .process(getResponseProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

        rest().get("/hello/{name}").id("restEndpoint").outType(String.class).produces("text/plain")
                .description("Rest endpoint")
                .route()
                .process(exchange -> {
                    String name = exchange.getIn().getHeader("name", String.class);
                    exchange.getOut().setBody("Hello ".concat(name));
                });
    }
}
