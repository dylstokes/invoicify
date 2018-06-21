package com.ally.invoicify.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.FlatFeeBillingRecord;
import com.ally.invoicify.services.FlatFeeBillingRecordServiceImpl;

@RestController
@RequestMapping("/api/billing-record/flat-fee")
public final class FlatFeeBillingRecordController {
	
	private FlatFeeBillingRecordServiceImpl service = new FlatFeeBillingRecordServiceImpl();
	
	@PostMapping()
	public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord record) {
		return service.create(record);
	}
}
