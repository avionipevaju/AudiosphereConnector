package org.avionipevaju.moody.py.connector.logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.LoggerFactory;

public class Logger {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Logger.class);

    private static Logger instance;

    private ObjectMapper objectMapper;

    private XmlMapper xmlMapper;

    private Logger(){
        objectMapper = new ObjectMapper();
        xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    private static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public static void logJson(Object object) {
        try {
            LOGGER.info(getInstance().objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object));
        } catch (JsonProcessingException e) {
            LOGGER.error("Error logging JSON for object {}", object);
        }
    }

    public static void logXml(Object object) {
        try {
            LOGGER.info(getInstance().xmlMapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            LOGGER.error("Error logging XML for object {}", object);
        }
    }

}
