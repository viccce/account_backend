package com.example.backend.account.vo;


import java.io.Serializable;
import java.util.List;

public class AccountVo implements Serializable {

    private Long accountId;
    private Long userId;
    private String accountName;
    private Long timestamp;
    private Long oldTimestamp;
    private long balance;
    private List<AccountLineVo> detailList;
    private String actionType;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<AccountLineVo> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<AccountLineVo> detailList) {
        this.detailList = detailList;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getOldTimestamp() {
        return oldTimestamp;
    }

    public void setOldTimestamp(Long oldTimestamp) {
        this.oldTimestamp = oldTimestamp;
    }
}
