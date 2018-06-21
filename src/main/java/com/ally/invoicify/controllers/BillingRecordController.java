package com.ally.invoicify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.repositories.BillingRecordRepository;

@RestController
@RequestMapping("/api/billing-record")
public class BillingRecordController {
	
	@Autowired
	private BillingRecordRepository repo;
	
	@GetMapping("")
	private List<BillingRecord> getAll() {
		return repo.findAll();
	}
	
	@GetMapping("{id}")
	private BillingRecord get(@PathVariable int id) {
		return repo.findOne(id);
	}
}
