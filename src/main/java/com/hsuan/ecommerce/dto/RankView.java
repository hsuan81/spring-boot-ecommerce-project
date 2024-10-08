package com.hsuan.ecommerce.dto;

import com.hsuan.ecommerce.annotation.MaskData;

import java.io.Serializable;
import java.math.BigDecimal;

public class RankView implements Serializable {

    private static final long serialVersionUID = 1L;  // recommended for Serializable classes

    @MaskData
    private String phone;
    private BigDecimal money;

    public RankView() {
    }

    public RankView(String phone, BigDecimal money) {
        this.phone = phone;
        this.money = money;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
