package com.ally.invoicify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.services.BillingRecordServiceImpl;

@RestController
@RequestMapping("/api/billing-record")
public class BillingRecordController {
	
	@Autowired
	private BillingRecordServiceImpl service;
	
	public BillingRecordController(BillingRecordServiceImpl service) {
		this.service = service;
	}
	
	@GetMapping("")
	public List<BillingRecord> getAll() {
		return service.getAll();
	}
	
	@GetMapping("{id}")
	public BillingRecord get(@PathVariable Integer id) {
		return service.get(id);
	}
}
