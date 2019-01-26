package org.avionipevaju.moody.py.connector.route.instagram;

import org.apache.camel.Exchange;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.avionipevaju.moody.py.connector.dto.instagram.InstagramResponse;
import org.avionipevaju.moody.py.connector.route.AbstractRouteBuilder;
import org.avionipevaju.moody.py.connector.vo.Constants;

public class InstagramRouteBuilder extends AbstractRouteBuilder {

    @Override
    public void configure() throws Exception {

        rest().get("/instagram/{username}").id("/instagram/{username}")
                .outType(InstagramResponse.class).produces(Constants.CONTENT_TYPE)
                .route()
                .doTry()
                    .to("direct:Instagram")
                .endDoTry()
                .doCatch(HttpOperationFailedException.class)
                    .process(getHttpOperationFailedExceptionProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

        from("direct:Instagram").id("direct:Instagram")
                .errorHandler(noErrorHandler())
                .process(getRequestProcessor())
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .removeHeader(Exchange.HTTP_PATH)
                .recipientList().exchangeProperty(Constants.INSTAGRAM_FORMATTED_URL)
                .unmarshal().json(JsonLibrary.Jackson, InstagramResponse.class)
                .process(getResponseProcessor());

    }
}
