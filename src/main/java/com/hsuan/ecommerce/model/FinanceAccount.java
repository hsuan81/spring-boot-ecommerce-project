package com.hsuan.ecommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class FinanceAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "uid")
    private User user;

    private BigDecimal availableMoney;

    public FinanceAccount() {
    }

    public FinanceAccount(Integer id, User user, BigDecimal availableMoney) {
        this.id = id;
        this.user = user;
        this.availableMoney = availableMoney;
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

    public BigDecimal getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(BigDecimal availableMoney) {
        this.availableMoney = availableMoney;
    }
}
