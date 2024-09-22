package tech.silva.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PayMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayMasterApplication.class, args);
	}

}
