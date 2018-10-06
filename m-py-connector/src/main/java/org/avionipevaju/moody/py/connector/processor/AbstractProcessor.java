package org.avionipevaju.moody.py.connector.processor;

import org.apache.camel.Processor;
import static org.avionipevaju.moody.py.connector.logger.Logger.logJson;
import static org.avionipevaju.moody.py.connector.logger.Logger.logXml;


public abstract class AbstractProcessor implements Processor {

    protected void logAsJson(Object object) {
        logJson(object);
    }

    protected void logAsXml(Object object) {
        logXml(object);
    }

}
