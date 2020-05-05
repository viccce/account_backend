package com.example.backend.account.dao;

import com.example.backend.account.vo.AccountVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountDao {

    int create(AccountVo account);

    int update(AccountVo account);

    int delete(AccountVo account);

    List<AccountVo> findList(AccountVo account);

    AccountVo doDetail(AccountVo account);
}
