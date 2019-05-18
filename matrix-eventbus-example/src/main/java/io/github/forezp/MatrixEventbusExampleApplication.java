package io.github.forezp;

import io.github.forezp.annotation.EnableEventBus;
import io.github.forezp.configure.EventBusConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEventBus
public class MatrixEventbusExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatrixEventbusExampleApplication.class, args);
	}



}
