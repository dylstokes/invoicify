package com.ally.invoicify.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.repositories.RateBasedBillingRecordRepository;
import com.ally.invoicify.services.RateBasedBillingRecordServiceImpl;
import com.ally.invoicify.util.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RateBasedBillingRecordControllerTests {
	
	@InjectMocks
	private RateBasedBillingRecordServiceImpl rbService;
	
	@InjectMocks
	private RateBasedBillingRecordController controller;
	
	@Mock
	private RateBasedBillingRecordRepository repo;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreate() throws Exception {
		// Setup variables to compare to response body
		RateBasedBillingRecord record = new RateBasedBillingRecord();
		
		// Mock functionality involved in this test case, then initialize mocks
		when(rbService.create(record)).thenReturn(record);
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(controller, "service", rbService);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		// Perform request against Mock server and assert success
		String requestJson = TestUtil.JsonOf(record);
		mvc.perform(
			post("/api/billing-record/rate-based")
			.contentType("application/json")
			.content(requestJson))
			.andExpect(status().isOk());
	}

}
