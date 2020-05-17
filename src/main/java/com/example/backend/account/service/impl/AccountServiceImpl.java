package com.example.backend.account.service.impl;

import com.example.backend.account.dao.AccountDao;
import com.example.backend.account.dao.AccountLineDao;
import com.example.backend.account.dao.AccountUserRelationDao;
import com.example.backend.account.service.AccountService;
import com.example.backend.account.vo.AccountLineVo;
import com.example.backend.account.vo.AccountUserRelationVo;
import com.example.backend.account.vo.AccountVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;
    @Resource
    private AccountLineDao accountLineDao;
    @Resource
    private AccountUserRelationDao accountUserRelationDao;

    @Override
    public List<AccountVo> findList(AccountVo account) {
        return accountDao.findList(account);
    }

    @Override
    public AccountVo doDetail(AccountVo account) {
        AccountVo vo = accountDao.doDetail(account);
        if(vo != null){
            AccountLineVo param = new AccountLineVo();
            param.setAccountId(account.getAccountId());
            param.setAccountType(account.getAccountType());
            List<AccountLineVo> detailList = accountLineDao.findList(param);
            vo.setDetailList(detailList);
        }
            return vo;
    }

    @Override
    public void doSave(AccountVo account) {
        if (account.getActionType() != null && "update".equals(account.getActionType())) {
            this.update(account);
        } else {
            this.create(account);
        }
    }

    private void create(AccountVo account) {
        account.setTimestamp(System.currentTimeMillis());
        int count = accountDao.create(account);
        if (count != 0) {
            //插入关系表
            AccountUserRelationVo relation = new AccountUserRelationVo();
            relation.setAccountId(account.getAccountId());
            relation.setUserId(account.getUserId());
            relation.setActionType("create");
            this.changeUser(relation);
        }
    }

    private void update(AccountVo account) {
        account.setTimestamp(System.currentTimeMillis());
        accountDao.update(account);
        if (account.getDetailList() != null && !account.getDetailList().isEmpty()) {
            for (AccountLineVo line : account.getDetailList()) {
                accountLineDao.create(line);
            }
        }
    }

    @Override
    public void doDelete(AccountVo account) {
        int count = accountDao.delete(account);
        if (count != 0) {
            AccountLineVo line = new AccountLineVo();
            line.setAccountId(account.getAccountId());
            accountLineDao.delete(line);
            AccountUserRelationVo relation = new AccountUserRelationVo();
            relation.setAccountId(account.getAccountId());
            accountUserRelationDao.delete(relation);
        }
    }

    @Override
    public void changeUser(AccountUserRelationVo relation) {
        if (relation.getActionType() != null && "create".equals(relation.getActionType())) {
            accountUserRelationDao.create(relation);
        } else if (relation.getActionType() != null && "delete".equals(relation.getActionType())) {
            accountUserRelationDao.delete(relation);
        }
    }

    @Override
    public void doSaveDetail(AccountLineVo line) {
        line.setChangeTime(new Date());
        int count = accountLineDao.create(line);
        if(count != 0){
            AccountVo account = new AccountVo();
            account.setAccountId(line.getAccountId());
            AccountVo vo = accountDao.doDetail(account);
            vo.setBalance(vo.getBalance()+line.getChangeMoney());
            vo.setOldTimestamp(vo.getTimestamp());
            vo.setTimestamp(System.currentTimeMillis());
            accountDao.update(vo);
        }
    }

    @Override
    public List<AccountUserRelationVo> getAccountUserList(AccountUserRelationVo relation) {
        return accountUserRelationDao.findList(relation);
    }
}
