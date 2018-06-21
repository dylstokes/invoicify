package com.ally.invoicify.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ally.invoicify.models.InvoiceLineItem;

@Entity
@Table(name="billing_records")
public abstract class BillingRecord {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name="createdOn")
	private Date createdOn;
	
	@Column(name="description")
	private String description;
	
	@OneToOne(mappedBy="billingRecord")
	private InvoiceLineItem lineItem;
	
	@ManyToOne
	private Company company;
	
	public BillingRecord(Date createdOn, String description, InvoiceLineItem inv, Company company) {
		this.createdOn = createdOn;
		this.description = description;
		this.lineItem = inv;
		this.company = company;
	}
	
	public abstract Double getTotal();
	
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public InvoiceLineItem getLineItem() {
		return lineItem;
	}

	public void setLineItem(InvoiceLineItem lineItem) {
		this.lineItem = lineItem;
	}
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getId() {
		return id;
	}
	
}
