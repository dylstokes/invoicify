package com.ally.invoicify.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.repositories.RateBasedBillingRecordRepository;

public class RateBasedBillingRecordServiceImpl {
	@Autowired
	private RateBasedBillingRecordRepository repo;
	
	public RateBasedBillingRecord create(RateBasedBillingRecord record) {
		return repo.save(record);
	}
}
