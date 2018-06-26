package com.ally.invoicify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.Company;
import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.services.CompanyServiceImpl;
import com.ally.invoicify.services.RateBasedBillingRecordServiceImpl;

@RestController
@RequestMapping("/api/billing-record/rate-based")
public class RateBasedBillingRecordController {
	
	@Autowired
	private RateBasedBillingRecordServiceImpl billingService;
	
	@Autowired 
	private CompanyServiceImpl companyService;
	
//	@PostMapping("")
//	public RateBasedBillingRecord create(
//			@RequestBody RateBasedBillingRecord record) {
//		return service.create(record);
//	}
	
	@PostMapping("{clientId}")
	public RateBasedBillingRecord create(@RequestBody RateBasedBillingRecord record, @PathVariable Integer clientId) {
		
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		Company client = companyService.get(clientId);
		record.setCompany(client);
		record.setCreatedBy(user);
		
		return billingService.create(record);
	}
}
