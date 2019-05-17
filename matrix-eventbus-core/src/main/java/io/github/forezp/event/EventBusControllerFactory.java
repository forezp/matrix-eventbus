package io.github.forezp.event;


import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import io.github.forezp.constant.EventBusConstants;
import io.github.forezp.scrorpio.concurrent.threadpool.ThreadPoolFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by forezp on 2019/5/17.
 */
public class EventBusControllerFactory {

    private ConcurrentHashMap<String, IEventBusController> syncEventBusControllerMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, IEventBusController> asyncEventBusControllerMap = new ConcurrentHashMap<>();

    public IEventBusController getAsyncController() {
        return getController(EventBusConstants.PUBLIC_EVENTBUS, EventBusType.ASYNC);
    }

    public IEventBusController getSyncController() {
        return getController(EventBusConstants.PUBLIC_EVENTBUS, EventBusType.SYNC);
    }

    public IEventBusController getAsyncController(String identifier) {
        return getController(identifier, EventBusType.ASYNC);
    }


    public IEventBusController getSyncController(String identifier) {
        return getController(identifier, EventBusType.SYNC);
    }


    public IEventBusController getController(String identifier, EventBusType type) {

        switch (type) {
            case SYNC:

                IEventBusController eventBusControllerSync = syncEventBusControllerMap.get(identifier);
                if (eventBusControllerSync != null) {
                    return eventBusControllerSync;
                } else {
                    eventBusControllerSync = new EventBusController(new EventBus(identifier));
                    syncEventBusControllerMap.putIfAbsent(identifier, eventBusControllerSync);
                    return eventBusControllerSync;
                }

            case ASYNC:

                IEventBusController eventBusControllerAsync = asyncEventBusControllerMap.get(identifier);
                if (eventBusControllerAsync != null) {
                    return eventBusControllerAsync;
                } else {
                    eventBusControllerAsync = new EventBusController(new AsyncEventBus(identifier, ThreadPoolFactory.createDefaultPoolExecutor()));
                    asyncEventBusControllerMap.putIfAbsent(identifier, eventBusControllerAsync);
                    return eventBusControllerAsync;
                }

            default:
                return null;
        }


    }


   public enum EventBusType {

        SYNC, ASYNC

    }
}
