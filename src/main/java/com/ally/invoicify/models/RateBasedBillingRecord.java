package com.ally.invoicify.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="rateBasedBillingRecords")
public class RateBasedBillingRecord extends BillingRecord {
	
	@Column(name="rate")
	private Double rate;
	@Column(name="quantity")
	private Double quantity;
	
	public RateBasedBillingRecord(Double rate, Double quantity, Date createdOn, String description, InvoiceLineItem inv, Company company) {
		super(createdOn, description, inv, company);
		this.rate = rate; 
		this.quantity = quantity;
	}
	
	@Override
	public Double getTotal() {
		// TODO Auto-generated method stub
		return rate*quantity;
	}
}
