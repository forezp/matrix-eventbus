package io.github.forezp.listener;

import com.google.common.eventbus.Subscribe;
import io.github.forezp.annotation.EventListener;
import io.github.forezp.entity.Event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by forezp on 2019/5/17.
 */

@EventListener
public class EventLs {

    Logger logger= LoggerFactory.getLogger(EventLs.class);

    @Subscribe
    public void subscribe(Event event) {
        logger.info(Thread.currentThread().getName()+" async receive:"+event.getName());
    }




}
