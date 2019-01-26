package org.avionipevaju.moody.py.connector.logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.LoggerFactory;

public class Logger {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Logger.class);

    private static final String LOG_FORMAT = "Headers:\n %s ##### \n Body:\n %s";

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

    public static void logJson(Object body) {
        try {
            LOGGER.info(getInstance().objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body));
        } catch (JsonProcessingException e) {
            LOGGER.error("Error logging JSON for request with body {}", body);
        }
    }

    public static void logJson(Object header, Object body) {
        try {
            String headerString = getInstance().objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(header);
            String bodyString = getInstance().objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
            LOGGER.info(String.format(LOG_FORMAT, headerString, bodyString));
        } catch (JsonProcessingException e) {
            LOGGER.error("Error logging JSON for request with body {}", body);
        }
    }

    public static void logXml(Object body) {
        try {
            LOGGER.info(getInstance().xmlMapper.writeValueAsString(body));
        } catch (JsonProcessingException e) {
            LOGGER.error("Error logging XML for request with body {}", body);
        }
    }

    public static void logXml(Object header, Object body) {
        try {
            String headerString = getInstance().xmlMapper.writeValueAsString(header);
            String bodyString = getInstance().xmlMapper.writeValueAsString(body);
            LOGGER.info(String.format(LOG_FORMAT, headerString, bodyString));
        } catch (JsonProcessingException e) {
            LOGGER.error("Error logging XML for request with body {}", body);
        }
    }

}
