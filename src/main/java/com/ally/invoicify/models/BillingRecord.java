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
	
	public abstract Double getTotal();
	
}
