package org.avionipevaju.moody.py.connector.processor;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.avionipevaju.moody.py.connector.dto.twitter.ExecutionRequest;
import org.avionipevaju.moody.py.connector.processor.content.ContentRequestProcessor;
import org.avionipevaju.moody.py.connector.vo.Constants;
import org.avionipevaju.moody.py.connector.vo.Instruction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContentRequestProcessorTest {

    private Exchange exchange;

    private ContentRequestProcessor contentRequestProcessor;

    private ExecutionRequest executionRequest;

    @Before
    public void setUp() {
        contentRequestProcessor = new ContentRequestProcessor();
        exchange = new DefaultExchange(new DefaultCamelContext());
        exchange.getIn().setHeader(Constants.USERNAME_HEADER, "avionipevaju");
        exchange.getIn().setHeader(Constants.PASSWORD_HEADER, "m00dyp!e");
        executionRequest = new ExecutionRequest();
        executionRequest.setInstruction(Instruction.PROCESS_ARTIST);
        executionRequest.setRequestedBy("avionipevaju");
        executionRequest.setContent("Mogwai");
        exchange.getIn().setBody(executionRequest);
    }

    @Test
    public void processTest() throws Exception {
        String expectedHeader = "Basic YXZpb25pcGV2YWp1Om0wMGR5cCFl";
        contentRequestProcessor.process(exchange);
        String header = exchange.getOut().getHeader(Constants.AUTHENTICATION_HEADER, String.class);
        Assert.assertEquals("Checking if authentication header is set correctly", expectedHeader, header);
        Assert.assertEquals("Checking if Body out is correct", executionRequest, exchange.getOut().getBody(ExecutionRequest.class));
    }

}
