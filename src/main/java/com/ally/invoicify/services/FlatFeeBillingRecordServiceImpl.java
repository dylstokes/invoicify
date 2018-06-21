package com.ally.invoicify.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.ally.invoicify.models.FlatFeeBillingRecord;
import com.ally.invoicify.repositories.FlatFeeBillingRecordRepository;

public class FlatFeeBillingRecordServiceImpl {
	@Autowired
	private FlatFeeBillingRecordRepository repo;
	
	public FlatFeeBillingRecord create(FlatFeeBillingRecord record) {
		return repo.save(record);
	}
}
