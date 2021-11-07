package com.in28mins.microservices.currencyconversionservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28mins.microservices.currencyconversionservice.beans.CurrencyConversion;

// Enable the feign by adding annotation in main class
// use the application name of the MS that you want to call. 
@FeignClient(name = "currency-exchange",url = "localhost:8000") 
public interface CurrencyExchangeProxcy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retreiveExchangeValue(@PathVariable String from, @PathVariable String to);
}
