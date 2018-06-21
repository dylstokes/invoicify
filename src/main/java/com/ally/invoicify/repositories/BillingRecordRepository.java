package com.ally.invoicify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ally.invoicify.models.BillingRecord;

public interface BillingRecordRepository extends JpaRepository<BillingRecord, Integer> {

}
