package com.hsuan.ecommerce.repository;

import com.hsuan.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("select AVG(p.rate) from Product p")
    BigDecimal calHistoryAvgRate();

    Page<Product> findByProductTypeOrderByReleaseTimeDesc(Integer productType, Pageable pageable);
    Integer countByProductType(Integer productType);
}
