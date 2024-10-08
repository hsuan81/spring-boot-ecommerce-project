package com.hsuan.ecommerce.dto.response;

import com.hsuan.ecommerce.dto.BidInfoProduct;
import com.hsuan.ecommerce.model.Product;

import java.util.List;

public class ProductAndBidListResponse {
    public Product product;
    public List<BidInfoProduct> bidInfoProductList;

    public ProductAndBidListResponse() {
    }

    public ProductAndBidListResponse(Product product, List<BidInfoProduct> bidInfoProductList) {
        this.product = product;
        this.bidInfoProductList = bidInfoProductList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<BidInfoProduct> getBidInfoProductList() {
        return bidInfoProductList;
    }

    public void setBidInfoProductList(List<BidInfoProduct> bidInfoProductList) {
        this.bidInfoProductList = bidInfoProductList;
    }
}
