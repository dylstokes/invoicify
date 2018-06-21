package com.ally.invoicify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.services.BillingRecordServiceImpl;

@RestController
@RequestMapping("/api/billing-record")
public class BillingRecordController {
	
	private BillingRecordServiceImpl service = new BillingRecordServiceImpl();
	
	@GetMapping("")
	public List<BillingRecord> getAll() {
		return service.getAll();
	}
	
	@GetMapping("{id}")
	public BillingRecord get(@PathVariable int id) {
		return service.get(id);
	}
}
