package com.example.backend.account.dao;

import com.example.backend.account.vo.AccountLineVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountLineDao {

    List<AccountLineVo> findList(AccountLineVo line);

    int create(AccountLineVo line);

    int update(AccountLineVo line);

    int delete(AccountLineVo line);
}
