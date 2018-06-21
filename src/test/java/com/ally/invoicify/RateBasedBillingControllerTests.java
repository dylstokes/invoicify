package com.ally.invoicify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.repositories.RateBasedBillingRecordRepository;

@RestController
@RequestMapping("/api/billing-record/rated-based")
public class RateBasedBillingControllerTests {
	
	@Autowired
	private RateBasedBillingRecordRepository repo;
	
	@PostMapping("")
	public RateBasedBillingRecord create(
			@RequestBody RateBasedBillingRecord record) {
		return repo.save(record);
	}
}
