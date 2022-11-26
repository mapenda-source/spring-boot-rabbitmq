package com.mapenda.dev.springbootrabbitMq;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootRabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitMqApplication.class, args);
	}

	@Bean
	public Exchange fanoutExchange(@Value("${dev.exchange.name}") final String exchangeName) {
		return new FanoutExchange(exchangeName);
	}

}
