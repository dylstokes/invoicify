package com.ally.invoicify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ally.invoicify.models.RateBasedBillingRecord;

public interface RateBasedBillingRecordRepository extends JpaRepository<RateBasedBillingRecord, Integer> {

}
