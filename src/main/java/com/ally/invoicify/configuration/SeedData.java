package com.ally.invoicify.configuration;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ally.invoicify.models.Company;
import com.ally.invoicify.models.Invoice;
import com.ally.invoicify.models.InvoiceLineItem;
import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.repositories.CompanyRepository;
import com.ally.invoicify.repositories.InvoiceRepository;
import com.ally.invoicify.repositories.RateBasedBillingRecordRepository;

@Configuration
@Profile("development")
public class SeedData {
	//Double rate, Double quantity, Date createdOn, String description, InvoiceLineItem inv, Company company, Double total
	//Date createdOn, Invoice inv
	//Date createdOn, String description, Company company
	public SeedData(CompanyRepository companyRepo, RateBasedBillingRecordRepository ratebasedRepo, InvoiceRepository invoiceRepo) {
		Company c = new Company("Ally");
		companyRepo.save(c);
		Invoice i = new Invoice(new Date(2010,3,4),"",c);
		//InvoiceLineItem ili = new InvoiceLineItem(new Date(2010,3,4),i);
		RateBasedBillingRecord r = new RateBasedBillingRecord(2.0,2.0,new Date(2010,3,4),"",c);
		
		InvoiceLineItem ili = new InvoiceLineItem(new Date(2010,3,4),i);
		invoiceRepo.save(i);
		ratebasedRepo.save(r);
		
		
	}
}
