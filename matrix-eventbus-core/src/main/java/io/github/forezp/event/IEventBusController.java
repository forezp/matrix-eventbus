package io.github.forezp.event;

import java.util.Collection;

/**
 * Created by forezp on 2019/5/17.
 */
public interface IEventBusController {

    void register(Object object);
    void unregister(Object object);
    void post(Object bean);
    void post(Collection<Object> collection);
}
