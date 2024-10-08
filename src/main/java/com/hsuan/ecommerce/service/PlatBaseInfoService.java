package com.hsuan.ecommerce.service;

import com.hsuan.ecommerce.dto.response.BaseInfoResponse;
import com.hsuan.ecommerce.repository.BidInfoRepo;
import com.hsuan.ecommerce.repository.ProductRepo;
import com.hsuan.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PlatBaseInfoService {

    private UserRepo userRepo;
    private ProductRepo productRepo;
    private BidInfoRepo bidInfoRepo;

    @Autowired
    public PlatBaseInfoService(UserRepo userRepo, ProductRepo productRepo, BidInfoRepo bidInfoRepo) {
        this.userRepo = userRepo;
        this.productRepo = productRepo;
        this.bidInfoRepo = bidInfoRepo;
    }

    public BaseInfoResponse getPlantBaseInfo() {
        Long registerUsers = userRepo.count();
        BigDecimal historyAvgRate = productRepo.calHistoryAvgRate();
        BigDecimal sumBidMoney = bidInfoRepo.calSumBidMoney();
        return new BaseInfoResponse(historyAvgRate, sumBidMoney, registerUsers);

    }
}
