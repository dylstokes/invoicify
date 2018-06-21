package com.ally.invoicify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.repositories.RateBasedBillingRecordRepository;

@Service
public class RateBasedBillingRecordServiceImpl {
	@Autowired
	private RateBasedBillingRecordRepository repo;
	
	public RateBasedBillingRecordServiceImpl(RateBasedBillingRecordRepository repo) {
		this.repo = repo;
	}
	
	public RateBasedBillingRecord create(RateBasedBillingRecord record) {
		return repo.save(record);
	}
}
