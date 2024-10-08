package com.hsuan.ecommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class BidInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer prodId;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    private BigDecimal bidMoney;

    private LocalDateTime bidTime;

    private Integer bidStatus;

    public BidInfo() {
    }

    public BidInfo(Integer id, Integer prodId, User user, BigDecimal bidMoney, LocalDateTime bidTime, Integer bidStatus) {
        this.id = id;
        this.prodId = prodId;
        this.user = user;
        this.bidMoney = bidMoney;
        this.bidTime = bidTime;
        this.bidStatus = bidStatus;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getBidMoney() {
        return bidMoney;
    }

    public void setBidMoney(BigDecimal bidMoney) {
        this.bidMoney = bidMoney;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }

    public Integer getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(Integer bidStatus) {
        this.bidStatus = bidStatus;
    }
}
