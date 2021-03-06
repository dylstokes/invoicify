package com.ally.invoicify.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ally.invoicify.models.Company;
import com.ally.invoicify.repositories.CompanyRepository;
import com.ally.invoicify.services.CompanyServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CompanyControllerTests {
	
	@InjectMocks
	private CompanyServiceImpl service;
	
	@InjectMocks
	private CompanyController controller;
	
	@Mock
	private CompanyRepository repo;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void GetTest() throws Exception {
		// Setup variables to compare to response body
		Company company = new Company();
		Integer recordId = 1;
		
		// Mock functionality involved in this test case, then initialize mocks
		when(service.get(recordId)).thenReturn(company);
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(controller, "service", service);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		// Perform request against Mock server and assert success
		mvc.perform(
			get(String.format("/api/company/%d", recordId)))
			.andExpect(status().isOk());
	}
	
	@Test
	public void GetAllTest() throws Exception {
		// Setup variables to compare to response body
		List<Company> companies = new ArrayList<>();
		companies.add(new Company());
		companies.add(new Company());
		
		// Mock functionality involved in this test case, then initialize mocks
		when(service.getAll()).thenReturn(companies);
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(controller, "service", service);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		// Perform request against Mock server and assert success
		mvc.perform(
			get("/api/company"))
			.andExpect(status().isOk());
	}
}
