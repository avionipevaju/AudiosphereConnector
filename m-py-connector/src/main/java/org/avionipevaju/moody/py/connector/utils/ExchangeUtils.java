package org.avionipevaju.moody.py.connector.utils;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.vo.Constants;

public class ExchangeUtils {

    public static void storeAuthorizationHeadersInExchange(Exchange exchange) {
        String username = exchange.getIn().getHeader(Constants.USERNAME_HEADER, String.class);
        String password = exchange.getIn().getHeader(Constants.PASSWORD_HEADER, String.class);
        storeValueInExchange(exchange, Constants.USERNAME_HEADER_PROPERTY, username);
        storeValueInExchange(exchange, Constants.PASSWORD_HEADER_PROPERTY, password);
    }

    public static void returnAuthorizationHeadersFromExchange(Exchange exchange) {
        exchange.getOut().setHeader(Constants.USERNAME_HEADER, getValueFromExchange(exchange, Constants.USERNAME_HEADER_PROPERTY));
        exchange.getOut().setHeader(Constants.PASSWORD_HEADER, getValueFromExchange(exchange, Constants.PASSWORD_HEADER_PROPERTY));
    }

    public static void storeValueInExchange(Exchange exchange, String key, String value) {
        exchange.setProperty(key, value);
    }

    public static String getValueFromExchange(Exchange exchange, String key) {
        return exchange.getProperty(key, String.class);
    }

}
