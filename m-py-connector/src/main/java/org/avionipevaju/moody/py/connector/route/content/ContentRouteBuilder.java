package org.avionipevaju.moody.py.connector.route.content;

import org.apache.camel.Exchange;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.avionipevaju.moody.py.connector.dto.twitter.ExecutionRequest;
import org.avionipevaju.moody.py.connector.dto.twitter.ExecutionResponse;
import org.avionipevaju.moody.py.connector.route.AbstractRouteBuilder;

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
                    .process(getRequestProcessor())
                    .marshal().json(JsonLibrary.Jackson)
                    .to(getEndpoint())
                    .unmarshal().json(JsonLibrary.Jackson, ExecutionResponse.class)
                    .process(getResponseProcessor())
                .doCatch(HttpOperationFailedException.class)
                    .process(getHttpOperationFailedExceptionProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

        from("direct:post").id("postContentFromInstagramRoute")
                .doTry()
                    .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                    .process(getRequestProcessor())
                    .marshal().json(JsonLibrary.Jackson)
                    .to(getEndpoint())
                    .unmarshal().json(JsonLibrary.Jackson, ExecutionResponse.class)
                    .process(getResponseProcessor())
                .doCatch(HttpOperationFailedException.class)
                    .process(getHttpOperationFailedExceptionProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

    }

}
