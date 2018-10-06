package org.avionipevaju.moody.py.connector.route;

import org.apache.camel.Exchange;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.avionipevaju.moody.py.connector.dto.ExecutionRequest;
import org.avionipevaju.moody.py.connector.dto.ExecutionResponse;

public class ContentRouteBuilder extends AbstractRouteBuilder {

    @Override
    public void configure() throws Exception {

        rest().post("content/post").id("postContentRoute")
                .type(ExecutionRequest.class).consumes("application/json")
                .outType(ExecutionResponse.class).produces("application/json")
                .description("")
                .route()
                .doTry()
                    .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                    .setHeader("Authorization", constant("Basic andfoaierub123135"))
                    .process(getRequestProcessor())
                    .marshal().json(JsonLibrary.Jackson)
                    .to(getEndpoint())
                    .unmarshal().json(JsonLibrary.Jackson, ExecutionResponse.class)
                    .process(getResponseProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

    }

}
