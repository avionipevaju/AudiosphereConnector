package org.avionipevaju.moody.py.connector.processor.content;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.avionipevaju.moody.py.connector.dto.ExecutionRequest;
import org.avionipevaju.moody.py.connector.vo.Instruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContentRequestProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentRequestProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        ExecutionRequest executionRequest = new ExecutionRequest();
        executionRequest.setInstruction(Instruction.PROCESS_ARTIST);
        executionRequest.setContent("Chroma Key");
        executionRequest.setRequestedBy("avionipevaju");
        LOGGER.info(executionRequest.toString());
        exchange.getOut().setBody(executionRequest);
    }
}
