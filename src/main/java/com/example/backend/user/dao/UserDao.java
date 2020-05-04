package com.example.backend.user.dao;

import com.example.backend.user.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    List<UserVo> findList(UserVo user);

    UserVo doDetail(UserVo user);

    void create(UserVo user);

    void update(UserVo user);
}
