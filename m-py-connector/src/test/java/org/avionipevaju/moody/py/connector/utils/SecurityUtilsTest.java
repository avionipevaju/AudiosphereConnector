package org.avionipevaju.moody.py.connector.utils;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.avionipevaju.moody.py.connector.vo.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SecurityUtilsTest {

    private Exchange exchange;

    @Before
    public void setUp() {
        exchange = new DefaultExchange(new DefaultCamelContext());
        exchange.getIn().setHeader(Constants.USERNAME_HEADER, "avionipevaju");
        exchange.getIn().setHeader(Constants.PASSWORD_HEADER, "m00dyp!e");
    }

    @Test
    public void generatePasskeyTest() {
        String expectedResult = "YXZpb25pcGV2YWp1Om0wMGR5cCFl";
        String passkey = SecurityUtils.generatePasskey(exchange);
        Assert.assertEquals("Checking if passkey is generated correctly", expectedResult, passkey);
    }

    @Test
    public void addAuthenticationHeaderTest() {
        String expectedResult = "Basic YXZpb25pcGV2YWp1Om0wMGR5cCFl";
        SecurityUtils.addAuthenticationHeader(exchange, "YXZpb25pcGV2YWp1Om0wMGR5cCFl");
        String result = exchange.getOut().getHeader(Constants.AUTHENTICATION_HEADER, String.class);
        Assert.assertEquals("Checking if authentication header is set correctly", expectedResult, result);
    }

}
