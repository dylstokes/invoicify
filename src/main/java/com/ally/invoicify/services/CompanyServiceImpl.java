package com.ally.invoicify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.invoicify.models.Company;
import com.ally.invoicify.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl {
	@Autowired
	private CompanyRepository repo;
	
	public CompanyServiceImpl(CompanyRepository repo) {
		this.repo = repo;
	}
	
	public Company create(Company company) {
		return repo.save(company);
	}
	
	public Company get(Integer id) {
		return repo.findOne(id);
	}
	
	public List<Company> getAll() {
		return repo.findAll();
	}
	
	public boolean delete(Integer id) {
		Company record = repo.findOne(id);
		repo.delete(id);
		return record != null;
	}

	public Company update(Company company, int id) {
		company.setId(id);
		return company;
	}
}