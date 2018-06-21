package com.ally.invoicify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.repositories.BillingRecordRepository;

public class BillingRecordServiceImpl {
	@Autowired
	private BillingRecordRepository repo;
	
	public BillingRecord get(Integer id) {
		return repo.findOne(id);
	}
	
	public List<BillingRecord> getAll() {
		return repo.findAll();
	}
	
	public boolean delete(Integer id) {
		BillingRecord record = repo.findOne(id);
		repo.delete(id);
		return record != null;
	}
}
