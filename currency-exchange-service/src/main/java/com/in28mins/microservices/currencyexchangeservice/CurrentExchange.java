package com.in28mins.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrentExchange {
	
	private long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	
	

}
