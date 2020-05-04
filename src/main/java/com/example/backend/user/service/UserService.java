package com.example.backend.user.service;

import com.example.backend.user.vo.UserVo;

import java.util.List;

public interface UserService {

    UserVo login(UserVo user);

    List<UserVo> findList(UserVo user);

    UserVo doDetail(UserVo user);

    void save(UserVo user);

    void doDelete(UserVo user);
}
