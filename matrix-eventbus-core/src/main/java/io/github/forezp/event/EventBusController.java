package io.github.forezp.event;

import com.google.common.eventbus.EventBus;

import java.util.Collection;

/**
 * Created by forezp on 2019/5/17.
 */

public class EventBusController implements IEventBusController {

    private EventBus eventBus;

    public EventBusController(EventBus eventBus) {
        this.eventBus = eventBus;
    }


    @Override
    public void register(Object object) {
        eventBus.register(object);
    }

    @Override
    public void unregister(Object object) {
        eventBus.unregister(object);
    }

    @Override
    public void post(Object bean) {
        eventBus.post(bean);
    }

    @Override
    public void post(Collection<Object> collection) {

        for (Object o : collection) {
            eventBus.post(o);
        }
    }
}
