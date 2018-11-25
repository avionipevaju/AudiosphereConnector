package org.avionipevaju.moody.py.connector.route.scheduler.instagram;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.avionipevaju.moody.py.connector.dto.instagram.ExecutionResponse;
import org.avionipevaju.moody.py.connector.route.AbstractRouteBuilder;
import org.avionipevaju.moody.py.connector.vo.Constants;

public class InstagramSchedulerRouteBuilder extends AbstractRouteBuilder {

    private Processor instagramSchedulerPreProcessor;

    @Override
    public void configure() throws Exception {

        rest().get("/instagram/manual-initiate/{username}").id("instagramManualInitiateRoute")
                .outType(String.class).produces("application/json")
                .description("Manually post latest Instagram post of a user to Twitter with MoodyPy")
                .route()
                .doTry()
                    .process(getInstagramSchedulerPreProcessor())
                    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                    .removeHeader(Exchange.HTTP_PATH)
                    .recipientList().exchangeProperty(Constants.INSTAGRAM_SCHEDULER_URL)
                    .unmarshal().json(JsonLibrary.Jackson, ExecutionResponse.class)
                    .process(getRequestProcessor())
                    .to("direct:post")
                .endDoTry()
                .doCatch(HttpOperationFailedException.class)
                    .process(getHttpOperationFailedExceptionProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

    }

    public Processor getInstagramSchedulerPreProcessor() {
        return instagramSchedulerPreProcessor;
    }

    public void setInstagramSchedulerPreProcessor(Processor instagramSchedulerPreProcessor) {
        this.instagramSchedulerPreProcessor = instagramSchedulerPreProcessor;
    }
}
