package com.Payment.Gateway.Simulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PaymentGatewaySimulationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentGatewaySimulationSystemApplication.class, args);
	}

}
