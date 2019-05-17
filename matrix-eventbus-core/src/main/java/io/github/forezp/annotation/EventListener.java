package io.github.forezp.annotation;



import org.springframework.stereotype.Component;

import java.lang.annotation.*;

import static io.github.forezp.constant.EventBusConstants.PUBLIC_EVENTBUS;

/**
 * Created by forezp on 2019/5/17.
 */

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Component
public @interface EventListener {

    String identifier()default PUBLIC_EVENTBUS;

    boolean async() default true;


}
