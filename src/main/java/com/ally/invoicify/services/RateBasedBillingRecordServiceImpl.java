package com.ally.invoicify.services;

import org.springframework.beans.factory.annotation.Autowired;

public class RateBasedBillingRecordServiceImpl {
	@Autowired
	private RateBasedBillingRecordRepository repo;
	
	public RateBasedBillingRecord create(RateBasedBillingRecord record) {
		return repo.save(record);
	}
}
