package com.ally.invoicify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.invoicify.models.FlatFeeBillingRecord;
import com.ally.invoicify.repositories.FlatFeeBillingRecordRepository;

@Service
public class FlatFeeBillingRecordServiceImpl {
	@Autowired
	private FlatFeeBillingRecordRepository repo;
	
	public FlatFeeBillingRecordServiceImpl(FlatFeeBillingRecordRepository repo) {
		this.repo = repo;
	}
	
	public List<FlatFeeBillingRecord> getAll() {
		return repo.findAll();
	}
	
	public FlatFeeBillingRecord create(FlatFeeBillingRecord record) {
		return repo.save(record);
	}
}
