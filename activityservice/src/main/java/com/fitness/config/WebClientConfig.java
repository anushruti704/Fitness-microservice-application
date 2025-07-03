package com.fitness.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {
	
	@Bean
	@LoadBalanced
	public WebClient.Builder webClientBuilder() {
		
		HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
	    return WebClient.builder()
	            .clientConnector(new ReactorClientHttpConnector(httpClient));
//		return WebClient.builder();
	}
	
	@Bean
	public WebClient userServiceWebClient(WebClient.Builder webClientBuilder) {
		return webClientBuilder
				.baseUrl("http://USER-SERVICE")
				.build();
	}
	
}
