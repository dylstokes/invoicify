package com.ally.invoicify;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ally.invoicify.controllers.BillingRecordController;
import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.repositories.BillingRecordRepository;
import com.ally.invoicify.services.BillingRecordServiceImpl;
import com.ally.invoicify.services.RateBasedBillingRecordServiceImpl;

@RunWith(SpringRunner.class)
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
		RateBasedBillingRecord record = new RateBasedBillingRecord(10.0, 10.0);
		BillingRecord createdRecord = (BillingRecord)rbService.create(record);
		assertEquals(mvc.perform(
				get(String.format("/api/billing-records/%d"), createdRecord.getId()))
				.andReturn()
				.getResponse()
				.getStatus(), 200);
		service.delete(createdRecord.getId());
	}
	
	@Test
	public void GetAllTest() {
		 
	}
}
