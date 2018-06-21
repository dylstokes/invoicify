package com.ally.invoicify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.services.BillingRecordServiceImpl;

@RestController
@ResponseBody
@RequestMapping("/api/billing-record")
public class BillingRecordController {
	
	@Autowired
	private BillingRecordServiceImpl service;
	
	@GetMapping("")
	public List<BillingRecord> getAll() {
		return service.getAll();
	}
	
	@GetMapping("{id}")
	public BillingRecord get(@PathVariable int id) {
		return service.get(id);
	}
}
