package org.avionipevaju.moody.py.connector.processor.discogs;

import org.avionipevaju.moody.py.connector.dto.discogs.DiscogsResponse;
import org.avionipevaju.moody.py.connector.processor.GenericProcessor;

public class DiscogsResponseProcessor extends GenericProcessor<DiscogsResponse> {

    public DiscogsResponseProcessor() {
        super(DiscogsResponse.class);
    }
}
