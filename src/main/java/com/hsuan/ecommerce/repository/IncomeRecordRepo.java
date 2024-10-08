package com.hsuan.ecommerce.repository;

import com.hsuan.ecommerce.model.IncomeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRecordRepo extends JpaRepository<IncomeRecord, Integer> {
}
