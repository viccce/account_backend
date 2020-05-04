package com.example.backend.account.vo;


import java.io.Serializable;

public class AccountLineVo implements Serializable {

    private Long accountLineId;
    private Long accountId;
    private long changeMoney;


    public Long getAccountLineId() {
        return accountLineId;
    }

    public void setAccountLineId(Long accountLineId) {
        this.accountLineId = accountLineId;
    }


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }


    public long getChangeMoney() {
        return changeMoney;
    }

    public void setChangeMoney(long changeMoney) {
        this.changeMoney = changeMoney;
    }

}
