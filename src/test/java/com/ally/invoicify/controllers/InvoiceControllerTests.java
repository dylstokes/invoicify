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

import com.ally.invoicify.models.Invoice;
import com.ally.invoicify.repositories.InvoiceRepository;
import com.ally.invoicify.services.InvoiceServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceControllerTests {
	
	@InjectMocks
	private InvoiceServiceImpl service;
	
	@InjectMocks
	private InvoiceController controller;
	
	@Mock
	private InvoiceRepository repo;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void GetTest() throws Exception {
		// Setup variables to compare to response body
		Invoice invoice = new Invoice();
		Integer recordId = 1;
		
		// Mock functionality involved in this test case, then initialize mocks
		when(service.get(recordId)).thenReturn(invoice);
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(controller, "service", service);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		// Perform request against Mock server and assert success
		mvc.perform(
			get(String.format("/api/invoice/%d", recordId)))
			.andExpect(status().isOk());
	}
	
	@Test
	public void GetAllTest() throws Exception {
		// Setup variables to compare to response body
		List<Invoice> invoices = new ArrayList<>();
		invoices.add(new Invoice());
		invoices.add(new Invoice());
		
		// Mock functionality involved in this test case, then initialize mocks
		when(service.getAll()).thenReturn(invoices);
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(controller, "service", service);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		// Perform request against Mock server and assert success
		mvc.perform(
			get("/api/invoice"))
			.andExpect(status().isOk());
	}
}
