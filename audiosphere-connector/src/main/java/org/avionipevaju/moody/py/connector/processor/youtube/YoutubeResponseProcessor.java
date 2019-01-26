package org.avionipevaju.moody.py.connector.processor.youtube;

import org.avionipevaju.moody.py.connector.dto.youtube.YoutubeResponse;
import org.avionipevaju.moody.py.connector.processor.GenericProcessor;

public class YoutubeResponseProcessor extends GenericProcessor<YoutubeResponse> {

    public YoutubeResponseProcessor() {
        super(YoutubeResponse.class);
    }
}
