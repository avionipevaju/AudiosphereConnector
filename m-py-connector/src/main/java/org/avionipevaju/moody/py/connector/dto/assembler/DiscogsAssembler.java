package org.avionipevaju.moody.py.connector.dto.assembler;

import org.avionipevaju.moody.py.connector.dto.discogs.DiscogsRequest;
import org.avionipevaju.moody.py.connector.dto.entry.EntryRequest;

public class DiscogsAssembler {

    public static DiscogsRequest createDiscogsArtistRequest(EntryRequest entryRequest) {
        DiscogsRequest discogsRequest = new DiscogsRequest();
        discogsRequest.setArtist(entryRequest.getInformation());
        return discogsRequest;
    }

    public static DiscogsRequest createDiscogsGenreRequest(EntryRequest entryRequest) {
        DiscogsRequest discogsRequest = new DiscogsRequest();
        discogsRequest.setGenre(entryRequest.getInformation());
        return discogsRequest;
    }

}
