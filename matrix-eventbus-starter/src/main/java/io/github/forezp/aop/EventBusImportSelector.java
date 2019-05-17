package io.github.forezp.aop;

/**
 * <p>Title: Nepxion EventBus</p>
 * <p>Description: Nepxion EventBus AOP</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */


import com.nepxion.matrix.selector.AbstractImportSelector;
import com.nepxion.matrix.selector.RelaxedPropertyResolver;
import io.github.forezp.annotation.EnableEventBus;
import io.github.forezp.constant.EventBusConstants;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.LOWEST_PRECEDENCE - 99)
public class EventBusImportSelector extends AbstractImportSelector<EnableEventBus> {
    @Override
    protected boolean isEnabled() {
        return new RelaxedPropertyResolver(getEnvironment()).getProperty(EventBusConstants.EVENTBUS_ENABLED, Boolean.class, Boolean.TRUE);
    }
}