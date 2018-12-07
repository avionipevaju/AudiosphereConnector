package org.avionipevaju.moody.py.connector.utils;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.vo.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class SecurityUtils {

    public static final Logger LOGGER = LoggerFactory.getLogger(SecurityUtils.class);

    public static String generatePasskey(Exchange exchange) {
        String username = exchange.getIn().getHeader(Constants.USERNAME_HEADER, String.class);
        String password = exchange.getIn().getHeader(Constants.PASSWORD_HEADER, String.class);

        if (username == null || password == null) {
            LOGGER.info("Invalid username or password headers!");
            return null;
        }
        String toEncode = username.concat(":").concat(password);
        return new String(Base64.getEncoder().encode(toEncode.getBytes()));
    }

    public static void addAuthenticationHeader(Exchange exchange, String passkey) {
        exchange.getOut().setHeader(Constants.AUTHENTICATION_HEADER, Constants.BASIC_PREFIX.concat(passkey) );
    }

}
