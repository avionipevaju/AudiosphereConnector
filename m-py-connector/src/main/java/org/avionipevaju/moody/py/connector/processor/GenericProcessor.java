package org.avionipevaju.moody.py.connector.processor;

import org.apache.camel.Exchange;

public abstract class GenericProcessor<Type> extends AbstractProcessor {

    private Class<Type> dtoClass;

    public GenericProcessor(Class<Type> dtoClass) {
        this.dtoClass = dtoClass;
    }

    public GenericProcessor() {
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        Type dtoClass = exchange.getIn().getBody(getDtoClass());
        logAsJson(dtoClass);
        exchange.getOut().setBody(dtoClass);
    }

    public Class<Type> getDtoClass() {
        return dtoClass;
    }

    public void setDtoClass(Class<Type> dtoClass) {
        this.dtoClass = dtoClass;
    }
}
