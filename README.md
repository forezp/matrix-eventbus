# matrix-eventbus


[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?label=license)](https://github.com/forezp/matrix-eventbus/blob/master/LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.forezp/matrix-eventbus-starter.svg?label=maven%20central)](http://mvnrepository.com/artifact/io.github.forezp/matrix-eventbus-starter)

## 这个项目干嘛的?

基于guava的消息订阅事件。

## 怎么用

```$xslt

<dependency>
  <groupId>io.github.forezp</groupId>
  <artifactId>matrix-eventbus-starter</artifactId>
  <version>1.0</version>
</dependency>
```

### 开启

```$xslt
@SpringBootApplication
@EnableEventBus
public class MatrixEventbusExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatrixEventbusExampleApplication.class, args);
	}
}
```

### 创建消息实体

````$xslt

public class Event {

    private String name;

    public Event(String name){
        this.name=name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


````

### 发布消息

```$xslt

   @Autowired
    EventBusControllerFactory eventBusControllerFactory;

    @GetMapping("/test")
    public String test(){
        logger.info(Thread.currentThread().getName()+" aysnc post :lucy");
        //发送异步消息
        eventBusControllerFactory.getAsyncController().post(new Event("lucy"));
        logger.info(Thread.currentThread().getName()+"  sync post :lily");
        //发送同步消息
        eventBusControllerFactory.getSyncController().post(new Event("lily"));

        logger.info("ok");
        return "ok";
    }
```

###  接受异步消息

````$xslt

@EventListener
public class EventLs {

    Logger logger= LoggerFactory.getLogger(EventLs.class);

    @Subscribe
    public void subscribe(Event event) {
        logger.info(Thread.currentThread().getName()+" async receive:"+event.getName());
    }
}
````


### 接收同步消息


```$xslt

@EventListener(async = false)
public class SynEventLs {

    Logger logger= LoggerFactory.getLogger(SynEventLs.class);

    @Subscribe
    public void subscribe(Event event) {
        logger.info(Thread.currentThread().getName()+" sync receive::"+event.getName());
    }

}

```

