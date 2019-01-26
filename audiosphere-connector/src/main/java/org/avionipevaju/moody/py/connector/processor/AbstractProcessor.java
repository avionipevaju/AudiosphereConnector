package org.avionipevaju.moody.py.connector.processor;

import org.apache.camel.Processor;
import static org.avionipevaju.moody.py.connector.logger.Logger.logJson;
import static org.avionipevaju.moody.py.connector.logger.Logger.logXml;


public abstract class AbstractProcessor implements Processor {

    protected void logAsJson(Object body) {
        logJson(body);
    }

    protected void logAsJson(Object header, Object body) {
        logJson(header, body);
    }

    protected void logAsXml(Object body) {
        logXml(body);
    }

    protected void logAsXml(Object header, Object body) {
        logXml(header, body);
    }

}
