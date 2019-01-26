package org.avionipevaju.moody.py.connector.processor.youtube;

import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeRequest;
import org.avionipevaju.moody.py.connector.processor.GenericProcessor;

public class YoutubeRequestProcessor extends GenericProcessor<YoutubeRequest> {

    public YoutubeRequestProcessor() {
        super(YoutubeRequest.class);
    }

}
