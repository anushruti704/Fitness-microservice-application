package com.fitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserValidationService {
	
	private final WebClient userServiceWebClient;
	
	public boolean validateUser(String userId) {
		log.info("calling User validation API for user id: (uservalidationservice)"+userId);
		try {
					return userServiceWebClient.get()
                    .uri("/api/users/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
		} catch (WebClientResponseException e) {
			if(e.getStatusCode() == HttpStatus.NOT_FOUND)
				throw new RuntimeException("User not found");
			else if(e.getStatusCode() == HttpStatus.BAD_REQUEST)
				throw new RuntimeException("Invalid user id");
		}
		return false;
		
	}
	
}
