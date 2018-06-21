package com.ally.invoicify.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ally.invoicify.controllers.FlatFeeBillingRecordController;
import com.ally.invoicify.models.FlatFeeBillingRecord;

@RunWith(MockitoJUnitRunner.class)
public class FlatFeeBillingRecordControllerTests {
	
	@InjectMocks
    private FlatFeeBillingRecordController flatFeeBillingController;
	
	@Mock
	private FlatFeeBillingRecord flatFeeBillingRecord;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.
	}
	
	@Test
	public void testCreate() {
		
	}

}
