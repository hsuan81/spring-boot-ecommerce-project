package com.hsuan.ecommerce.service;

import com.hsuan.ecommerce.common.Util;
import com.hsuan.ecommerce.dto.BidInfoProduct;
import com.hsuan.ecommerce.dto.response.ProductAndBidListResponse;
import com.hsuan.ecommerce.model.Product;
import com.hsuan.ecommerce.repository.BidInfoRepo;
import com.hsuan.ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestService {

    private ProductRepo productRepo;
    private BidInfoRepo bidInfoRepo;

    public InvestService() {
    }

    @Autowired
    public InvestService(ProductRepo productRepo, BidInfoRepo bidInfoRepo) {
        this.productRepo = productRepo;
        this.bidInfoRepo = bidInfoRepo;
    }

    public ProductAndBidListResponse queryBidListByProductId(Integer prodId, Integer pageNo, Integer pageSize) {
        // get product by the given id
        // if the product of the id found, get bid history and return with the product info
        // else return no product found and error message
        Product product = productRepo.findById(prodId).orElse(null);
        ProductAndBidListResponse result = new ProductAndBidListResponse();
        if (product != null) {
            pageNo = Util.defaultPageNo(pageNo);
            pageSize = Util.defaultPageSize(pageSize);
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            List<BidInfoProduct> bidList = bidInfoRepo.findBidListByProductId(prodId, pageable);
            result.setProduct(product);
            result.setBidInfoProductList(bidList);
        }
        return result;
    }
}
