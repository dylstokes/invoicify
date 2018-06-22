package com.ally.invoicify.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.util.ReflectionTestUtils;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ally.invoicify.models.Company;
import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.repositories.BillingRecordRepository;
import com.ally.invoicify.repositories.RateBasedBillingRecordRepository;
import com.ally.invoicify.services.BillingRecordServiceImpl;
import com.ally.invoicify.services.RateBasedBillingRecordServiceImpl;

//@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BillingRecordControllerTests {
	
//	@Autowired
//	private WebApplicationContext wac;

	@InjectMocks
	private RateBasedBillingRecordServiceImpl rbService;
	
	@InjectMocks
	private BillingRecordServiceImpl service;
	
	@InjectMocks
	private BillingRecordController controller;
	
	@Mock
	private RateBasedBillingRecordRepository rbRepo;
	
	@Mock
	private BillingRecordRepository repo;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	    ReflectionTestUtils.setField(controller, "service", service);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		//mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		//Processor processor = Mockito.mock(Processor.class);
	}
	
	@Test
	public void GetTest() throws Exception {
		Date date = new java.sql.Date(new SimpleDateFormat("MM-dd-yyyy").parse("02-04-2015").getTime());
		Company company = new Company();
		Integer recordId = 1;
		RateBasedBillingRecord record = new RateBasedBillingRecord(
//						10.0, 
//						10.0, 
//						date, 
//						"A new invoice", 
//						new InvoiceLineItem(date, new Invoice(date, "A new invoice", company)), 
//						company
						);
		//when(rbService.create(record)).thenReturn(record);
		//when(rbRepo.save(record)).thenReturn(record);
		when(service.get(recordId)).thenReturn(record);
		//when(repo.findOne(recordId)).thenReturn((BillingRecord)record);
		// BillingRecord createdRecord = (BillingRecord)rbService.create(record);
		mvc.perform(
				get(String.format("/api/billing-record/%d", recordId)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void GetAllTest() {
		 
	}
}
