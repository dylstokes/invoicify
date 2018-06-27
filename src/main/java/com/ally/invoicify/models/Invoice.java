package com.ally.invoicify.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

@Entity
@Table(name = "invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
//	@Column(name="company")
	@ManyToOne
	private Company company;
	
	@Column(name="createdOn")
	private Date createdOn;
	
	@Column(name="invoiceDescription")
	private String invoiceDescription;
	
//	@Column(name="lineItems")
	@OneToMany(mappedBy="invoice", cascade=CascadeType.ALL)
	private List<InvoiceLineItem> lineItems;
	
	@OneToOne()
	private UserLogin createdBy;
	
	public UserLogin getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User user) {
		this.createdBy = new UserLogin(user.getName(),user.getPassword());
	}

	public Invoice() {
		
	}
	
	public Invoice(Date createdOn, String description, Company company) {
		this.createdOn = createdOn;
		this.company = company;
		this.invoiceDescription = description;
		this.id = 1;
	}
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getInvoiceDescription() {
		return invoiceDescription;
	}
	public void setInvoiceDescription(String invoiceDescription) {
		this.invoiceDescription = invoiceDescription;
	}
	public List<InvoiceLineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<InvoiceLineItem> lineItems) {
		this.lineItems = lineItems;
	}
}
