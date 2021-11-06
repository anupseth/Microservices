package com.in28mins.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28mins.microservices.currencyexchangeservice.beans.CurrencyExchange;

public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange, Long> {
	
	CurrencyExchange findByFromAndTo(String from, String to);

}
