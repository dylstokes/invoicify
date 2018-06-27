package com.ally.invoicify.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="rateBasedBillingRecords")
@JsonInclude(Include.NON_NULL)
public class RateBasedBillingRecord extends BillingRecord {

	private Double rate;
	private Double quantity;
	
	public RateBasedBillingRecord() {};
	
	public RateBasedBillingRecord(Double rate, Double quantity, Date createdOn, String description, Company company) {
		super(createdOn, description, company);
		this.rate = rate; 
		this.quantity = quantity;
	}
	
	@Override
	public Double getTotal() {
		if(rate != null && quantity != null) {
			return rate * quantity;
		}
		return null;
	}
}
