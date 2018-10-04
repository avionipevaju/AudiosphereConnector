package org.avionipevaju.moody.py.connector.vo;

import java.util.HashMap;

public class StatusCode {

    private static HashMap<String, State> CODES = new HashMap<>();

    static {
        CODES.put("0", State.COMPLETED);
        CODES.put("-1", State.FAILED);
    }

    public static State resolveState(String statusCode) {
        State state = CODES.get(statusCode);
        return state == null ? State.UNKNOWN : state;
    }

}
