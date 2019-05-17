package io.github.forezp.listener;

import com.google.common.eventbus.Subscribe;
import io.github.forezp.annotation.EventListener;
import io.github.forezp.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by forezp on 2019/5/17.
 */
@EventListener(async = false)
public class SynEventLs {

    Logger logger= LoggerFactory.getLogger(SynEventLs.class);

    @Subscribe
    public void subscribe(Event event) {
        logger.info(Thread.currentThread().getName()+" sync receive::"+event.getName());
    }

}
