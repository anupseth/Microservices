package com.in28mins.microservices.currencyconversionservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28mins.microservices.currencyconversionservice.beans.CurrencyConversion;

// Enable the feign by adding annotation in main class


// use the application name of the MS that you want to call. 
// If we are not using naming server then we can just use this annotation 
//@FeignClient(name = "currency-exchange",url = "localhost:8000") 

// when we can are using naming server and we want to do load balancing then we can do this.
// So in this MS there is a load balancer component (spring-cloud-loadbalancer) which is talking to naming server and doing Load balancing. 
// This is called client side load balancing.
@FeignClient(name = "currency-exchange") 
public interface CurrencyExchangeProxcy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retreiveExchangeValue(@PathVariable String from, @PathVariable String to);
}
