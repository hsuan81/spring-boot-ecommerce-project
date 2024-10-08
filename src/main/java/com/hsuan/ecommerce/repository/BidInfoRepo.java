package com.hsuan.ecommerce.repository;

import com.hsuan.ecommerce.dto.BidInfoProduct;
import com.hsuan.ecommerce.dto.RankView;
import com.hsuan.ecommerce.dto.UserBidInfo;
import com.hsuan.ecommerce.model.BidInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.math.BigDecimal;
import java.util.List;

public interface BidInfoRepo extends JpaRepository<BidInfo, Integer> {

    @Query("select SUM(b.bidMoney) from BidInfo b")
    BigDecimal calSumBidMoney();

    @Query("SELECT new com.hsuan.ecommerce.dto.RankView(u.phone, SUM(b.bidMoney)) " +
            "FROM BidInfo b " +
            "JOIN b.user u " +
            "GROUP BY u.phone " +
            "ORDER BY SUM(b.bidMoney) DESC")
    List<RankView> findUserPhoneAndTotalInvestment(Pageable pageable);

    @Query("SELECT new com.hsuan.ecommerce.dto.BidInfoProduct(b.id, u.phone, b.bidTime, b.bidMoney)" +
            " FROM BidInfo b" +
            " JOIN b.user u" +
            " WHERE b.prodId = :prodId" +
            " ORDER BY b.bidTime DESC"
    )
    List<BidInfoProduct> findBidListByProductId(int prodId, Pageable pageable);
}
