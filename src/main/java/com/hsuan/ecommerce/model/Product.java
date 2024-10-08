package com.hsuan.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer prodId;
    private String productName;

    private BigDecimal rate;

    private Integer cycle;

    private LocalDateTime releaseTime;

    private Integer productType;

    private String productNo;

    private BigDecimal productMoney;

    private BigDecimal leftProductMoney;

    private BigDecimal bidMinLimit;

    private BigDecimal bidMaxLimit;

    private Integer productStatus;

    private LocalDateTime productFullTime;

    private String productDesc;

    private Integer version;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<IncomeRecord> incomeRecords;


//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    private LocalDate releaseDate;
//    private String category;

    public Product() {}

    public Product(Integer id, Integer prodId, String productName, BigDecimal rate, Integer cycle, LocalDateTime releaseTime, Integer productType, String productNo, BigDecimal productMoney, BigDecimal leftProductMoney, BigDecimal bidMinLimit, BigDecimal bidMaxLimit, Integer productStatus, LocalDateTime productFullTime, String productDesc, Integer version, List<IncomeRecord> incomeRecords) {
        this.id = id;
        this.prodId = prodId;
        this.productName = productName;
        this.rate = rate;
        this.cycle = cycle;
        this.releaseTime = releaseTime;
        this.productType = productType;
        this.productNo = productNo;
        this.productMoney = productMoney;
        this.leftProductMoney = leftProductMoney;
        this.bidMinLimit = bidMinLimit;
        this.bidMaxLimit = bidMaxLimit;
        this.productStatus = productStatus;
        this.productFullTime = productFullTime;
        this.productDesc = productDesc;
        this.version = version;
        this.incomeRecords = incomeRecords;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public BigDecimal getProductMoney() {
        return productMoney;
    }

    public void setProductMoney(BigDecimal productMoney) {
        this.productMoney = productMoney;
    }

    public BigDecimal getLeftProductMoney() {
        return leftProductMoney;
    }

    public void setLeftProductMoney(BigDecimal leftProductMoney) {
        this.leftProductMoney = leftProductMoney;
    }

    public BigDecimal getBidMinLimit() {
        return bidMinLimit;
    }

    public void setBidMinLimit(BigDecimal bidMinLimit) {
        this.bidMinLimit = bidMinLimit;
    }

    public BigDecimal getBidMaxLimit() {
        return bidMaxLimit;
    }

    public void setBidMaxLimit(BigDecimal bidMaxLimit) {
        this.bidMaxLimit = bidMaxLimit;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public LocalDateTime getProductFullTime() {
        return productFullTime;
    }

    public void setProductFullTime(LocalDateTime productFullTime) {
        this.productFullTime = productFullTime;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<IncomeRecord> getIncomeRecords() {
        return incomeRecords;
    }

    public void setIncomeRecords(List<IncomeRecord> incomeRecords) {
        this.incomeRecords = incomeRecords;
    }
}
