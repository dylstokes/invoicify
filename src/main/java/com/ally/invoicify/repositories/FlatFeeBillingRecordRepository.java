package com.ally.invoicify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ally.invoicify.models.FlatFeeBillingRecord;

public interface FlatFeeBillingRecordRepository extends JpaRepository<FlatFeeBillingRecord, Integer> {

}
