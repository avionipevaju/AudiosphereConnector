package org.avionipevaju.moody.py.connector.dto.twitter;

import org.avionipevaju.moody.py.connector.vo.Instruction;

public class ExecutionRequest {

    private Instruction instruction;

    private String content;

    private String requestedBy;

    public ExecutionRequest() {
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }
}
