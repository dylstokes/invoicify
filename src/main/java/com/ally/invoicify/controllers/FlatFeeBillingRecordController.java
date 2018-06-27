package com.ally.invoicify.controllers;

import javax.xml.ws.Service;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.Company;
import com.ally.invoicify.models.FlatFeeBillingRecord;
import com.ally.invoicify.models.User;
import com.ally.invoicify.services.CompanyServiceImpl;
//import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.services.FlatFeeBillingRecordServiceImpl;

@RestController
@RequestMapping("/api/billing-record/flat-fee")
public final class FlatFeeBillingRecordController {
	
	@Autowired
	private FlatFeeBillingRecordServiceImpl billingService;
	
	@Autowired 
	private CompanyServiceImpl companyService;
	
//	@PostMapping("")
//	public FlatFeeBillingRecord create(
//			@RequestBody FlatFeeBillingRecord record) {
//		record.setCreatedBy(userService.getCurrentUser());
//		return service.create(record);
//	}
//	
	@PostMapping("{clientId}")
	public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord record, @PathVariable Integer clientId) {
		
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		
		Company client = companyService.get(clientId);
		record.setClient(client);
		
		record.setCreatedBy(user);
		
		return billingService.create(record);
	}
}
