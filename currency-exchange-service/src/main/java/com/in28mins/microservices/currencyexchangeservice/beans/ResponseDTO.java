package com.in28mins.microservices.currencyexchangeservice.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO {
	
	private CurrencyExchange currencyExchange;
	private Object error;

}
