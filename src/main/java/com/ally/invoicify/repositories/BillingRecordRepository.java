package com.ally.invoicify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ally.invoicify.models.BillingRecord;

public interface BillingRecordRepository extends JpaRepository<BillingRecord, Integer> {

	List<BillingRecord> findByIdIn(Integer[] integers);

}
