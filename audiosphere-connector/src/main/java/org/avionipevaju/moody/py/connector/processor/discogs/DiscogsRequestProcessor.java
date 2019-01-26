package org.avionipevaju.moody.py.connector.processor.discogs;

import org.avionipevaju.moody.py.connector.dto.discogs.DiscogsRequest;
import org.avionipevaju.moody.py.connector.processor.GenericProcessor;

public class DiscogsRequestProcessor extends GenericProcessor<DiscogsRequest> {

    public DiscogsRequestProcessor() {
        super(DiscogsRequest.class);
    }
}
