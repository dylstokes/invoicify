package com.ally.invoicify.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.FlatFeeBillingRecord;

@RestController
@RequestMapping("/api/billing-record/flat-fee")
public final class FlatFeeBillingRecordController {

	@PostMapping()
	public FlatFeeBillingRecord create() {
		FlatFeeBillingRecord flatFeeBillingRecord = new FlatFeeBillingRecord(0);
		return flatFeeBillingRecord;
	}
}
