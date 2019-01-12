package org.avionipevaju.moody.py.connector.dto.assembler;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.dto.twitter.TwitterRequest;
import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeResponse;
import org.avionipevaju.moody.py.connector.utils.ExchangeUtils;
import org.avionipevaju.moody.py.connector.vo.Constants;

public class TwitterAssembler {

    public static final TwitterRequest createTwitterRequest(Exchange exchange, YoutubeResponse youtubeResponse) {
        TwitterRequest twitterRequest = new TwitterRequest();
        String content = ExchangeUtils.getValueFromExchange(exchange, "content").concat(" ").concat(youtubeResponse.getYoutubeVideo());
        twitterRequest.setRequestedBy(ExchangeUtils.getValueFromExchange(exchange, Constants.ENTRY_REQUEST_USERNAME_PROPERTY));
        twitterRequest.setContent(content);
        return twitterRequest;
    }

}
