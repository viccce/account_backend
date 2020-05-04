package com.example.backend.account.dao;

import com.example.backend.account.vo.AccountUserRelationVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountUserRelationDao {

    void create(AccountUserRelationVo relation);
    
    void delete(AccountUserRelationVo relation);

    List<AccountUserRelationVo> findList(AccountUserRelationVo relation);
}
