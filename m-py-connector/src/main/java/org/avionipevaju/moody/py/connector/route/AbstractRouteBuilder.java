package org.avionipevaju.moody.py.connector.route;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public abstract class AbstractRouteBuilder extends RouteBuilder {

    private Processor requestProcessor;
    private Processor responseProcessor;
    private Processor exceptionHandlingProcessor;

    public Processor getRequestProcessor() {
        return requestProcessor;
    }

    public void setRequestProcessor(Processor requestProcessor) {
        this.requestProcessor = requestProcessor;
    }

    public Processor getResponseProcessor() {
        return responseProcessor;
    }

    public void setResponseProcessor(Processor responseProcessor) {
        this.responseProcessor = responseProcessor;
    }

    public Processor getExceptionHandlingProcessor() {
        return exceptionHandlingProcessor;
    }

    public void setExceptionHandlingProcessor(Processor exceptionHandlingProcessor) {
        this.exceptionHandlingProcessor = exceptionHandlingProcessor;
    }
}
