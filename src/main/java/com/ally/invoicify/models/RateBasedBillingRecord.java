package com.ally.invoicify.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="rateBasedBillingRecords")
public class RateBasedBillingRecord extends BillingRecord {

	private double rate;
	private double quantity;
	
	public RateBasedBillingRecord() {
		
	}
	
	public RateBasedBillingRecord(double rate, double quantity) {
		this.rate = rate; 
		this.quantity = quantity;
	}
	
	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		return rate*quantity;
	}
}
