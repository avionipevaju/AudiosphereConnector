package org.avionipevaju.moody.py.connector.processor.scheduler.instagram;

import org.apache.camel.Exchange;
import org.avionipevaju.moody.py.connector.dto.instagram.ExecutionResponse;
import org.avionipevaju.moody.py.connector.dto.twitter.ExecutionRequest;
import org.avionipevaju.moody.py.connector.processor.AbstractProcessor;
import org.avionipevaju.moody.py.connector.utils.SecurityUtils;
import org.avionipevaju.moody.py.connector.vo.Instruction;

public class InstagramSchedulerRequestProcessor extends AbstractProcessor {

    private final String INSTAGRAM_POST_FORMAT = "User %s posted on Instagram %s";

    @Override
    public void process(Exchange exchange) throws Exception {
        ExecutionResponse instagramExecutionResponse = exchange.getIn().getBody(ExecutionResponse.class);
        logAsJson(instagramExecutionResponse);
        ExecutionRequest executionRequest = new ExecutionRequest();
        executionRequest.setInstruction(Instruction.PROCESS_INSTAGRAM_POST);
        String content = instagramExecutionResponse.getImageUrl() + " " + instagramExecutionResponse.getCaption();
        executionRequest.setContent(String.format(INSTAGRAM_POST_FORMAT, instagramExecutionResponse.getUsername(), content));
        executionRequest.setRequestedBy(exchange.getProperty(SecurityUtils.USERNAME_HEADER, String.class));
        exchange.getOut().setHeader(SecurityUtils.USERNAME_HEADER, exchange.getProperty(SecurityUtils.USERNAME_HEADER));
        exchange.getOut().setHeader(SecurityUtils.PASSWORD_HEADER, exchange.getProperty(SecurityUtils.PASSWORD_HEADER));
        logAsJson(executionRequest);
        exchange.getOut().setBody(executionRequest);
    }

}
