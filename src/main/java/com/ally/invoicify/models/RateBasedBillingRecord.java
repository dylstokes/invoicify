package com.ally.invoicify.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="rateBasedBillingRecords")
public class RateBasedBillingRecord extends BillingRecord {

	private Double rate;
	private Double quantity;
	
	public RateBasedBillingRecord() {
		
	}
	
	public RateBasedBillingRecord(Double rate, Double quantity) {
		this.rate = rate; 
		this.quantity = quantity;
	}
	
	@Override
	public Double getTotal() {
		// TODO Auto-generated method stub
		return rate*quantity;
	}
}
