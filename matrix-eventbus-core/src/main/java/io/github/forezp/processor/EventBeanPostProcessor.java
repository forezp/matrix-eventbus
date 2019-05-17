package io.github.forezp.processor;

import io.github.forezp.annotation.EventListener;
import io.github.forezp.event.EventBusControllerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by forezp on 2019/5/17.
 */
public class EventBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    EventBusControllerFactory eventBusControllerFactory;

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (o.getClass().isAnnotationPresent(EventListener.class)) {
            EventListener eventBusAnnotation = o.getClass().getAnnotation(EventListener.class);
            String identifier = eventBusAnnotation.identifier();
            boolean async = eventBusAnnotation.async();
            if(async) {
                eventBusControllerFactory.getController(identifier, EventBusControllerFactory.EventBusType.ASYNC).register(o);
            }else {
                eventBusControllerFactory.getController(identifier, EventBusControllerFactory.EventBusType.SYNC).register(o);
            }
        }

        return o;
    }
}
