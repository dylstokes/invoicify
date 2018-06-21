package com.ally.invoicify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.Company;
import com.ally.invoicify.models.Invoice;
import com.ally.invoicify.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	private CompanyRepository companyRepo;
	
	@GetMapping("")
	public List<Company> getAll() {
		return companyRepo.findAll();
	}
	
	@GetMapping("{id}")
	public Company get(@PathVariable int id) {
		return companyRepo.findOne(id);
	}

}
