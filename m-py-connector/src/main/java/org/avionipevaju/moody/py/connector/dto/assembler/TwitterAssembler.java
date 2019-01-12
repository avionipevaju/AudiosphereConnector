package org.avionipevaju.moody.py.connector.dto.assembler;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.dto.instagram.InstagramResponse;
import org.avionipevaju.moody.py.connector.dto.twitter.TwitterRequest;
import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeResponse;
import org.avionipevaju.moody.py.connector.utils.ExchangeUtils;
import org.avionipevaju.moody.py.connector.vo.Constants;

public class TwitterAssembler {

    private static final String INSTAGRAM_TWEET_FORMAT_LONG = "User %s posted on Instagram: \n %s \n %s";

    private static final String INSTAGRAM_TWEET_FORMAT_SHORT = "User %s posted on Instagram: \n %s";

    public static TwitterRequest createTwitterRequest(Exchange exchange, YoutubeResponse youtubeResponse) {
        TwitterRequest twitterRequest = new TwitterRequest();
        String content = ExchangeUtils.getValueFromExchange(exchange, "content").concat(" ").concat(youtubeResponse.getYoutubeVideo());
        twitterRequest.setRequestedBy(ExchangeUtils.getValueFromExchange(exchange, Constants.ENTRY_REQUEST_USERNAME_PROPERTY));
        twitterRequest.setContent(content);
        return twitterRequest;
    }

    public static TwitterRequest createTwitterRequest(Exchange exchange, InstagramResponse instagramResponse) {
        TwitterRequest twitterRequest = new TwitterRequest();
        String content;
        if (instagramResponse.getCaption().length() >= 140) {
            content = String.format(INSTAGRAM_TWEET_FORMAT_SHORT, instagramResponse.getUsername(), instagramResponse.getImageUrl());
        } else {
            content = String.format(INSTAGRAM_TWEET_FORMAT_LONG, instagramResponse.getUsername(), instagramResponse.getCaption(), instagramResponse.getImageUrl());
        }
        twitterRequest.setContent(content);
        twitterRequest.setRequestedBy(ExchangeUtils.getValueFromExchange(exchange, Constants.ENTRY_REQUEST_USERNAME_PROPERTY));
        return twitterRequest;
    }

}
