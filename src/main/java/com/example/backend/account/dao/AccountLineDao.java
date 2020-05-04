package com.example.backend.account.dao;

import com.example.backend.account.vo.AccountLineVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountLineDao {

    List<AccountLineVo> findList(AccountLineVo line);

    void create(AccountLineVo line);

    void update(AccountLineVo line);

    void delete(AccountLineVo line);
}
