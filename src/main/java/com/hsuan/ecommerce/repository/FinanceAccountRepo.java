package com.hsuan.ecommerce.repository;

import com.hsuan.ecommerce.model.FinanceAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceAccountRepo extends JpaRepository<FinanceAccount, Integer> {
}
