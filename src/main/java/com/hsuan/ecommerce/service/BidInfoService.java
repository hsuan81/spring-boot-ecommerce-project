package com.hsuan.ecommerce.service;

import com.hsuan.ecommerce.annotation.MaskData;
import com.hsuan.ecommerce.dto.RankView;
import com.hsuan.ecommerce.dto.UserBidInfo;
import com.hsuan.ecommerce.repository.BidInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BidInfoService {

    private BidInfoRepo bidInfoRepo;

    public BidInfoService() {
    }

    @Autowired
    public BidInfoService(BidInfoRepo bidInfoRepo) {
        this.bidInfoRepo = bidInfoRepo;
    }

    @Cacheable(value = "investRankCache", key = "'investRank'")
    public List<RankView> queryInvestRank() {
        return bidInfoRepo.findUserPhoneAndTotalInvestment(PageRequest.of(0, 3));
    }
}
