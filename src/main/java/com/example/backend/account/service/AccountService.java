package com.example.backend.account.service;

import com.example.backend.account.vo.AccountLineVo;
import com.example.backend.account.vo.AccountUserRelationVo;
import com.example.backend.account.vo.AccountVo;

import java.util.List;

public interface AccountService {

    List<AccountVo> findList(AccountVo account);

    AccountVo doDetail(AccountVo account);

    void doSave(AccountVo account);

    void doDelete(AccountVo account);

    void changeUser(AccountUserRelationVo relation);

    void doSaveDetail(AccountLineVo line);

    List<AccountUserRelationVo> getAccountUserList(AccountUserRelationVo relation);
}
