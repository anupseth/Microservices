package com.in28mins.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CircuitBreakerPatternController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerPatternController.class);

	// Here there will be 3 attempts made to do retry if there are error duing the
	// API call. and only if
	// Retry fails all 3 times then only it will return error response.
	@GetMapping("/sample-api-cb")
	@CircuitBreaker(name = "sample-api-cb", fallbackMethod = "hardcodedResponse")
	// @RateLimiter(name="sample-api-cb")
	@Bulkhead(name = "sample-api-cb")
	// 10s => 10000 calls to the sample api
	public String sampleApi() {
		logger.info("Sample api call received");
//			ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", 
//						String.class);
//			return forEntity.getBody();
		return "sample-api";
	}

	public String hardcodedResponse(Exception ex) {

		return "Service is down now.... " + ex.getMessage();
	}

}
