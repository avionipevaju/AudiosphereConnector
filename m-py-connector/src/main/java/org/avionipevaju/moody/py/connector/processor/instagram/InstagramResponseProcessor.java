package org.avionipevaju.moody.py.connector.processor.instagram;

import org.avionipevaju.moody.py.connector.dto.instagram.InstagramResponse;
import org.avionipevaju.moody.py.connector.processor.GenericProcessor;

public class InstagramResponseProcessor extends GenericProcessor<InstagramResponse> {

    public InstagramResponseProcessor() {
        super(InstagramResponse.class);
    }
}
