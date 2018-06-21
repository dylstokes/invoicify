package com.ally.invoicify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.Invoice;
import com.ally.invoicify.repositories.InvoiceRepository;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceRepository invoiceRepo;
	
	public InvoiceController(InvoiceRepository invoiceRepo) {
		this.invoiceRepo = invoiceRepo;
	}
	
	@GetMapping("")
	public List<Invoice> getAll() {
		return invoiceRepo.findAll();
	}
	
	@GetMapping("{id}")
	public Invoice get(@PathVariable int id) {
		return invoiceRepo.findOne(id);
	}

}
