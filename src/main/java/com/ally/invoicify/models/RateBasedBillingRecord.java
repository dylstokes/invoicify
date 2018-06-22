package com.ally.invoicify.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="rateBasedBillingRecords")
public class RateBasedBillingRecord extends BillingRecord {

	private Double rate;
	private Double quantity;
	
	public RateBasedBillingRecord() {
		super();
	};
	
	public RateBasedBillingRecord(Double rate, Double quantity, Date createdOn, String description, InvoiceLineItem inv, Company company, Double total) {
		super(createdOn, description, inv, company, total);
		this.rate = rate; 
		this.quantity = quantity;
	}
	
	@Override
	public Double getTotal() {
		// TODO Auto-generated method stub
		return rate*quantity;
	}
}
