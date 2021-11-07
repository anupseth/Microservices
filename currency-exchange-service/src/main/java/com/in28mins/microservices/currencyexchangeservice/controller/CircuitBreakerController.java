package com.in28mins.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	// Here there will be 3 attempts made to do retry if there are error duing the API call. and only if 
	// Retry fails all 3 times then only it will return error response.
	@GetMapping("/sample-api-retry")
	@Retry(name = "sample-api-retry", fallbackMethod = "hardcodedResponse")
	public String sampleApiRetryApproach() {
		logger.info("Sample API call received");
		
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", 
				String.class);
		
		return forEntity.getBody();
	}
	
	public String hardcodedResponse(Exception ex) {
		
		return "Service is down now.... " + ex.getMessage();
	}

}
