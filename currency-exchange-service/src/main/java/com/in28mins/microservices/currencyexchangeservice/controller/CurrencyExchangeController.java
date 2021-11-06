package com.in28mins.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28mins.microservices.currencyexchangeservice.CurrencyExchangeRepo;
import com.in28mins.microservices.currencyexchangeservice.beans.CurrencyExchange;
import com.in28mins.microservices.currencyexchangeservice.beans.ResponseDTO;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeRepo currencyExchangeRepo;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ResponseDTO retreiveExchangeValue(@PathVariable String from, @PathVariable String to) {

		CurrencyExchange currentExchange = currencyExchangeRepo.findByFromAndTo(from, to);

		ResponseDTO responseDTO = new ResponseDTO();
		if (currentExchange == null) {
			responseDTO.setCurrencyExchange(null);
			responseDTO.setError("No Conversion exist between these countries !!!");
		} else {
			responseDTO.setError(null);
			currentExchange.setEnvironment(environment.getProperty("local.server.port"));
			responseDTO.setCurrencyExchange(currentExchange);
		}

		return responseDTO;
	}

}
