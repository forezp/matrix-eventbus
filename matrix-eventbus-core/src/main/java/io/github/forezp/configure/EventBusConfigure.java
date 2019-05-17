package io.github.forezp.configure;

import io.github.forezp.event.EventBusControllerFactory;
import io.github.forezp.processor.EventBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by forezp on 2019/5/17.
 */
@Configuration
public class EventBusConfigure {

    @Bean
    public EventBeanPostProcessor eventBeanPostProcessor(){

        return new EventBeanPostProcessor();
    }

    @Bean
    public EventBusControllerFactory eventBusControllerFactory(){
        return new EventBusControllerFactory();
    }
}
