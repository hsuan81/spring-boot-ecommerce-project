package com.hsuan.ecommerce.dto;

import com.hsuan.ecommerce.model.Product;

import java.util.List;

public class ProductsAndPageInfo {
    // List of products
    private List<Product> productList;
    // current page number
    private Integer pageNo;
    // number of products per page
    private Integer pageSize;
    // total page
    private Integer totalPage;
    // total number of products
    private long totalRecord;

    public ProductsAndPageInfo() {
    }

    public ProductsAndPageInfo(List<Product> productList, Integer pageNo, Integer pageSize, Integer totalPage, long totalRecord) {
        this.productList = productList;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalRecord = totalRecord;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }
}
