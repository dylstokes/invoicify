package com.ally.invoicify.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="flatFeeBillingRecords")
public class FlatFeeBillingRecord extends BillingRecord {
	
	private double amount;
	
	public FlatFeeBillingRecord() {
		
	}
	
	public FlatFeeBillingRecord(double amount) {
		this.amount = amount; 
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		return amount;
	}

}
