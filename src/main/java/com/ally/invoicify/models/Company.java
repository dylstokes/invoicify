package com.ally.invoicify.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="companies")
public class Company {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="company")
	private String name;
	
	@OneToMany(mappedBy="company", cascade=CascadeType.ALL)
	private List<Invoice> invoices;
	
	public Company() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
