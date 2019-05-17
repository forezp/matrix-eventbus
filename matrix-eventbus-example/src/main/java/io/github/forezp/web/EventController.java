package io.github.forezp.web;

import io.github.forezp.annotation.EnableEventBus;
import io.github.forezp.entity.Event;

import io.github.forezp.event.EventBusControllerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by forezp on 2019/5/17.
 */
@RestController
@EnableEventBus
public class EventController {

    Logger logger=LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventBusControllerFactory eventBusControllerFactory;

    @GetMapping("/test")
    public String test(){
        logger.info(Thread.currentThread().getName()+" aysnc post :lucy");
        eventBusControllerFactory.getAsyncController().post(new Event("lucy"));
        logger.info(Thread.currentThread().getName()+"  sync post :lily");
        eventBusControllerFactory.getSyncController().post(new Event("lily"));

        logger.info("ok");
        return "ok";
    }
}
