package com.in28mins.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrentExchange retreiveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		return new CurrentExchange(1111, from, to, BigDecimal.valueOf(50));
	}

}
