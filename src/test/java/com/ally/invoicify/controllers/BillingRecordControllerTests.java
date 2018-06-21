package com.ally.invoicify.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ally.invoicify.controllers.BillingRecordController;
import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.models.Company;
import com.ally.invoicify.models.Invoice;
import com.ally.invoicify.models.InvoiceLineItem;
import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.repositories.BillingRecordRepository;
import com.ally.invoicify.services.BillingRecordServiceImpl;
import com.ally.invoicify.services.RateBasedBillingRecordServiceImpl;

//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BillingRecordControllerTests {
	
	@InjectMocks
	private BillingRecordController controller;
	
	@InjectMocks
	private BillingRecordServiceImpl service;
	
	@InjectMocks
	private RateBasedBillingRecordServiceImpl rbService;
	
	@Mock
	private BillingRecordRepository repo;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void GetTest() throws Exception {
		//Date createdOn, String description, InvoiceLineItem inv, Company company
		Date date = new java.sql.Date(new SimpleDateFormat("MM-dd-yyyy").parse("02-04-2015").getTime());
		Company company = new Company();
		Integer recordId = 1;
		RateBasedBillingRecord record = new RateBasedBillingRecord(
						10.0, 
						10.0, 
						date, 
						"A new invoice", 
						new InvoiceLineItem(date, new Invoice(date, "A new invoice", company)), 
						company);
		when(rbService.create(record)).thenReturn(record);
		when(service.get(recordId)).thenReturn((BillingRecord)record);
		BillingRecord createdRecord = (BillingRecord)rbService.create(record);
		assertEquals(mvc.perform(
				get(String.format("/api/billing-records/%d"), recordId))
				.andReturn()
				.getResponse()
				.getStatus(), 200);
		service.delete(createdRecord.getId());
	}
	
	@Test
	public void GetAllTest() {
		 
	}
}
