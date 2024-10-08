package com.hsuan.ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BidInfoProduct {
    public Integer id;
    public String phone;
    public LocalDateTime bidTime;
    public BigDecimal bidMoney;

    public BidInfoProduct() {
    }

    public BidInfoProduct(Integer id, String phone, LocalDateTime bidTime, BigDecimal bidMoney) {
        this.id = id;
        this.phone = phone;
        this.bidTime = bidTime;
        this.bidMoney = bidMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }

    public BigDecimal getBidMoney() {
        return bidMoney;
    }

    public void setBidMoney(BigDecimal bidMoney) {
        this.bidMoney = bidMoney;
    }
}
