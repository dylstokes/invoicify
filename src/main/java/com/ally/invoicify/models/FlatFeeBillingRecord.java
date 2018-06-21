package com.ally.invoicify.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="flatFeeBillingRecords")
public class FlatFeeBillingRecord extends BillingRecord {
	
	private Double amount;
	
	public FlatFeeBillingRecord(Double amount, Date createdOn, String description, InvoiceLineItem inv, Company company) {
		super(createdOn, description, inv, company);
		this.amount = amount; 
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public Double getTotal() {
		// TODO Auto-generated method stub
		return amount;
	}

}
