package org.avionipevaju.moody.py.connector.route.entry;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.avionipevaju.moody.py.connector.dto.assembler.DiscogsAssembler;
import org.avionipevaju.moody.py.connector.dto.assembler.TwitterAssembler;
import org.avionipevaju.moody.py.connector.dto.assembler.YoutubeAssembler;
import org.avionipevaju.moody.py.connector.dto.discogs.DiscogsResponse;
import org.avionipevaju.moody.py.connector.dto.entry.EntryRequest;
import org.avionipevaju.moody.py.connector.dto.twitter.TwitterResponse;
import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeResponse;
import org.avionipevaju.moody.py.connector.route.AbstractRouteBuilder;
import org.avionipevaju.moody.py.connector.utils.ExchangeUtils;
import org.avionipevaju.moody.py.connector.vo.Constants;

public class EntryPointRouteBuilder extends AbstractRouteBuilder {

    @Override
    public void configure() throws Exception {

        rest().post("/twitter/song-by-artist").id("/twitter/song-by-artist")
                .type(EntryRequest.class).consumes(Constants.CONTENT_TYPE)
                .outType(TwitterResponse.class).consumes(Constants.CONTENT_TYPE)
                .route()
                .doTry()
                    .process(exchange -> {
                        EntryRequest entryRequest = exchange.getIn().getBody(EntryRequest.class);
                        ExchangeUtils.storeAuthorizationHeadersInExchange(exchange);
                        ExchangeUtils.storeValueInExchange(exchange, Constants.ENTRY_REQUEST_USERNAME_PROPERTY, entryRequest.getUsername());
                        exchange.getOut().setBody(DiscogsAssembler.createDiscogsArtistRequest(entryRequest));
                    })
                    .to(Constants.Route.DISCOGS_ARTIST_ROUTE)
                    .process(exchange -> {
                        DiscogsResponse discogsResponse = exchange.getIn().getBody(DiscogsResponse.class);
                        ExchangeUtils.storeValueInExchange(exchange, "content", discogsResponse.getRandomTrack());
                        exchange.getOut().setBody(YoutubeAssembler.createYoutubeRequest(discogsResponse, true));
                    })
                    .to(Constants.Route.YOUTUBE_ROUTE)
                    .process(exchange -> {
                        YoutubeResponse youtubeResponse = exchange.getIn().getBody(YoutubeResponse.class);
                        ExchangeUtils.returnAuthorizationHeadersFromExchange(exchange);
                        exchange.getOut().setBody(TwitterAssembler.createTwitterRequest(exchange, youtubeResponse));
                    })
                    .to(Constants.Route.TWITTER_ROUTE)
                .endDoTry()
                .doCatch(HttpOperationFailedException.class)
                    .process(getHttpOperationFailedExceptionProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

        rest().post("/twitter/song-by-genre").id("/twitter/song-by-genre")
                .type(EntryRequest.class).consumes(Constants.CONTENT_TYPE)
                .route()
                .doTry()
                    .process(exchange -> {
                        EntryRequest entryRequest = exchange.getIn().getBody(EntryRequest.class);
                        ExchangeUtils.storeAuthorizationHeadersInExchange(exchange);
                        ExchangeUtils.storeValueInExchange(exchange, Constants.ENTRY_REQUEST_USERNAME_PROPERTY, entryRequest.getUsername());
                        exchange.getOut().setBody(DiscogsAssembler.createDiscogsGenreRequest(entryRequest));
                    })
                    .to(Constants.Route.DISCOGS_GENRE_ROUTE)
                    .process(exchange -> {
                        DiscogsResponse discogsResponse = exchange.getIn().getBody(DiscogsResponse.class);
                        ExchangeUtils.storeValueInExchange(exchange, "content", discogsResponse.getRandomTrack());
                        exchange.getOut().setBody(YoutubeAssembler.createYoutubeRequest(discogsResponse, true));
                    })
                    .to(Constants.Route.YOUTUBE_ROUTE)
                    .process(exchange -> {
                        YoutubeResponse youtubeResponse = exchange.getIn().getBody(YoutubeResponse.class);
                        ExchangeUtils.returnAuthorizationHeadersFromExchange(exchange);
                        exchange.getOut().setBody(TwitterAssembler.createTwitterRequest(exchange, youtubeResponse));
                    })
                    .to(Constants.Route.TWITTER_ROUTE)
                .endDoTry()
                .doCatch(HttpOperationFailedException.class)
                    .process(getHttpOperationFailedExceptionProcessor())
                .doCatch(Throwable.class)
                    .process(getExceptionHandlingProcessor());

        rest().post("/twitter/song-by-weather").id("/twitter/song-by-weather")
                .type(EntryRequest.class).consumes(Constants.CONTENT_TYPE)
                .route()
                .log("${body}");

        rest().post("/twitter/instagram-post").id("/twitter/instagram-post")
                .type(EntryRequest.class).consumes(Constants.CONTENT_TYPE)
                .route()
                .log("${body}");

    }
}
