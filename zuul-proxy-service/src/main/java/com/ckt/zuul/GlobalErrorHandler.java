package com.ckt.zuul;

import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.server.ServerWebExchange;

import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@Configuration
@Order(-2)
public class GlobalErrorHandler implements ErrorWebExceptionHandler {

	private ObjectMapper objectMapper;

	public GlobalErrorHandler(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {

		DataBufferFactory bufferFactory = serverWebExchange.getResponse().bufferFactory();

		serverWebExchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
		serverWebExchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
		DataBuffer dataBuffer = bufferFactory.wrap("Access Denied".getBytes());
		return serverWebExchange.getResponse().writeWith(Mono.just(dataBuffer));
	}

}
