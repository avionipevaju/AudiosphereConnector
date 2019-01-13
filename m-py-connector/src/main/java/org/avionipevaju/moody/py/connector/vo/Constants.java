package org.avionipevaju.moody.py.connector.vo;

public class Constants {

    public static final String INSTAGRAM_FORMATTED_URL = "instagram:formatted-url";

    public static final String USERNAME_HEADER = "m-py-username";

    public static final String PASSWORD_HEADER = "m-py-password";

    public static final String USERNAME_HEADER_PROPERTY = "property::m-py-username";

    public static final String PASSWORD_HEADER_PROPERTY = "property::m-py-password";

    public static final String ENTRY_REQUEST_USERNAME_PROPERTY = "property::username";

    public static final String AUTHENTICATION_HEADER = "Authorization";

    public static final String BASIC_PREFIX = "Basic ";

    public static final String CONTENT_TYPE = "application/json";

    public class Route {

        public static final String DISCOGS_ARTIST_ROUTE = "direct:DiscogsArtist";

        public static final String DISCOGS_GENRE_ROUTE = "direct:DiscogsGenre";

        public static final String YOUTUBE_ROUTE = "direct:Youtube";

        public static final String TWITTER_ROUTE = "direct:Twitter";

        public static final String TWITTER_MOOD_ROUTE = "direct:TwitterMood";

        public static final String INSTAGRAM_ROUTE = "direct:Instagram";

        public static final String YAHOO_WEATHER_ROUTE = "direct:YahooWeather";

    }

}
