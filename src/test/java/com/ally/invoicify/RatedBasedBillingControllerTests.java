package com.ally.invoicify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.RatedBasedBillingRecord;

@RestController
@RequestMapping("/api/billing-record/rated-based")
public class RatedBasedBillingControllerTests {
	
	@Autowired
	private RatedBasedBillingRecordRepository repo;
	
	@PostMapping("")
	public RatedBasedBillingRecord create(
			@RequestBody RatedBasedBillingRecord record) {
		return repo.save(record);
	}
}
