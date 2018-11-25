package org.avionipevaju.moody.py.connector.utils;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class SecurityUtils {

    public static final Logger LOGGER = LoggerFactory.getLogger(SecurityUtils.class);

    public static final String USERNAME_HEADER = "m-py-username";

    public static final String PASSWORD_HEADER = "m-py-password";

    private static final String AUTHENTICATION_HEADER = "Authorization";

    private static final String BASIC_PREFIX = "Basic ";

    public static String generatePasskey(Exchange exchange) {
        String username = exchange.getIn().getHeader(USERNAME_HEADER, String.class);
        String password = exchange.getIn().getHeader(PASSWORD_HEADER, String.class);

        if (username == null || password == null) {
            LOGGER.info("Invalid username or password headers!");
            return null;
        }
        String toEncode = username.concat(":").concat(password);
        return new String(Base64.getEncoder().encode(toEncode.getBytes()));
    }

    public static void addAuthenticationHeader(Exchange exchange, String passkey) {
        exchange.getOut().setHeader(AUTHENTICATION_HEADER, BASIC_PREFIX.concat(passkey) );
    }

}
