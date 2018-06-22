package com.ally.invoicify.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.models.Invoice;
import com.ally.invoicify.models.InvoiceLineItem;
import com.ally.invoicify.models.InvoiceView;
import com.ally.invoicify.repositories.BillingRecordRepository;
import com.ally.invoicify.repositories.CompanyRepository;
import com.ally.invoicify.repositories.InvoiceRepository;

@Service
public class InvoiceServiceImpl {
	
	@Autowired
	private InvoiceRepository invoiceRepo;
	
	@Autowired
	private BillingRecordRepository recordRepo;
	
	@Autowired
	private CompanyRepository companyRepo;
	
	public InvoiceServiceImpl(InvoiceRepository invoiceRepo) {
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
	
	@PostMapping("{clientId}")
	public Invoice createInvoice(@RequestBody InvoiceView invoiceView, @PathVariable int clientId) {

		List<BillingRecord> records = recordRepo.findAll(Arrays.asList(invoiceView.getRecordIds()));
		long nowish = Calendar.getInstance().getTimeInMillis();
		Date now = new Date(nowish);
		Invoice invoice = new Invoice();

		invoice.setInvoiceDescription(invoiceView.getInvoiceDescription());
		List<InvoiceLineItem> items = new ArrayList<InvoiceLineItem>();
		for (BillingRecord record : records) {
			InvoiceLineItem lineItem = new InvoiceLineItem();
			lineItem.setBillingRecord(record);
			lineItem.setCreatedOn(now);
			lineItem.setInvoice(invoice);
			items.add(lineItem);
		}

		invoice.setLineItems(items);
		invoice.setCreatedOn(now);
		invoice.setCompany(companyRepo.findOne(clientId));

		return invoiceRepo.save(invoice);
	}

}
