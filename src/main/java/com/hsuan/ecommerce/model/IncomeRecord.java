package com.hsuan.ecommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class IncomeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "prodId")
    private Product product;

    private Integer bidId;

    private BigDecimal bidMoney;

    private LocalDate incomeDate;

    private BigDecimal incomeMoney;

    private Integer incomeStatus;

    public IncomeRecord() {
    }

    public IncomeRecord(Integer id, User user, Product product, Integer bidId, BigDecimal bidMoney, LocalDate incomeDate, BigDecimal incomeMoney, Integer incomeStatus) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.bidId = bidId;
        this.bidMoney = bidMoney;
        this.incomeDate = incomeDate;
        this.incomeMoney = incomeMoney;
        this.incomeStatus = incomeStatus;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public BigDecimal getBidMoney() {
        return bidMoney;
    }

    public void setBidMoney(BigDecimal bidMoney) {
        this.bidMoney = bidMoney;
    }

    public LocalDate getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(LocalDate incomeDate) {
        this.incomeDate = incomeDate;
    }

    public BigDecimal getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(BigDecimal incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public Integer getIncomeStatus() {
        return incomeStatus;
    }

    public void setIncomeStatus(Integer incomeStatus) {
        this.incomeStatus = incomeStatus;
    }
}
