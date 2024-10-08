package com.hsuan.ecommerce.dto.response;

import java.math.BigDecimal;

public class BaseInfoResponse {
    private Long registerUsers;
    private BigDecimal historyAvgRate;
    private BigDecimal sumBidMoney;

    public BaseInfoResponse() {
    }

    public BaseInfoResponse(BigDecimal historyAvgRate, BigDecimal sumBidMoney, Long registerUsers) {
        this.historyAvgRate = historyAvgRate;
        this.sumBidMoney = sumBidMoney;
        this.registerUsers = registerUsers;
    }

    public Long getRegisterUsers() {
        return registerUsers;
    }

    public void setRegisterUsers(Long registerUsers) {
        this.registerUsers = registerUsers;
    }

    public BigDecimal getHistoryAvgRate() {
        return historyAvgRate;
    }

    public void setHistoryAvgRate(BigDecimal historyAvgRate) {
        this.historyAvgRate = historyAvgRate;
    }

    public BigDecimal getSumBidMoney() {
        return sumBidMoney;
    }

    public void setSumBidMoney(BigDecimal sumBidMoney) {
        this.sumBidMoney = sumBidMoney;
    }
}
