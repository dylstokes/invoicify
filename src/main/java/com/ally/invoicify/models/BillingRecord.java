package com.ally.invoicify.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="billing_records")
@JsonInclude(Include.NON_NULL)
public abstract class BillingRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="createdOn")
	private Date createdOn;
	
	@Column(name="description")
	private String description;
	
	@OneToOne()
	private UserLogin createdBy;
	
	@OneToOne(mappedBy="billingRecord")
	private InvoiceLineItem lineItem;
	
	@ManyToOne
	private Company company;
	
	public BillingRecord() {};

	public BillingRecord(Date createdOn, String description, Company company) {
		this.createdOn = createdOn;
		this.description = description;
		//this.lineItem = inv;
		this.company = company;
		//this.total = total;
		this.id = 1;
	}
	
	public UserLogin getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User user) {
		this.createdBy = new UserLogin(user.getName(),user.getPassword());
	}

	public void setTotal(Double total) {
		this.total = total;
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
	
	public void setId(Integer id) {
		this.id = id;
	}
}