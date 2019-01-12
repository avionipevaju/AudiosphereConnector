package org.avionipevaju.moody.py.connector.route.entry;

import org.apache.camel.builder.RouteBuilder;
import org.avionipevaju.moody.py.connector.dto.discogs.DiscogsRequest;
import org.avionipevaju.moody.py.connector.dto.discogs.DiscogsResponse;
import org.avionipevaju.moody.py.connector.dto.entry.EntryRequest;
import org.avionipevaju.moody.py.connector.dto.twitter.TwitterRequest;
import org.avionipevaju.moody.py.connector.dto.twitter.TwitterResponse;
import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeRequest;
import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeResponse;
import org.avionipevaju.moody.py.connector.vo.Constants;
import org.avionipevaju.moody.py.connector.vo.FeelingLucky;

public class EntryPointRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        rest().post("/twitter/song-by-artist").id("/twitter/song-by-artist")
                .type(EntryRequest.class).consumes(Constants.CONTENT_TYPE)
                .outType(TwitterResponse.class).consumes(Constants.CONTENT_TYPE)
                .route()
                .process(exchange -> {
                    EntryRequest entryRequest = exchange.getIn().getBody(EntryRequest.class);
                    String username = exchange.getIn().getHeader(Constants.USERNAME_HEADER, String.class);
                    String password = exchange.getIn().getHeader(Constants.PASSWORD_HEADER, String.class);
                    exchange.setProperty("usernameHeader", username);
                    exchange.setProperty("passwordHeader", password);
                    exchange.setProperty("username", entryRequest.getUsername());
                    DiscogsRequest discogsRequest = new DiscogsRequest();
                    discogsRequest.setArtist(entryRequest.getInformation());
                    exchange.getOut().setBody(discogsRequest);
                })
                .to("direct:DiscogsArtist")
                .process(exchange -> {
                    DiscogsResponse discogsResponse = exchange.getIn().getBody(DiscogsResponse.class);
                    YoutubeRequest youtubeRequest = new YoutubeRequest();
                    exchange.setProperty("randomTrack", discogsResponse.getRandomTrack());
                    youtubeRequest.setSearchString(discogsResponse.getRandomTrack());
                    youtubeRequest.setFeelingLucky(FeelingLucky.True);
                    exchange.getOut().setBody(youtubeRequest);
                })
                .to("direct:Youtube")
                .process(exchange -> {
                    YoutubeResponse youtubeResponse = exchange.getIn().getBody(YoutubeResponse.class);
                    TwitterRequest twitterRequest = new TwitterRequest();
                    String content = exchange.getProperty("randomTrack", String.class).concat(" ").concat(youtubeResponse.getYoutubeVideo());
                    twitterRequest.setRequestedBy(exchange.getProperty("username", String.class));
                    twitterRequest.setContent(content);
                    exchange.getOut().setBody(twitterRequest);
                    exchange.getOut().setHeader(Constants.USERNAME_HEADER, exchange.getProperty("usernameHeader", String.class));
                    exchange.getOut().setHeader(Constants.PASSWORD_HEADER, exchange.getProperty("passwordHeader", String.class));
                })
                .to("direct:Twitter");

        rest().post("/twitter/song-by-weather").id("/twitter/song-by-weather")
                .type(EntryRequest.class).consumes(Constants.CONTENT_TYPE)
                .route()
                .log("${body}");

        rest().post("/twitter/song-by-genre").id("/twitter/song-by-genre")
                .type(EntryRequest.class).consumes(Constants.CONTENT_TYPE)
                .route()
                .process(exchange -> {
                    EntryRequest entryRequest = exchange.getIn().getBody(EntryRequest.class);
                    String username = exchange.getIn().getHeader(Constants.USERNAME_HEADER, String.class);
                    String password = exchange.getIn().getHeader(Constants.PASSWORD_HEADER, String.class);
                    exchange.setProperty("usernameHeader", username);
                    exchange.setProperty("passwordHeader", password);
                    exchange.setProperty("username", entryRequest.getUsername());
                    DiscogsRequest discogsRequest = new DiscogsRequest();
                    discogsRequest.setGenre(entryRequest.getInformation());
                    exchange.getOut().setBody(discogsRequest);
                })
                .to("direct:DiscogsGenre")
                .process(exchange -> {
                    DiscogsResponse discogsResponse = exchange.getIn().getBody(DiscogsResponse.class);
                    YoutubeRequest youtubeRequest = new YoutubeRequest();
                    exchange.setProperty("randomTrack", discogsResponse.getRandomTrack());
                    youtubeRequest.setSearchString(discogsResponse.getRandomTrack());
                    youtubeRequest.setFeelingLucky(FeelingLucky.True);
                    exchange.getOut().setBody(youtubeRequest);
                })
                .to("direct:Youtube")
                .process(exchange -> {
                    YoutubeResponse youtubeResponse = exchange.getIn().getBody(YoutubeResponse.class);
                    TwitterRequest twitterRequest = new TwitterRequest();
                    String content = exchange.getProperty("randomTrack", String.class).concat(" ").concat(youtubeResponse.getYoutubeVideo());
                    twitterRequest.setRequestedBy(exchange.getProperty("username", String.class));
                    twitterRequest.setContent(content);
                    exchange.getOut().setBody(twitterRequest);
                    exchange.getOut().setHeader(Constants.USERNAME_HEADER, exchange.getProperty("usernameHeader", String.class));
                    exchange.getOut().setHeader(Constants.PASSWORD_HEADER, exchange.getProperty("passwordHeader", String.class));
                })
                .to("direct:Twitter");


        rest().post("/twitter/instagram-post").id("/twitter/instagram-post")
                .type(EntryRequest.class).consumes(Constants.CONTENT_TYPE)
                .route()
                .log("${body}");

    }
}
