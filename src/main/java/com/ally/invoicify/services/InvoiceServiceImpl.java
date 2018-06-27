package com.ally.invoicify.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.models.Invoice;
import com.ally.invoicify.models.InvoiceLineItem;
import com.ally.invoicify.models.InvoiceView;
import com.ally.invoicify.models.User;
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
	
	public List<Invoice> getAll() {
		return invoiceRepo.findAll();
	}
	
	public Invoice get(int id) {
		return invoiceRepo.findOne(id);
	}
	

	public Invoice createInvoice(@RequestBody InvoiceView invoiceView, @PathVariable int clientId) {

		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User creator = (User) auth.getPrincipal();
		List<BillingRecord> records = recordRepo.findByIdIn(invoiceView.getRecordIds());
		long nowish = Calendar.getInstance().getTimeInMillis();
		Date now = new Date(nowish);
		Invoice invoice = new Invoice();
		invoice.setInvoiceDescription(invoiceView.getInvoiceDescription());
		
		List<InvoiceLineItem> items = new ArrayList<InvoiceLineItem>();
		for (BillingRecord record : records) {
			InvoiceLineItem lineItem = new InvoiceLineItem();
			lineItem.setBillingRecord(record);
//			lineItem.setCreatedBy(creator);
			lineItem.setCreatedOn(now);
			lineItem.setInvoice(invoice);
			items.add(lineItem);
		}
		
		invoice.setLineItems(items);
		invoice.setCreatedBy(creator);
		invoice.setCreatedOn(now);
		invoice.setCompany(companyRepo.getOne(clientId));
		
		return invoiceRepo.save(invoice);
	}

}
