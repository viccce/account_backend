package com.example.backend.account.dao;

import com.example.backend.account.vo.AccountVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountDao {

    void create(AccountVo account);

    void update(AccountVo account);

    void delete(AccountVo account);

    List<AccountVo> findList(AccountVo account);

    AccountVo doDetail(AccountVo account);
}
