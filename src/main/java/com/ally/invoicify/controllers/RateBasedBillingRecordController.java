package com.ally.invoicify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.services.RateBasedBillingRecordServiceImpl;

@RestController
@RequestMapping("/api/billing-record/rate-based")
public class RateBasedBillingRecordController {
	
	@Autowired
	private RateBasedBillingRecordServiceImpl service; 
	
	@PostMapping("")
	public RateBasedBillingRecord create(
			@RequestBody RateBasedBillingRecord record) {
		return service.create(record);
	}
}
