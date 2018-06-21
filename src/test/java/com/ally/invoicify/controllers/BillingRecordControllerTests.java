package com.ally.invoicify.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
import com.ally.invoicify.repositories.RateBasedBillingRecordRepository;
import com.ally.invoicify.services.BillingRecordServiceImpl;
import com.ally.invoicify.services.RateBasedBillingRecordServiceImpl;

//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BillingRecordControllerTests {
	
	//@InjectMocks
	private BillingRecordController controller = new BillingRecordController();
	
	@InjectMocks
	private BillingRecordServiceImpl service;
	
	@InjectMocks
	private RateBasedBillingRecordServiceImpl rbService;
	
	@Mock
	private RateBasedBillingRecordRepository rbRepo;
	
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
		
	}
	
	@Test
	public void GetAllTest() {
		 
	}
}
