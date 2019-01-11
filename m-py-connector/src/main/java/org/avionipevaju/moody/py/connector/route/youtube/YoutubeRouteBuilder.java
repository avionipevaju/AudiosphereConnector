package org.avionipevaju.moody.py.connector.route.youtube;

import org.apache.camel.model.dataformat.JsonLibrary;
import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeRequest;
import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeResponse;
import org.avionipevaju.moody.py.connector.route.AbstractRouteBuilder;

public class YoutubeRouteBuilder extends AbstractRouteBuilder {

    @Override
    public void configure() throws Exception {

        rest().post("/search-youtube").type(YoutubeRequest.class).consumes("application/json")
                .route()
                .to("direct:Youtube");

        from("direct:Youtube")
                .doTry()
                    .process(getRequestProcessor())
                    .marshal().json(JsonLibrary.Jackson)
                    .to(getEndpoint())
                    .unmarshal().json(JsonLibrary.Jackson, YoutubeResponse.class)
                    .process(getResponseProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

    }

}
