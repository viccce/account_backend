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
        return null;
    }

    @Override
    public void doSave(AccountVo account) {
        if(account.getActionType() != null && "update".equals(account.getActionType())){
            this.update(account);
        }else{
            this.create(account);
        }
    }

    private void create(AccountVo account) {
        accountDao.create(account);
        //插入关系表
        AccountUserRelationVo relation = new AccountUserRelationVo();
        relation.setAccountId(account.getAccountId());
        relation.setUserId(account.getUserId());
        relation.setActionType("create");
        this.changeUser(relation);
    }

    private void update(AccountVo account) {
        accountDao.update(account);
        if(account.getDetailList() != null && !account.getDetailList().isEmpty()){
            for(AccountLineVo line : account.getDetailList()){
                accountLineDao.create(line);
            }
        }
    }

    @Override
    public void doDelete(AccountVo account) {
        accountDao.delete(account);
        AccountLineVo line = new AccountLineVo();
        line.setAccountId(account.getAccountId());
        accountLineDao.delete(line);
        AccountUserRelationVo relation = new AccountUserRelationVo();
        relation.setAccountId(account.getAccountId());
        accountUserRelationDao.delete(relation);
    }

    @Override
    public void changeUser(AccountUserRelationVo relation) {
        if(relation.getActionType() != null && "create".equals(relation.getActionType())){
            accountUserRelationDao.create(relation);
        }else if(relation.getActionType() != null && "delete".equals(relation.getActionType())){
            accountUserRelationDao.delete(relation);
        }
    }
}
