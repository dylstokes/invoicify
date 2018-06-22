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

import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.repositories.BillingRecordRepository;
import com.ally.invoicify.services.BillingRecordServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BillingRecordControllerTests {
	
	@InjectMocks
	private BillingRecordServiceImpl service;
	
	@InjectMocks
	private BillingRecordController controller;
	
	@Mock
	private BillingRecordRepository repo;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void GetTest() throws Exception {
		// Setup variables to compare to response body
		RateBasedBillingRecord record = new RateBasedBillingRecord();
		Integer recordId = 1;
		
		// Mock functionality involved in this test case, then initialize mocks
		when(service.get(recordId)).thenReturn(record);
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(controller, "service", service);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		// Perform request against Mock server and assert success
		mvc.perform(
			get(String.format("/api/billing-record/%d", recordId)))
			.andExpect(status().isOk());
	}
	
	@Test
	public void GetAllTest() throws Exception {
		// Setup variables to compare to response body
		List<BillingRecord> records = new ArrayList<>();
		records.add(new RateBasedBillingRecord());
		records.add(new RateBasedBillingRecord());
		
		// Mock functionality involved in this test case, then initialize mocks
		when(service.getAll()).thenReturn(records);
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(controller, "service", service);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		// Perform request against Mock server and assert success
		mvc.perform(
			get("/api/billing-record"))
			.andExpect(status().isOk());
	}
}
