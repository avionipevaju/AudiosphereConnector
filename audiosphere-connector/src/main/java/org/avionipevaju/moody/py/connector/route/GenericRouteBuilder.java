package org.avionipevaju.moody.py.connector.route;

import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.avionipevaju.moody.py.connector.vo.Constants;

public abstract class GenericRouteBuilder<RequestType, ResponseType> extends AbstractRouteBuilder {

    private Class<RequestType> requestTypeClass;

    private Class<ResponseType> responseTypeClass;

    private String restPath;

    private String routeStartPath;

    public GenericRouteBuilder(String restPath, String routeStartPath) {
        this.restPath = restPath;
        this.routeStartPath = routeStartPath;
    }

    public GenericRouteBuilder(Class<RequestType> requestTypeClass, Class<ResponseType> responseTypeClass, String restPath, String routeStartPath) {
        this.requestTypeClass = requestTypeClass;
        this.responseTypeClass = responseTypeClass;
        this.restPath = restPath;
        this.routeStartPath = routeStartPath;
    }

    @Override
    public void configure() throws Exception {

        rest().post(getRestPath()).id(getRestPath())
                .type(getRequestTypeClass()).consumes(Constants.CONTENT_TYPE)
                .outType(getResponseTypeClass()).produces(Constants.CONTENT_TYPE)
                .route()
                .doTry()
                    .to(getRouteStartPath())
                .doCatch(HttpOperationFailedException.class)
                    .process(getHttpOperationFailedExceptionProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

        from(getRouteStartPath()).id(getRouteStartPath())
                .errorHandler(noErrorHandler())
                .process(getRequestProcessor())
                .marshal().json(JsonLibrary.Jackson)
                .to(getEndpoint())
                .unmarshal().json(JsonLibrary.Jackson, getResponseTypeClass())
                .process(getResponseProcessor());

    }

    public String getRestPath() {
        return restPath;
    }

    public void setRestPath(String restPath) {
        this.restPath = restPath;
    }

    public String getRouteStartPath() {
        return routeStartPath;
    }

    public void setRouteStartPath(String routeStartPath) {
        this.routeStartPath = routeStartPath;
    }

    public Class<RequestType> getRequestTypeClass() {
        return requestTypeClass;
    }

    public void setRequestTypeClass(Class<RequestType> requestTypeClass) {
        this.requestTypeClass = requestTypeClass;
    }

    public Class<ResponseType> getResponseTypeClass() {
        return responseTypeClass;
    }

    public void setResponseTypeClass(Class<ResponseType> responseTypeClass) {
        this.responseTypeClass = responseTypeClass;
    }
}
