package com.ally.invoicify.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.models.Invoice;
import com.ally.invoicify.models.InvoiceLineItem;
import com.ally.invoicify.models.InvoiceView;
import com.ally.invoicify.repositories.BillingRecordRepository;
import com.ally.invoicify.repositories.CompanyRepository;
import com.ally.invoicify.repositories.InvoiceRepository;
import com.ally.invoicify.services.FlatFeeBillingRecordServiceImpl;
import com.ally.invoicify.services.InvoiceServiceImpl;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceServiceImpl service;
	
	@GetMapping("")
	public List<Invoice> getAll() {
		return service.getAll();
	}
	
	@GetMapping("{id}")
	public Invoice get(@PathVariable int id) {
		return service.get(id);
	}
	
	@PostMapping("{clientId}")
	public Invoice createInvoice(@RequestBody InvoiceView invoiceView, @PathVariable int clientId) {
		return service.createInvoice(invoiceView, clientId);
	}
}
