package org.avionipevaju.moody.py.connector.route;

import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeRequest;
import org.avionipevaju.moody.py.connector.vo.Constants;

public abstract class GenericRouteBuilder<ResponseClass> extends AbstractRouteBuilder {

    private Class<ResponseClass> responseClass;

    private String restPath;

    private String routeStartPath;

    public GenericRouteBuilder(String restPath, String routeStartPath) {
        this.restPath = restPath;
        this.routeStartPath = routeStartPath;
    }

    public GenericRouteBuilder(Class<ResponseClass> responseClass, String restPath, String routeStartPath) {
        this.responseClass = responseClass;
        this.restPath = restPath;
        this.routeStartPath = routeStartPath;
    }

    @Override
    public void configure() throws Exception {

        rest().post(getRestPath()).type(YoutubeRequest.class).consumes(Constants.CONTENT_TYPE)
                .route()
                .to(getRouteStartPath());

        from(getRouteStartPath())
                .doTry()
                    .process(getRequestProcessor())
                    .marshal().json(JsonLibrary.Jackson)
                    .to(getEndpoint())
                    .unmarshal().json(JsonLibrary.Jackson, getResponseClass())
                    .process(getResponseProcessor())
                .doCatch(HttpOperationFailedException.class)
                    .process(getHttpOperationFailedExceptionProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

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

    public Class<ResponseClass> getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(Class<ResponseClass> responseClass) {
        this.responseClass = responseClass;
    }
}
