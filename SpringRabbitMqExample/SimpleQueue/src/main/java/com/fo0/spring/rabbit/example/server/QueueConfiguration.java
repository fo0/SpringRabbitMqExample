package com.fo0.spring.rabbit.example.server;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class QueueConfiguration {

	@Bean
	public Queue serverQueue() {
		return new Queue("tut.rpc.requests", false);
	}

	@Bean
	public DirectExchange exchange() {
		return new DirectExchange("tut.rpc", false, true);
	}

	@Bean
	public Binding binding(DirectExchange exchange, Queue queue) {
		return BindingBuilder.bind(queue).to(exchange).with("rpc");
	}

}