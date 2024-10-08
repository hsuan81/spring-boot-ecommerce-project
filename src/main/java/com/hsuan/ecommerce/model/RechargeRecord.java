package com.hsuan.ecommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class RechargeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    private String rechargeNo;

    private Integer rechargeStatus;

    private BigDecimal rechargeMoney;

    private LocalDateTime rechargeTime;

    private String rechargeDesc;

    private String channel;

    public RechargeRecord() {
    }

    public RechargeRecord(Integer id, User user, String rechargeNo, Integer rechargeStatus, BigDecimal rechargeMoney, LocalDateTime rechargeTime, String rechargeDesc, String channel) {
        this.id = id;
        this.user = user;
        this.rechargeNo = rechargeNo;
        this.rechargeStatus = rechargeStatus;
        this.rechargeMoney = rechargeMoney;
        this.rechargeTime = rechargeTime;
        this.rechargeDesc = rechargeDesc;
        this.channel = channel;
    }

    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRechargeNo() {
        return rechargeNo;
    }

    public void setRechargeNo(String rechargeNo) {
        this.rechargeNo = rechargeNo;
    }

    public Integer getRechargeStatus() {
        return rechargeStatus;
    }

    public void setRechargeStatus(Integer rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
    }

    public BigDecimal getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(BigDecimal rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public LocalDateTime getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(LocalDateTime rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public String getRechargeDesc() {
        return rechargeDesc;
    }

    public void setRechargeDesc(String rechargeDesc) {
        this.rechargeDesc = rechargeDesc;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
