package com.ally.invoicify.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="flatFeeBillingRecords")
@JsonInclude(Include.NON_NULL)
public class FlatFeeBillingRecord extends BillingRecord {
	
	private Double amount;
	
	public FlatFeeBillingRecord() {}
	
	public FlatFeeBillingRecord(Double amount, Date createdOn, String description, InvoiceLineItem inv, Company company, Double total) {
		super(createdOn, description, inv, company, total);
		this.amount = amount; 
	}

	public Double getAmount() {
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
