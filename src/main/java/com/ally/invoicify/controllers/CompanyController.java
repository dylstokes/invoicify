package com.ally.invoicify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.Company;
import com.ally.invoicify.services.CompanyServiceImpl;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	@Autowired
	private CompanyServiceImpl service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("")
	public List<Company> getAll() {
		return service.getAll();
	}
	
	@GetMapping("{id}")
	public Company get(@PathVariable int id) {
		return service.get(id);
	}
	
	@PostMapping("")
	public Company create(@RequestBody String company) {
		return service.create(company);
	}

	@DeleteMapping("{id}")
	public Boolean delete(@PathVariable int id) {
		return service.delete(id);
	}
	
	@PutMapping("{id}")
	public Company update(@RequestBody Company company, @PathVariable int id) {
		return service.update(company, id);
	}
}
